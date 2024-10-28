/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author RC_Student_lab
 */
public class Login {
    private String username;
    private String password;
    private String firstname;
    private String lastname;


    public void setUsername(String u) {
        username = u;
    }

    public void setPassword(String p) {
        password = p;
    }

    public void setFirstName(String f) {
        firstname = f;
    }

    public void setLastName(String l) {
        lastname = l;
    }

    public boolean checkUsername() {
        final int NUM_UNDERSCORE = 1;
        int underscoreCount = 0;
        char underscore = '_';
        if (username.length() <= 5) {
            for (int u = 0; u < username.length(); u++) {
                char c = username.charAt(u);
                if (c == underscore) {
                    underscoreCount++;
                }
            }
        }
        return underscoreCount >= NUM_UNDERSCORE;
    }

    public boolean checkPasswordComplexity() {
        final int NUM_UPPER_LETTERS = 1;
        final int NUM_LOWER_LETTERS = 1;
        final int NUM_DIGITS = 1;
        final int NUM_SPECIALCHARS = 1;
        int upperCount = 0;
        int lowerCount = 0;
        int digitCount = 0;
        int specialcharsCount = 0;
        String SpecialChars = "@#$%^&*!";
        if (password.length() >= 8) {
            for (int i = 0; i < password.length(); i++) {
                char c = password.charAt(i);
                if (Character.isUpperCase(c)) upperCount++;
                else if (Character.isLowerCase(c)) lowerCount++;
                else if (Character.isDigit(c)) digitCount++;
                for (int s = 0; s < SpecialChars.length(); s++) {
                    if (c == SpecialChars.charAt(s)) {
                        specialcharsCount++;
                    }
                }
            }
        }
        return upperCount >= NUM_UPPER_LETTERS && lowerCount >= NUM_LOWER_LETTERS
                && digitCount >= NUM_DIGITS && specialcharsCount >= NUM_SPECIALCHARS;
    }

    public String registerUser() {
        if (checkUsername()) {
            System.out.println("Username successfully captured");
        } else {
            System.out.println("Username is not correctly formatted, please ensure that your username contains an underscore and is no more than 5 characters in length");
        }
        if (checkPasswordComplexity()) {
            System.out.println("Password successfully captured");
        } else {
            System.out.println("Password is not correctly formatted, please ensure that the password contains at least 8 characters, a capital letter, a number, and a special character.");
        }
        if (checkUsername() && checkPasswordComplexity()) {
            return "registration was complete";
        } else {
            return "registration was incomplete; please try again";
        }
    }

    String log_username;
    String log_password;

    public void setLogin_cred(String x, String y) {
        log_username = x;
        log_password = y;
    }

    public boolean loginUser() {
        return log_username.equals(username) && log_password.equals(password);
    }

    public String returnLoginStatus() {
        if (loginUser()) {
            return "Welcome " + firstname + " " + lastname + " it is great to see you <3.";
        } else {
            return "Username or password incorrect, please try again";
        }
    }
}