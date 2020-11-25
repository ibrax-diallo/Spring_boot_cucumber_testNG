package com.test.ibrax.services;

import com.test.ibrax.documents.User;
import com.test.ibrax.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * @author Ibrahima Diallo <ibrahima.diallo2@supinfo.com>
 */

@Service
public class UserService extends BaseService<User, UserRepository, String> implements IUserService {

    @Autowired
    public UserService(final UserRepository repository) {
        super(repository);
    }


    public User findByUsername(final String userName) {
        return this.repository.findByUsername(userName);
    }

    @Override
    public User login(String username, String password) {
        return this.repository.findByUsernameAndPassword(username, password);
    }


}
