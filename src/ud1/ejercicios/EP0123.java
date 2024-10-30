package ud1.ejercicios;

import java.util.Scanner;

/*Escribe un programa que convierta unidades de masa entre kilogramos y libras o viceversa. El programa solicitará al usuario la cantidad de masa y la unidad de medida origen (kilogramos o libras*/
public class EP0123 {
    public static void main(String[] args) {
        double masaOrigen, masaDestino;
        byte unidadMedida;

    Scanner sc = new Scanner (System.in);
    System.out.print("Introduce masa de origen: ");
    masaOrigen =sc.nextDouble();

    System.out.println("Introduce la unidad de medida de origen: (1=Kilos. 2=Libras): ");
    unidadMedida = sc.nextByte();

    masaDestino= unidadMedida == 1 ? masaOrigen*1000 / 453.592 : 3.4;
    
        System.out.printf("La masa del destino es %.3f %s %n", masaDestino, unidadMedida ==1 ? "libras" : "Kilos");
        sc.close();

}
}
