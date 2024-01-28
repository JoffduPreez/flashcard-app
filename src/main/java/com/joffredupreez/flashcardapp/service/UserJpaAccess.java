package com.joffredupreez.flashcardapp.service;

import com.joffredupreez.flashcardapp.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserJpaAccess extends JpaRepository<User, Long> {
}
