/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author RC_Student_lab
 */
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LoginTest {

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
