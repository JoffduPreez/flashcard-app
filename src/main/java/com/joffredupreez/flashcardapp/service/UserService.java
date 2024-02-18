package com.joffredupreez.flashcardapp.service;

import com.joffredupreez.flashcardapp.model.User;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
import com.joffredupreez.flashcardapp.respository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class UserService {
    @Autowired
    private UserRepository userRepository;
    
    @Autowired
    private PasswordEncoder encoder;

    private Logger logger = LoggerFactory.getLogger(UserService.class);

    public void createUser(String username, String email, String password) throws IllegalArgumentException {
        if (username == null || email == null || password == null) {
            throw new IllegalArgumentException("Username, email, and password are required");
        }

        // email must have a valid format
        if (!emailValidator(email)) {
            throw new IllegalArgumentException("Invalid email format");
        }

        // username must be unique
        if (userRepository.findByUsername(username) != null) {
            throw new IllegalArgumentException("Username already exists");
        }

        // email must be unique
        if (userRepository.findByEmail(email) != null) {
            throw new IllegalArgumentException("Email already exists");
        }

        userRepository.save(new User(username, email, encoder.encode(password), "USER")); // TO-DO: fix hardcoded value for the user role
    }

    public boolean emailValidator(String email) throws IllegalArgumentException {
        // Regular expression for validating email address
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
        Pattern emailPattern = Pattern.compile(emailRegex);

        Matcher matcher = emailPattern.matcher(email);
        return matcher.matches();
    }
}
