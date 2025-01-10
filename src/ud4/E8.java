import java.util.Scanner;

public class EjArrays08 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] nombres = new String[20];
        double[] sueldos = new double[20];
        double maxSueldo = 0;
        String empleadoMaxSueldo = "";

        for (int i = 0; i < 20; i++) {
            System.out.print("Introduce el nombre del empleado " + (i + 1) + ": ");
            nombres[i] = scanner.nextLine();
            System.out.print("Introduce el sueldo de " + nombres[i] + ": ");
            sueldos[i] = scanner.nextDouble();
            scanner.nextLine(); // Limpiar el buffer
            if (sueldos[i] > maxSueldo) {
                maxSueldo = sueldos[i];
                empleadoMaxSueldo = nombres[i];
            }
        }

        System.out.println("El empleado que más gana es: " + empleadoMaxSueldo + " con un sueldo de: " + maxSueldo);
    }
}