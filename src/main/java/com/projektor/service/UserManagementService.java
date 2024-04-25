package com.projektor.service;

import com.projektor.entity.User;
import com.projektor.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

// the services related to the User managing services

@Service
public class UserManagementService {
    private final UserRepository userRepository ;

    @Autowired
    public UserManagementService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // List all users
    public List<User> getAllUsers() {
         return userRepository.findAll();
    }

    //selecting a user by his ID
    public User getUserById(int id) {
        return this.userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found with id: " + id));
    }

    // Method to create a new User
    public void createUserService(User u){
        userRepository.save(u);
    }

    // Method to udate a User
    public void updateUserService(User u){
        userRepository.save(u);
    }

    // Method to delete a User
    public void deleteUserService(User u){
        userRepository.delete(u);
    }

    // Method to get a User by his email
    public User getUserByEmail(String email) {
        return userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("User not found with email: " + email));
    }

    // Method to get users by name
    public List<User> getUserByLastName(String name) {
        return userRepository.findByLastName(name);
    }

    public User save(User user) {
        return userRepository.save(user);
    }

    public Optional<User> findById(Integer id) {
        return userRepository.findById(id);
    }

}

