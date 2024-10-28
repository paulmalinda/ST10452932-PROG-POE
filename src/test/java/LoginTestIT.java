/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author RC_Student_lab
 */
public class LoginTest.java {

    @Test
    public void testCheckUsername_Valid() {
        Login login = new Login();
        login.setUsername("valid_username");
        assertTrue(login.checkUsername());
    }

    @Test
    public void testCheckUsername_Invalid() {
        Login login = new Login();
        login.setUsername("invalidusername");
        assertFalse(login.checkUsername());
    }

    @Test
    public void testCheckPasswordComplexity_Valid() {
        Login login = new Login();
        login.setPassword("Valid123!");
        assertTrue(login.checkPasswordComplexity());
    }

    @Test
    public void testCheckPasswordComplexity_Invalid() {
        Login login = new Login();
        login.setPassword("invalid");
        assertFalse(login.checkPasswordComplexity());
    }
}