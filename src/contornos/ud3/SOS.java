package contornos.ud3;

public class SOS {
/*Con el codigo que te doy pon me en comentarios los errores que contiene y creame los test necesarios para pasar cada caso de prueba
 Crea unha clase PasswordValidator con un método isValid(String password). A clave é válida se:
Ten polo menos 8 caracteres.
Contén polo menos unha letra maiúscula.
Contén polo menos un número.
public class PasswordValidator {
    public static boolean isValid(String password) {
        if (password.length() <= 8) { 
            return false;
        }
        boolean hasUpperCase = false;
        boolean hasDigit = false;
        for (char c : password.toCharArray()) {
            if (Character.isLowerCase(c)) { 
                hasUpperCase = true;
            }
            if (Character.isDigit(c)) {
                hasDigit = false; 
            }
        }
        return hasUpperCase || hasDigit; 
    }
}


public class PasswordValidator {
    public static boolean isValid(String password) {
        // Error 1: Debe ser >= 8 caracteres, pero el código usa <= en la condición incorrectamente
        if (password.length() < 8) { 
            return false;
        }

        boolean hasUpperCase = false;
        boolean hasDigit = false;

        for (char c : password.toCharArray()) {
            // Error 2: Se usa `isLowerCase`, pero debería ser `isUpperCase`
            if (Character.isUpperCase(c)) { 
                hasUpperCase = true;
            }
            // Error 3: `hasDigit` se está estableciendo en `false` en lugar de `true`
            if (Character.isDigit(c)) {
                hasDigit = true; 
            }
        }

        // Error 4: Se usa `|` en vez de `&&`, lo que puede dar resultados incorrectos
        return hasUpperCase && hasDigit; 
    }
}


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


 */
/*
Informe de los pasos seguidos
1. Análisis del código inicial
Se identificaron 4 errores principales:

Condición incorrecta para la longitud mínima.
Uso incorrecto de isLowerCase en lugar de isUpperCase.
Reinicialización incorrecta de hasDigit.
Uso de | en lugar de && en la condición final.*/
}
