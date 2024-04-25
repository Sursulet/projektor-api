package com.projektor.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@Transactional
@Rollback(true)
class AuthServiceTest {
    @Autowired
    private AuthService authService;

    @Test
    void testAuthenticateOk() {
        final var email ="pikachu@example.com";
        final var password = "12345";

        var result = authService.authenticateUser(email, password);
        Assertions.assertTrue(result, "All values are in data base");
    }


    @Test
    void testAuthenticateKo() {
        final var email ="pikachu@example.com";
        final var password = "toto"; // wrong pwd

        var result = authService.authenticateUser(email, password);
        Assertions.assertFalse(result, "Password is not right");
    }

    @Test
    void testAuthenticateUser_ValidCredentials() {
        // Arrange
        final String email = "pikachu@example.com";
        final String password = "12345";

        // Act
        boolean result = authService.authenticateUser(email, password);

        // Assert
        Assertions.assertTrue(result, "Authentication with valid credentials should succeed");
    }

    @Test
    void testAuthenticateUser_InvalidPassword() {
        // Arrange
        final String email = "pikachu@example.com";
        final String password = "toto"; // wrong password

        // Act
        boolean result = authService.authenticateUser(email, password);

        // Assert
        Assertions.assertFalse(result, "Authentication with invalid password should fail");
    }

    @Test
    void testAuthenticateUser_UserNotFound() {
        // Arrange
        final String email = "nonexistent@example.com";
        final String password = "password";

        // Act
        boolean result = authService.authenticateUser(email, password);

        // Assert
        Assertions.assertFalse(result, "Authentication with nonexistent user should fail");
    }

    @Test
    void testAuthenticateUser_MissingFirstName() {
        // Arrange
        final String email = "ash@example.com";
        final String password = "123456789";

        // Act
        boolean result = authService.authenticateUser(email, password);

        // Assert
        Assertions.assertFalse(result, "Authentication should fail if user's first name is missing");
    }

    @Test
    void testAuthenticateUser_MissingLastName() {
        // Arrange
        final String email = "misty@example.com";
        final String password = "111222333";

        // Act
        boolean result = authService.authenticateUser(email, password);

        // Assert
        Assertions.assertFalse(result, "Authentication should fail if user's last name is missing");
    }

    @Test
    void testAuthenticateUser_MissingEmail() {
        // Arrange
        final String password = "987654321"; // Brock's password

        // Act
        boolean result = authService.authenticateUser(null, password);

        // Assert
        Assertions.assertFalse(result, "Authentication should fail if email is missing");
    }
}
