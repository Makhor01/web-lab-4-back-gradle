package com.weblab4;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class UserTest {

    @Test
    public void testGettersAndSetters() {
        // Arrange
        Long id = 1L;
        String login = "testUser";
        String passwordHash = "testPasswordHash";

        // Act
        User user = new User();
        user.setId(id);
        user.setLogin(login);
        user.setPasswordHash(passwordHash);

        // Assert
        assertEquals(id, user.getId());
        assertEquals(login, user.getLogin());
        assertEquals(passwordHash, user.getPasswordHash());
    }

    @Test
    public void testConstructor() {
        // Arrange
        Long id = 1L;
        String login = "testUser";
        String passwordHash = "testPasswordHash";

        // Act
        User user = new User(login, passwordHash);
        user.setId(id);

        // Assert
        assertEquals(id, user.getId());
        assertEquals(login, user.getLogin());
        assertEquals(passwordHash, user.getPasswordHash());
    }
}

