package ud4.matricesejercicios;


public class Matriculas {

        public static boolean esMatriculaValida(String matricula) {
            if (matricula.length() != 7) {
                return false;
            }
    
            for (int i = 0; i < 4; i++) {
                if (!Character.isDigit(matricula.charAt(i))) {
                    return false;
                }
            }
    
            for (int i = 4; i < 7; i++) {
                if (!esLetraValida(matricula.charAt(i))) {
                    return false;
                }
            }
    
            return true;
        }
    
        private static boolean esLetraValida(char ch) {
            ch = Character.toUpperCase(ch);
            return (ch >= 'B' && ch <= 'Z' && ch != 'E' && ch != 'I' && ch != 'O' && ch != 'U' && ch != 'Ñ' && ch != 'Q');
        }
    }

