/*  En una granja se compra diariamente una cantidad (comidaDiaria) de comida
para los animales. El número de animales que alimentar (todos de la misma especie) es
numAnimales, y sabemos que cada animal come una media de kilosPorAnimal.
Diseña un programa que solicite al usuario los valores anteriores y determine si disponemos
de alimento suficiente para cada animal. En caso negativo, ha de calcular cuál es la ración
que corresponde a cada uno de los animales.
Nota: Evitar que la aplicación realice divisiones por cero */

package ud2.ejercicioscondicionales;

import java.util.Scanner;

public class EP0213 {
    public static void main(String[] args) {
        int comidaDiaria, numAnimales, kilosPorAnimal;

        Scanner sc = new Scanner(System.in);
        System.out.print("Introduzca la cantidad de comida Diaria: ");
        comidaDiaria = sc.nextInt();
        System.out.print("Introduzca el número de animales: ");
        numAnimales = sc.nextInt();
        System.out.print("Introduzca la cantidad de kilos que come el animal: ");
        kilosPorAnimal = sc.nextInt();
        sc.close();

        if (comidaDiaria >= kilosPorAnimal) {


        } else {
            System.out.println("La comida no da para todos los animales");
            System.out.println("La ración que le corresponde a cada animal es de : " + );
        }

        
    }
}
