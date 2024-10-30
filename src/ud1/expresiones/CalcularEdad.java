package ud1.expresiones;

import java.util.Scanner;
import java.time.LocalDate;
import java.time.Period;


public class CalcularEdad {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Introduzca su fecha de nacimiento (dd mm aaaa): ");
        int dd = scanner.nextInt(); // Día
        int mm = scanner.nextInt(); // Mes
        int aaaa = scanner.nextInt(); // Año
        scanner.close();

        LocalDate fechaActual = LocalDate.now();
        LocalDate fechaNacimiento = LocalDate.of(aaaa, mm, dd);

        // Calcular la diferencia entre dos fechas
        Period edad = Period.between(fechaNacimiento, fechaActual);
      
      /*  Nos ahorramos todo esto con el paquete de java.time.Period
        int diaActual = now.getDayOfMonth(); // Devuelve un número entero (1-31)
        int mesActual = now.getMonthValue(); // Devuelve un número entero (1-12)
        int añoActual = now.getYear(); // Año actual

        int edad = (mm < mesActual) ? (añoActual - aaaa) : // Si el mes de nacimiento es menor
                   (mm > mesActual) ? (añoActual - aaaa - 1) : // Si el mes de nacimiento es mayor
                   (dd > diaActual) ? (añoActual - aaaa - 1) : // Si es el mismo mes pero el día es mayor
                   (añoActual - aaaa); // Si es el mismo mes y el mismo día */

        System.out.printf("Tienes %d años, %d meses y %d días", edad.getYears(), edad.getMonths(), edad.getDays());
    }
}
