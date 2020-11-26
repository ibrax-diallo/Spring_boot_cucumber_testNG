package com.test.ibrax.bdd;

import com.test.ibrax.documents.User;
import com.test.ibrax.repositories.UserRepository;
import io.cucumber.java.en.Given;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author Ibrahima Diallo <ibrahima.diallo2@university-365.com>
 */
public class UserStepDefinitions {
    @Autowired
    private UserRepository userRepository;

    private User currentUser;

    @Given("get user")
    public void createUser() {
        currentUser = userRepository.save(new User("ibrax", "123456"));
    }

    public User getCurrentUser() {
        return currentUser;
    }
}
