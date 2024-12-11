package ud2.ejercicios;

import java.util.Scanner;

public class Navidad {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Solicitar al usuario que ingrese el número de fechas a consultar
        System.out.print("Ingrese el número de fechas a consultar: ");
        int N = scanner.nextInt();
        
        for (int i = 0; i < N; i++) {
            // Leer el día y el mes
            System.out.print("Ingrese el día y el mes (formato: dia mes): ");
            int dia = scanner.nextInt();
            int mes = scanner.nextInt();
            
            // Verificar si es Navidad
            if (dia == 25 && mes == 12) {
                System.out.println("SI");
            } else {
                System.out.println("NO");
            }
        }
        
        // Cerrar el Scanner
        scanner.close();
    }
}

/*import java.util.Scanner;

public class DiaDeNavidad {
    
    // Función que verifica si la fecha es Navidad
    public static String esNavidad(int dia, int mes) {
        if (dia == 25 && mes == 12) {
            return "SI";
        } else {
            return "NO";
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Leer el número de fechas a consultar
        int N = scanner.nextInt();
        
        for (int i = 0; i < N; i++) {
            // Leer el día y el mes
            int dia = scanner.nextInt();
            int mes = scanner.nextInt();
            
            // Llamar a la función y mostrar el resultado
            System.out.println(esNavidad(dia, mes));
        }
        
        // Cerrar el Scanner
        scanner.close();
    }
} */