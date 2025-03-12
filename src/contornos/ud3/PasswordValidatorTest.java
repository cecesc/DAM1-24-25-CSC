package contornos.ud3;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class PasswordValidatorTest {

    @Test
    void testPassword() {
        assertFalse(PasswordValidator.isValid("Abcdefgh12"));
    }

    @Test
    void testNoUpperCase() {
        assertFalse(PasswordValidator.isValid("abcdef12")); 
    }

    @Test
    void testNoDigit() {
        assertFalse(PasswordValidator.isValid("Abcdefgh"));
    }

    @Test
    void testValidPassword() {
        assertTrue(PasswordValidator.isValid("Abcdef1")); 
    }

    @Test
    void testValidMaxLength() {
        assertFalse(PasswordValidator.isValid("A1bcdefg")); 
    }


    @Test
    void testInvalidLongPassword() {
        assertFalse(PasswordValidator.isValid("Abcdefghij1"));
    }

    @Test
    void testEmptyString() {
        assertFalse(PasswordValidator.isValid("")); 
    }

    @Test
    void testOnlyUpperCaseAndDigits() {
        assertTrue(PasswordValidator.isValid("A1B2C3D")); 
    }


    @Test
    void testOnlySpecialCharacters() {
        assertFalse(PasswordValidator.isValid("@#$%^&*")); 
    }

    @Test
    void testOnlyNumbers() {
        assertFalse(PasswordValidator.isValid("12345678"));
    }

    @Test
    void testOnlyLowerCase() {
        assertFalse(PasswordValidator.isValid("abcdefgh")); 
    }

    @Test
    void testOnlyUpperCase() {
        assertFalse(PasswordValidator.isValid("ABCDEFGH"));
    }

    @Test
    void testMultipleUpperCaseAndDigits() {
        assertTrue(PasswordValidator.isValid("A1B2c3D")); 
    }

    @Test
    void testPasswordSpaces() {
        assertFalse(PasswordValidator.isValid("A1b cdef")); 
    }
}