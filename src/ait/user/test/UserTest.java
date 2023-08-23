package ait.user.test;

import ait.user.model.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {
    private User user;
    private String email = "john@gmail.com";
    private String password = "12345Ab!";

    @BeforeEach
    void setUp() {
        user = new User(email, password);
    }

    @Test
    void testValidEmail() {
        String validEmail = "  john@gmx.de  ";
        user.setEmail(validEmail);
        assertEquals(validEmail.trim(), user.getEmail());
    }

    @Test
    void testEmailWithoutAt() {
        String invalidEmail = "john.gmx.de";
        user.setEmail(invalidEmail);
        assertEquals(email, user.getEmail());
    }

    @Test
    void testEmailDoubleAt() {
        String invalidEmail = "jo@hn@gmx.de";
        user.setEmail(invalidEmail);
        assertEquals(email, user.getEmail());
    }

    @Test
    void testEmailDotAfterAt() {
        String invalidEmail = "john@gmxde";
        user.setEmail(invalidEmail);
        assertEquals(email, user.getEmail());
    }

    @Test
    void testEmailLastDot() {
        String invalidEmail = "john@gmxde.";
        user.setEmail(invalidEmail);
        assertEquals(email, user.getEmail());
        invalidEmail = "john@gmxd.e";
        user.setEmail(invalidEmail);
        assertEquals(email, user.getEmail());
    }

    @Test
    void testEmailIncorrectSymbol() {
        String invalidEmail = "jo!hn@gmx.de";
        user.setEmail(invalidEmail);
        assertEquals(email, user.getEmail());
    }

    @Test
    void testValidPassword() {
        String validPassword = "qwertY1@";
        user.setPassword(validPassword);
        assertEquals(validPassword, user.getPassword());
    }

    @Test
    void testPasswordLength() {
        String invalidPassword = "wertY1@";
        user.setPassword(invalidPassword);
        assertEquals(password, user.getPassword());
    }

    @Test
    void testPasswordUpperCase() {
        String invalidPassword = "qwerty1@";
        user.setPassword(invalidPassword);
        assertEquals(password, user.getPassword());
    }

    @Test
    void testPasswordLowerCase() {
        String invalidPassword = "QWERTY1@";
        user.setPassword(invalidPassword);
        assertEquals(password, user.getPassword());
    }

    @Test
    void testPasswordDigits() {
        String invalidPassword = "qwertYz@";
        user.setPassword(invalidPassword);
        assertEquals(password, user.getPassword());
    }

    @Test
    void testPasswordSpecialSymbols() {
        String invalidPassword = "qwertY12";
        user.setPassword(invalidPassword);
        assertEquals(password, user.getPassword());
    }
}
