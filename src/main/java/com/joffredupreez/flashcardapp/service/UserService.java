package com.joffredupreez.flashcardapp.service;

import com.joffredupreez.flashcardapp.model.User;
import com.joffredupreez.flashcardapp.respository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserService {
    @Autowired
    private UserRepository userRepository;
    private Logger logger = LoggerFactory.getLogger(UserService.class);

    public void createUser(String username, String password ) {
        userRepository.save(new User(username, password, "USER")); // TO-DO: fix hardcoded value for the user role
    }
}
