package com.joffredupreez.flashcardapp.service;

import com.joffredupreez.flashcardapp.user.User;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserJpaAccess extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
