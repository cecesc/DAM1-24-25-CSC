package ud2.practicas;

import java.util.Scanner;
import java.util.InputMismatchException;

public class IMC {
        public static double imc(double kg, double cm) {
            return kg / Math.pow(cm / 100, 2);
        }
    
        public static void clasifImcOms(double imc) {
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
                        break; // Salir del bucle si los datos son válidos
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Por favor, introduce un valor numérico.");
                    sc.nextLine(); // Consumir la entrada no válida
                }
            }
    
            sc.close();
            System.out.printf("Tu IMC es de: %.2f \n", imc(kg, cm));
            clasifImcOms(imc(kg, cm));
        }
    }

