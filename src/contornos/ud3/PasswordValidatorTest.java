package contornos.ud3;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class PasswordValidatorTest {

    @Test
    void testPasswordTooShort() {
        assertFalse(PasswordValidator.isValid("Ab1")); // Menos de 8 caracteres
    }

    @Test
    void testPasswordWithoutUpperCase() {
        assertFalse(PasswordValidator.isValid("abcdefgh1")); // Sin mayúsculas
    }

    @Test
    void testPasswordWithoutDigit() {
        assertFalse(PasswordValidator.isValid("ABCDEFGH")); // Sin números
    }

    @Test
    void testPasswordValid() {
        assertTrue(PasswordValidator.isValid("Abcdefg1")); // Correcta
    }

    @Test
    void testPasswordWithOnlyNumbers() {
        assertFalse(PasswordValidator.isValid("12345678")); // Solo números
    }

    @Test
    void testPasswordWithOnlyUppercase() {
        assertFalse(PasswordValidator.isValid("ABCDEFGH")); // Solo mayúsculas
    }

    @Test
    void testPasswordWithMixedCaseButNoNumber() {
        assertFalse(PasswordValidator.isValid("Abcdefgh")); // Mayúscula pero sin número
    }

    @Test
    void testPasswordWithMixedCaseAndNumber() {
        assertTrue(PasswordValidator.isValid("A1bcdefg")); // Cumple todos los requisitos
    }

    @Test
    void testPasswordWithLongValidPassword() {
        assertTrue(PasswordValidator.isValid("Password123")); // Más de 8 caracteres, válido
    }
}
