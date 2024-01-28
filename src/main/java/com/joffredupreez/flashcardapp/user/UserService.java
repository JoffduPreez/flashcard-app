package com.joffredupreez.flashcardapp.user;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.joffredupreez.flashcardapp.service.UserJpaAccess;

@Component
public class UserService {
    @Autowired
    private UserJpaAccess jpaAccess;
    private Logger logger = LoggerFactory.getLogger(UserService.class);

    public void createUser(String username, String password ) {
        jpaAccess.save(new User(username, password));
    }
}
