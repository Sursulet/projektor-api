package com.projektor.repository;

import com.projektor.entity.Role;
import com.projektor.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
@Rollback(true)
class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    void testSaveUserOk01() {
        // Test save and findById
        User user = new User();
        user.setFirstName("testuser");
        user.setLastName("toto");
        user.setEmail("testuser@example.com");
        user.setPassword("12345");
        user.setRole(Role.CLIENT.toString().toLowerCase());
        var savedUser = userRepository.save(user);

        assertNotNull(savedUser);
        assertEquals(user.getFirstName(), savedUser.getFirstName());
        assertEquals(user.getEmail(), savedUser.getEmail());
    }
}
