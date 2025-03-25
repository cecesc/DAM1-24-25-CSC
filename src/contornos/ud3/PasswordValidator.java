package contornos.ud3;

public class PasswordValidator {
    public static boolean isValid(String password) {
        if (password.length() >= 8) {
            return false;
        }

        boolean hasUpperCase = false;
        boolean hasDigit = false;

        for (char c : password.toCharArray()) {
            if (Character.isUpperCase(c)) {
                hasUpperCase = true;
            }

            if (Character.isDigit(c)) {
                hasDigit = true;
            }
        }
        return hasUpperCase && hasDigit;
    }
}


// Error 1: Debe ser >= 8 caracteres, pero el código usa <= en la condición incorrectamente
// Error 2: Se usa `isLowerCase`, pero debería ser `isUpperCase`
// Error 3: `hasDigit` se está estableciendo en `false` en lugar de `true`
// Error 4: Se usa `|` en vez de `&&`, lo que puede dar resultados incorrectos