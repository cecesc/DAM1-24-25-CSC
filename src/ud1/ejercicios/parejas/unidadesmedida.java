package ud1.ejercicios.parejas;

/**
 * En este ejercicio el piloto fue Alejandro Feijoo Regueira
 * y la copiloto fue Celia Sanmartín Chapela
 */

import java.util.Scanner;

public class unidadesmedida {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double numHectareas, numCampoFutbol, numCampoTenis, numCampoBaloncesto, numRetiro;

        System.out.println("Hola, por favor introduzca el número de hectáreas a transformar ");
        numHectareas = sc.nextDouble();
        sc.close();
        numCampoFutbol = 10000.00 * numHectareas / 7350.00;
        numCampoBaloncesto = 10000.00 * numHectareas / 420.00;
        numCampoTenis = 10000.00 * numHectareas / 260.7569;
        numRetiro = 10000.00 * numHectareas / (125 * 10000.00);

        System.out.printf("El número de hectáreas que me has entregado corresponde a aproximadamente a estos campos de futbol: %.2f %n", numCampoFutbol);
        System.out.printf("Así como a estos campos de baloncesto: %.2f %n", numCampoBaloncesto);
        System.out.printf("Al igual que a los siguientes campos de tenis dobles: %.2f %n", numCampoTenis);
        System.out.printf("Y también como a estos parques del retiro: %.2f %n", numRetiro);

    }

}