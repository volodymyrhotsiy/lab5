package org.example;


import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PasswordValidatorTest {
    private PasswordValidator validator;

    @Before
    public void setUp() {
        validator = new PasswordValidator();
    }

    @Test
    public void testValidPasswords() {
        String text = "Valid password: ABC123xyz, valid password: 123abcXYZ";
        String expected = "Valid password: ABC123xyz, valid password: 123abcXYZ";
        assertEquals(expected, validator.validatePasswords(text));
    }

    @Test
    public void testInvalidPasswords() {
        String text = "Invalid password: abcdefghi, invalid password: password12";
        String expected = "Invalid password:UNSECURED, invalid password: UNSECURED";
        assertEquals(expected, validator.validatePasswords(text));
    }

    @Test
    public void testMixedPasswords() {
        String text = "Valid password: ABC123xyz, invalid password: abcdefghi, valid password: 123abcXYZ, invalid password: password12";
        String expected = "Valid password: ABC123xyz, invalid password:UNSECURED, valid password: 123abcXYZ, invalid password: UNSECURED";
        assertEquals(expected, validator.validatePasswords(text));
    }

    @Test
    public void testNoPasswords() {
        String text = "This text contains no passwords.";
        String expected = "This text contains no passwords.";
        assertEquals(expected, validator.validatePasswords(text));
    }
}

