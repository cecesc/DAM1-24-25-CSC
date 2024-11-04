package ud2.ejerciciosbucles;

import java.util.Scanner;

public class E0302 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int edad;
        int sumaEdades = 0;
        int contador = 0;
        int mayoresDeEdad = 0;

        do {
            System.out.print("Introduzca la edad del alumno (negativa para terminar): ");
            edad = sc.nextInt();

            if (edad >= 0) {
                sumaEdades += edad;
                contador++;
                if (edad >= 18) {
                    mayoresDeEdad++;
                }
            }
        } while (edad >= 0);

        if (contador > 0) {
            double media = (double) sumaEdades / contador;
            System.out.println("Suma de edades: " + sumaEdades);
            System.out.println("Media de edades: " + media);
            System.out.println("Número de alumnos: " + contador);
            System.out.println("Número de mayores de edad: " + mayoresDeEdad);
        } else {
            System.out.println("No se introdujeron edades válidas.");
        }

        sc.close();
    }
} 