package ud4.apuntes.matricesejercicios;

public class Matriculas {

    public static boolean esMatriculaValida(String matricula) {
        if (matricula == null || matricula.length() != 7) {
            return false;
        }

        for (int i = 0; i < matricula.length() - 3; i++) {
            if (!Character.isDigit(matricula.charAt(i))) {
                return false;
            }
        }

        for (int i = 4; i < matricula.length(); i++) {
            if (!esLetraValida(matricula.charAt(i))) {
                return false;
            }
        }

        return true;
    }

    static boolean esLetraValida(char ch) {
        ch = Character.toUpperCase(ch);
        return (ch >= 'B' && ch <= 'Z' && ch != 'E' && ch != 'I' && ch != 'O' && ch != 'U' && ch != 'Ñ' && ch != 'Q');
    }
}
