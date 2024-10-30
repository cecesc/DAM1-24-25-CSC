package ud2.ejemplos;

import java.util.Scanner;

public class Ejemplo1While {
    public static void main(String[] args) {
        int num; // variable que contiene el número introducido
        int suma = 0; // variable donde acumularemos la suma de los números

        Scanner sc = new Scanner(System.in);
        System.out.print("Introduzca un número ( < 0 para finalizar): ");
        num = sc.nextInt(); // lectura del primer número

        while (num >= 0) { // inicio del bucle while
            suma = suma + num; // se suma el número introducido
            System.out.print("Introduzca un número ( < 0 para finalizar): ");
            num = sc.nextInt(); // lectura del siguiente número
        } // fin del bucle while
        sc.close();

        System.out.println("La suma es: " + suma); // se muestra la suma
    }

}
