package contornos.ud3;

public class PasswordValidator {
    public static boolean isValid(String password) {
        if (password.length() < 8) {
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
/*Informe de los pasos seguidos
1. Análisis del código inicial
Se identificaron 4 errores principales:

Condición incorrecta para la longitud mínima.
Uso incorrecto de isLowerCase en lugar de isUpperCase.
Reinicialización incorrecta de hasDigit.
Uso de || en lugar de && en la condición final.
 */