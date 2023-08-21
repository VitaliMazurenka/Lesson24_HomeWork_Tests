package ait.user.test;

import ait.user.model.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {
    private User user;
    private String email = "john@gmail.com";
    private String password = "1234";

    @BeforeEach
        // запускается перед каждым тестом
    void setUp() {
        user = new User(email, password);
    }

    @Test
    void testValidEmail() {
        String validEmail = "john@gmx.de";
        user.setEmail(validEmail);
        validEmail.equals(user.getEmail());
        assertEquals(validEmail, user.getEmail());  // внутри делает проверку через equals
    }

    @Test
    void testEmailWithoutAt() {
        String invalidEmail = "john.gmx.de";
        user.setEmail(invalidEmail);
        assertEquals(email, user.getEmail());
    }

    @Test
    void testEmailDoubletAt() {
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
    //====================================================HOMEWORK==================================================
    @Test
    void testValidPassword() {
        String validPassword = "The_beatle82%";
        user.setPassword(validPassword);
        validPassword.equals(user.getPassword());
        assertEquals(validPassword, user.getPassword());

    }
    @Test
    void testNumberOfSymbols() {
        String invalidPassword = "The_bea";
        user.setPassword(invalidPassword);
        assertEquals(password, user.getPassword());
    }
    @Test
    void testUpperAndLowerCase() {
        String invalidPassword = "the_beatle82%";
        user.setPassword(invalidPassword);
        assertEquals(password, user.getPassword());
    }
    @Test
    void testIfDigit() {
        String invalidPassword = "the_beatle%";
        user.setPassword(invalidPassword);
        assertEquals(password, user.getPassword());

    }
    @Test
    void testIfSpecialSymbol() {
        String invalidPassword = "the_beatle82";
        user.setPassword(invalidPassword);
        assertEquals(password, user.getPassword());
    }
}