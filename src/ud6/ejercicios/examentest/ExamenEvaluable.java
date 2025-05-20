package ud6.ejercicios.examentest;

import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;

public class ExamenEvaluable extends Examen {

    public ExamenEvaluable(String titulo) {
        super(titulo);
    }

    public List<Integer> responderConsola() {
        Scanner sc = new Scanner(System.in);
        List<Integer> respuestasUsuario = new ArrayList<>();
        int num = 1;

        for (Pregunta p : super.preguntas) {
            System.out.print(num++ + ". " + p.toString());
            int intentos = 0;
            int opcionElegida = -1;

            
                System.out.print("Respuesta? ");
                String entrada = sc.nextLine().trim().toLowerCase();

                if (entrada.length() == 1) {
                    char letra = entrada.charAt(0);
                    int indice = letra - 'a';

                    if (indice >= 0 && indice < p.respuestas.size()) {
                        opcionElegida = indice;
                        break;
                    }
                }

                System.out.println("Entrada inválida. Introduce una letra válida (a-" +
                        (char) ('a' + p.respuestas.size() - 1) + ").");
            

            respuestasUsuario.add(opcionElegida);
        }

        return respuestasUsuario;
    }

    public int corregir(List<Integer> respuestasUsuario) {
        int correctas = 0;
        int i = 0;
        for (Pregunta p : super.preguntas) {
            if (p.corregir(respuestasUsuario.get(i))) {
                correctas++;
            }
            i++;
        }
        return correctas;
    }

    public double puntuacionSobre10(int numCorrectas) {
        if (super.numPreguntas() == 0)
            return 0.0;
        return ((double) numCorrectas / super.numPreguntas()) * 10.0;
    }
}
