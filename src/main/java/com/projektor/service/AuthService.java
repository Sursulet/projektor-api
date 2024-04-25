package com.projektor.service;

import com.projektor.entity.User;
import com.projektor.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


@Service
public class AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    // Constructor injection
    @Autowired
    public AuthService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    // Method to authenticate user
    public boolean authenticateUser(String email, String password) {
        // Find user by email
        var user = userRepository.findByEmail(email);

        // Check if user exists and password matches
        return (user.isPresent() && passwordEncoder.matches(password, user.get().getPassword()));
    }
}
