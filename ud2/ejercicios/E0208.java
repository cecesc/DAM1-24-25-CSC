//Pedir los coeficientes de una ecuación de segundo grado (ax2 + bx + c = 0) y mostrar sus soluciones reales. 
//Las soluciones de una ecuación de segundo grado son dos, según se utilice el signo + o - delante de la raíz cuadrada: 
//Si el discriminante (el contenido de la raíz cuadrada) es negativo, el programa deberá indicar que no existen soluciones con números reales.

package ud2.ejercicios;

import java.util.Scanner;

public class E0208 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double coeA, coeB, coeC, interioRaiz;

        System.out.print("Introduce el coeficiente a: ");
        coeA = sc.nextDouble();
        System.out.print("Introduce el coeficiente b: ");
        coeB = sc.nextDouble();
        System.out.print("Introduce el coeficiente c: ");
        coeC = sc.nextDouble();
        sc.close();

        interioRaiz = coeB * coeB - 4 * coeA * coeC;

        if (interioRaiz > 0) {
            double solucion1 = (-coeB + Math.sqrt(interioRaiz)) / (2 * coeA);
            double solucion2 = (-coeB - Math.sqrt(interioRaiz)) / (2 * coeA);
            System.out.printf("Las soluciones reales son: %.2f " , solucion1 + " y %s" ,solucion2);
        } else if (interioRaiz == 0) {
            double solucionUnica = -coeB / (2 * coeA);
            System.out.printf("La única solución real es: %.2f", solucionUnica);
        } else {
            System.out.println("La ecuación no tiene soluciones reales.");
        }
    }
}
