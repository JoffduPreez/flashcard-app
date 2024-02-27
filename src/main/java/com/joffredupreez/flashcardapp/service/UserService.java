package com.joffredupreez.flashcardapp.service;

import com.joffredupreez.flashcardapp.model.User;

import java.io.UnsupportedEncodingException;
import java.util.regex.Pattern;
import java.security.SecureRandom;
import java.util.Random;
import java.util.regex.Matcher;
import com.joffredupreez.flashcardapp.respository.UserRepository;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class UserService {
    @Autowired
    private UserRepository userRepository;
    
    @Autowired
    private PasswordEncoder encoder;

    private Logger logger = LoggerFactory.getLogger(UserService.class);

    @Autowired
    private JavaMailSender mailSender;

    public void createUser(String username, String email, String password, String contextPath) throws IllegalArgumentException, MessagingException, UnsupportedEncodingException {
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

        String emailVerificationCode = generateRandomString(32);
        logger.info(emailVerificationCode);

        User newUser = new User(username, email, encoder.encode(password), "USER", emailVerificationCode, false);
        userRepository.save(newUser); // TO-DO: fix hardcoded value for the user role
        
         sendVerificationEmail(newUser, contextPath);
    }

    public boolean emailValidator(String email) throws IllegalArgumentException {
        // Regular expression for validating email address
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
        Pattern emailPattern = Pattern.compile(emailRegex);

        Matcher matcher = emailPattern.matcher(email);
        return matcher.matches();
    }

    private void sendVerificationEmail(User user, String contextPath) throws MessagingException, UnsupportedEncodingException {
        String toAddress = user.getEmail();
        String fromAddress = "flashfocusupdates@gmail.com\n";
        String senderName = "Flash Focus";
        String subject = "Please verify your registration";
        String content = "Dear [[name]],<br>"
                + "Please click the link below to verify your registration:<br>"
                + "<h3><a href=\"[[URL]]\" target=\"_self\">VERIFY</a></h3>"
                + "Thank you,<br>"
                + "Your company name.";

        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message);

        helper.setFrom(fromAddress, senderName);
        helper.setTo(toAddress);
        helper.setSubject(subject);

        content = content.replace("[[name]]", user.getUsername());
        String verifyURL = contextPath + "/verify?code=" + user.getEmailVerificationCode();
        content = content.replace("[[URL]]", verifyURL);

        helper.setText(content, true);
        mailSender.send(message);
    }

    public String generateRandomString(int length) {
        if (length <= 0) throw new IllegalArgumentException("Length must be a positive number.");

        int leftLimit = 48; // numeral '0'
        int rightLimit = 122; // letter 'z'
        Random random = new SecureRandom();
        String generatedString = random.ints(leftLimit, rightLimit + 1)
          .filter(i -> (i <= 57 || i >= 65) && (i <= 90 || i >= 97))
          .limit(length)
          .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
          .toString();

        return generatedString;
    }
}
