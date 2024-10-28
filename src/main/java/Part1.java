/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author RC_Student_lab
 */
import javax.swing.JOptionPane;

public class Part1 extends Login {
    public static void main(String[] args) {
        Login log = new Login();
        String name = JOptionPane.showInputDialog("Enter Username");
        log.setUsername(name);
        String pass = JOptionPane.showInputDialog("Enter Password");
        log.setPassword(pass);
        String firstname = JOptionPane.showInputDialog("Enter First Name");
        log.setFirstName(firstname);
        String lastname = JOptionPane.showInputDialog("Enter Last Name");
        log.setLastName(lastname);
        JOptionPane.showMessageDialog(null, log.registerUser());

        if (log.checkUsername() && log.checkPasswordComplexity()) {
            String username = JOptionPane.showInputDialog("Enter Username");
            String password = JOptionPane.showInputDialog("Enter Password");
            log.setLogin_cred(username, password);
            JOptionPane.showMessageDialog(null, log.returnLoginStatus());

            while (!log.loginUser()) {
                username = JOptionPane.showInputDialog("Enter Username");
                password = JOptionPane.showInputDialog("Enter Password");
                log.setLogin_cred(username, password);
                JOptionPane.showMessageDialog(null, log.returnLoginStatus());
            }
        }
    }
}
