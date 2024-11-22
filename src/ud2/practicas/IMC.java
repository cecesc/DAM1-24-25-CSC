package ud2.practicas;

import java.util.Scanner;
import java.util.InputMismatchException;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class IMC {
    public static double imc(double kg, double cm) {
        return kg / Math.pow(cm / 100, 2);
    }

    public static void clasificar(double imc) {
        if (imc < 18.50) {
            System.out.println("Usted tiene bajo peso.");
        } else if (imc >= 18.5 && imc <= 24.99) {
            System.out.println("Usted tiene un peso normal.");
        } else if (imc >= 25 && imc < 30) {
            System.out.println("Usted tiene sobrepeso.");
        } else {
            System.out.println("Usted tiene obesidad.");
        }
    }

    public static void main(String[] args) {
        int cm = 0;
        double kg = 0.0;
        Scanner sc = new Scanner(System.in);

        while (true) {
            try {
                System.out.print("Inserta tu altura (cm): ");
                cm = sc.nextInt();
                System.out.print("Inserta tu peso (kg): ");
                kg = sc.nextDouble();

                if ((cm < 50 || cm > 250) || (kg < 30 || kg > 300)) {
                    System.out.println("Datos no válidos. Vuelve a introducirlos.");
                } else {
                    break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Por favor, introduce un valor numérico.");
                sc.nextLine();
            }
        }

        sc.close();
        System.out.printf("Tu IMC es de: %.2f \n", imc(kg, cm));
        clasificar(imc(kg, cm));

    }

    @Test
    void testImc() {
        // Definir casos de prueba y sus resultados esperados
        // Caso 1: Peso 70 kg, Altura 170 cm
        double resultadoCaso1 = imc(70, 170);
        assertEquals(24.22, resultadoCaso1, 0.01);
        // Caso 2: Peso 90 kg, Altura 185 cm
        double resultadoCaso2 = imc(90, 185);
        assertEquals(26.30, resultadoCaso2, 0.01);
        // Caso 3: Peso 60 kg, Altura 160 cm
        double resultadoCaso3 = imc(60, 160);
        assertEquals(23.44, resultadoCaso3, 0.01);
        double resultadoCaso4 = imc(45, 160);
        assertEquals(17.578, resultadoCaso4, 0.01);
        double resultadoCaso5 = imc(65, 165);
        assertEquals(23.875, resultadoCaso5, 0.01);
        double resultadoCaso6 = imc(100, 175);
        assertEquals(32.653, resultadoCaso6, 0.01);
        double resultadoCaso7 = imc(99.98, 200);
        assertEquals(24.995, resultadoCaso7, 0.01);
    }
}
