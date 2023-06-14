package org.example;


import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PasswordValidator {
    public String validatePasswords(String text) {
        Pattern pattern = Pattern.compile("(password:)(.{10})");
        Matcher matcher = pattern.matcher(text);
        StringBuilder result = new StringBuilder(text);

        while (matcher.find()) {
            String password = matcher.group(2);
            if (!password.matches("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d).+$")) {
                result.replace(matcher.start(2), matcher.end(2), "UNSECURED");
            }
        }
        return result.toString();
    }
}

