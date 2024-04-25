package com.projektor.service;

import com.projektor.entity.Role;
import com.projektor.entity.User;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
@Rollback(true)
class UserManagementServiceTest {

    @Autowired
    private UserManagementService userManagementService;

    @Test
    void testPikachuExists() {
        // Test to verify that Pikachu exists
        String pikachuEmail = "pikachu@example.com";
        assertNotNull(userManagementService.getUserByEmail(pikachuEmail));
    }

    @Test
    void testUserDoesNotExist() {
        // Test when a user doesn't exist
        String nonExistingEmail = "nonexisting@example.com";
        assertThrows(RuntimeException.class, () -> userManagementService.getUserByEmail(nonExistingEmail));
    }

    @Test
    void testSaveUserMissingFirstName() {
        // Test when the first name is missing
        User user = new User();
        user.setLastName("Lastname");
        user.setEmail("missingfirstname@example.com");
        user.setRole(Role.CLIENT.toString().toLowerCase());
        assertThrows(Exception.class, () -> userManagementService.createUserService(user));
    }

    @Test
    void testSaveUserMissingLastName() {
        // Test when the last name is missing
        User user = new User();
        user.setFirstName("Firstname");
        user.setEmail("missinglastname@example.com");
        user.setRole(Role.CLIENT.toString().toLowerCase());
        assertThrows(Exception.class, () -> userManagementService.createUserService(user));
    }

    @Test
    void testSaveUserMissingEmail() {
        // Test when the email is missing
        User user = new User();
        user.setFirstName("Firstname");
        user.setLastName("Lastname");
        user.setRole(Role.CLIENT.toString().toLowerCase());
        assertThrows(Exception.class, () -> userManagementService.createUserService(user));
    }

    @Test
    void testSaveUser() {
        // Create a new user
        User user = new User();
        user.setPassword("12345");
        user.setFirstName("John");
        user.setLastName("Doe");
        user.setEmail("john.doe@example.com");
        user.setRole("client");

        // writing the user in the DDB with save method
        User savedUser = userManagementService.save(user);

        // fetching the user from the database
        User retrievedUser = userManagementService.findById(savedUser.getId()).orElse(null);

        // verifying that user must not be null
        assertNotNull(retrievedUser);

        // verifying that the credencials are the same than those written
        assertEquals(user.getFirstName(), retrievedUser.getFirstName());
        assertEquals(user.getLastName(), retrievedUser.getLastName());
        assertEquals(user.getEmail(), retrievedUser.getEmail());
    }

    @Test
    void testGetAllUsers() {
        // Test to verify that the list of all users is not null
        List<User> users = userManagementService.getAllUsers();
        assertNotNull(users);
    }

    @Test
    void testGetUserById() {
        // Test to verify that a user can be retrieved by ID
        User user = new User();
        user.setPassword("12345");
        user.setFirstName("Ketchum");
        user.setLastName("Ash");
        user.setEmail("ash"+Math.random()+"@example.com");
        user.setRole("client");
        user = userManagementService.save(user);

        int userId = user.getId();
        User retrievedUser = userManagementService.getUserById(userId);

        assertNotNull(retrievedUser);
        assertEquals(user.getEmail(), retrievedUser.getEmail());
    }

    @Test
    void testUpdateUserService() {
        // Test to verify that a user can be updated
        User user = new User();
        user.setPassword("12345");
        user.setFirstName("Test");
        user.setLastName("User");
        user.setEmail("test@example.com");
        user.setRole("client");
        user = userManagementService.save(user);

        // Update user's email
        String newEmail = "updated@example.com";
        user.setEmail(newEmail);
        userManagementService.updateUserService(user);

        User updatedUser = (User) userManagementService.findById(user.getId()).orElse(null);
        assertNotNull(updatedUser);
        assertEquals(newEmail, updatedUser.getEmail());
    }

    @Test
    void testDeleteUserService() {
        // Test to verify that a user can be deleted
        User user = new User();
        user.setPassword("12345");
        user.setFirstName("Test");
        user.setLastName("User");
        user.setEmail("test@example.com");
        user.setRole("client");
        user = userManagementService.save(user);

        userManagementService.deleteUserService(user);

        User deletedUser = userManagementService.findById(user.getId()).orElse(null);
        assertNull(deletedUser);
    }

    @Test
    void testGetUserByLastName() {
        // Test to verify that users can be retrieved by last name
        String lastName = "lkjjjlkjlkjlkjlkjlklkj";
        User user1 = new User();
        user1.setPassword("12345");
        user1.setFirstName("Ketchum");
        user1.setLastName(lastName);
        user1.setEmail("ash"+Math.random()+"@example.com");
        user1.setRole("client");
        user1 = userManagementService.save(user1);

        User user2 = new User();
        user2.setPassword("12345");
        user2.setFirstName("Test2");
        user2.setLastName(lastName);
        user2.setEmail("test2@example.com");
        user2.setRole("client_and_provider");
        user2 = userManagementService.save(user2);

        List<User> users = userManagementService.getUserByLastName(lastName);

        assertEquals(2, users.size());
        assertTrue(users.contains(user1));
        assertTrue(users.contains(user2));
    }
}
