package ud1.expresiones;

import java.util.Scanner;

public class DDestanciasEntrePuntos {
       public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Pedir al usuario las coordenadas X1, Y1, X2, Y2
        System.out.print("Introduce la coordenada X1: ");
        double X1 = sc.nextDouble();
        System.out.print("Introduce la coordenada Y1: ");
        double Y1 = sc.nextDouble();
        System.out.print("Introduce la coordenada X2: ");
        double X2 = sc.nextDouble();
        System.out.print("Introduce la coordenada Y2: ");
        double Y2 = sc.nextDouble();
        sc.close();
        // Calcular la distancia entre los puntos
        double distancia = Math.sqrt(Math.pow(X2 - X1, 2) + Math.pow(Y2 - Y1, 2));

        // Mostrar la distancia calculada
        System.out.println("La distancia entre los dos puntos es: " + distancia);
    }
}

