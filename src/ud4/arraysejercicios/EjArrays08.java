package ud4.arraysejercicios;
import java.util.Scanner;

public class EjArrays08 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] nombres = new String[20];
        double[] sueldos = new double[20];
        double maxSueldo = 0;
        String empleadoMaxSueldo = "";

        for (int i = 0; i < 20; i++) {
            System.out.print("Introduce el nombre del empleado " + (i + 1) + ": ");
            nombres[i] = sc.nextLine();
            System.out.print("Introduce el sueldo de " + nombres[i] + ": ");
            sueldos[i] = sc.nextDouble();
            sc.nextLine(); // Limpiar el buffer
            if (sueldos[i] > maxSueldo) {
                maxSueldo = sueldos[i];
                empleadoMaxSueldo = nombres[i];
            }
        }

        System.out.println("El empleado que más gana es: " + empleadoMaxSueldo + " con un sueldo de: " + maxSueldo);
    
    sc.close();
    }
}