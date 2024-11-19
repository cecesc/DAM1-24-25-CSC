/*El veterano concurso de La2 “Saber y Ganar” incluye un juego denominado la “Calculadora Humana” en la que el concursante debe resolver operaciones matemáticas encadenadas en un tiempo límite. 
Las operaciones se realizan con números enteros e incluyen la suma, resta, división y multiplicación de números elegidos aleatoriamente. 

El juego comienza presentando al usuario una primera operación (a elegir aleatoriamente) entre dos números enteros (también aleatorios) y solicitando que escriba el resultado por teclado. 
Si el usuario escribe un resultado incorrecto se le solicitará que introduzca un nuevo valor por teclado.
Si el usuario acierta, se presentará una nueva operación (la segunda) en la que el primer operando será el resultado de la primera, mientras que el operador y el segundo operando serán elegidos aleatoriamente.
Resuelta la segunda operación se presentará la tercera, luego la cuarta y así sucesivamente.

El juego termina cuando el jugador resuelve 7 operaciones correctamente, independientemente del número de fallos que haya cometido. 

En el programa de TV, el juego termina también cuando expira un temporizador definido previamente (por ejemplo 59 segundos). Alternativamente a la implementación del temporizador se puede establecer el fin del juego cuando el jugador supera un número máximo de fallos permitido. 

Implementa el programa del juego con las siguentes especificaciones adicionales:
El número de operaciones, el número de segundos y el número de fallos permitidos se definirán como constantes al inicio del programa para facilitar adaptar el juego y su dificultad.
Tanto los operandos como los resultados de las operaciones planteadas por el juego estarán limitados a un valor máximo (por ejemplo 200). Es decir, si se le plantea al usuario una multiplicación, el resultado no deberá superar este límite, por lo que habrá que tenerlo en cuenta a la hora de generar los datos aleatorios. Se recomienda definir también este valor como una constante.
En el caso de las divisiones, el programa deberá asegurar que el resultado es un número entero.
 */
package ud2.practicas;

import java.util.Scanner;

public class CalculadoraHumana {

    public static int preguntar(int operacion, int resultado, boolean primeraPregunta) {
        System.out.println("Resuelve la siguiente operación:");
        int num1 = 0;
        if (primeraPregunta) {
            num1 = (int) (Math.random() * 100) + 1;
        } else {
            num1 = resultado;
        }
        int num2 = (int) (Math.random() * 100) + 1;

        switch (operacion) {
            case 1:
                System.out.println(num1 + " / " + num2);
                if (num2 == 0) {
                    System.out.println("No dividisible entre cero.");
                } else {
                    resultado = num1 / num2;
                }
                break;
            case 2:
                System.out.println(num1 + " * " + num2);
                resultado = num1 * num2;
                break;
            case 3:
                System.out.println(num1 + " + " + num2);
                resultado = num1 + num2;
                break;
            case 4:
                System.out.println(num1 + " - " + num2);
                resultado = num1 - num2;
                break;
            default:
                break;
        }
        return resultado;
    }

    public static void main(String[] args) {
        final int NUM_MAX_FALLOS = 5;
        final int NUM_OPERACIONES = 7;
        int numAciertos = 0;
        int numFallos = 0;
        int resultado = 0;
        boolean primeraPregunta = true;
        Scanner sc = new Scanner(System.in);
        do {
            int operacion = (int) (Math.random() * 4) + 1;

            resultado = preguntar(operacion, resultado, primeraPregunta);

            System.out.print("Respuesta: ");
            int respuestaUsuario = sc.nextInt();

            if (respuestaUsuario == resultado) {
                numAciertos++;
                resultado = preguntar(operacion, resultado, !primeraPregunta);
            } else {
                numFallos++;
            }
        } while (numAciertos < NUM_OPERACIONES || numFallos < NUM_MAX_FALLOS);

        System.out.println("El juego ha terminado.");
        sc.close();
    }
}
