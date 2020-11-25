package com.test.ibrax.controllers;

import com.test.ibrax.documents.User;
import com.test.ibrax.dto.request.LoginDTO;
import com.test.ibrax.dto.response.DefaultResponse;
import com.test.ibrax.services.IUserService;
import com.test.ibrax.validators.UserValidators;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @author Ibrahima Diallo <ibrahima.diallo2@university-365.com>
 */
@RestController
@RequestMapping("/api/v1/users")
public class UserController extends BaseController<User, IUserService, String> {
    private final UserValidators userValidators;

    public UserController(IUserService service, UserValidators userValidators) {
        super(service);
        this.userValidators = userValidators;
    }

    @PostMapping("/signup")
    public ResponseEntity<?> signUp(@RequestBody final User dto) {
        String userValidate = userValidators.create(dto);
        if (userValidate != null) {
            return new ResponseEntity<>(new DefaultResponse(userValidate), HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(this.service.create(dto), HttpStatus.OK);
    }

    @PostMapping("/login")
    public ResponseEntity<?> authenticate(@RequestBody final LoginDTO dto) {
        final User user = this.service.login(dto.getUsername(), dto.getPassword());
        if (user != null) {
            return new ResponseEntity<>(user, HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Authentication failed", HttpStatus.UNAUTHORIZED);
        }
    }
}
