package ud2.practicas;

import java.util.Scanner;

public class IMC {
    public static double imc(double kg, double cm) {
        return kg / Math.pow(cm / 100, 2);
    }

    public static void clasifImcOms(double imc) {
        if (imc < 18.50) {
            System.out.println("Según la OMS, tienes bajo peso.");
        } else if (imc >= 18.5 & imc <= 24.99) {
            System.out.println("Según la OMS, tienes peso normal.");
        } else if (imc >= 25 & imc < 30) {
            System.out.println("Según la OMS, tienes sobrepeso.");
        } else {
            System.out.println("Según la OMS, tienes obesidad.");
        }
    }
    public static void main(String[] args) {
        int cm = 0;
        double kg = 0.0;

        Scanner sc = new Scanner(System.in);
        while ((cm < 50 || cm > 250) || (kg < 30 || kg > 300 )) {
            System.out.print("Inserta tu altura (cm): ");
            cm = sc.nextInt();
            System.out.print("Inserta tu peso (kg): ");
            kg = sc.nextDouble();
            if ((cm < 50 || cm > 250) || (kg < 30 || kg > 300 )) {
                System.out.println("Datos no válidos. Vuelve a introducirlos.");
            }
        }
        sc.close();
        System.out.printf("Tu IMC es de: %.2f \n", imc(kg, cm));
        clasifImcOms(imc(kg, cm));
    }
}

