package ud2.ejercicios;

import java.util.Scanner;

public class Nochevieja {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        while (true) {
            // Solicitar al usuario que ingrese la hora
            System.out.print("Ingrese la hora en formato HH:MM (00:00 para salir): ");
            String hora = scanner.nextLine();
            
            // Si la hora es "00:00", terminamos el programa
            if (hora.equals("00:00")) {
                break;
            }
            
            // Extraer horas y minutos usando caracteres
            char hora1 = hora.charAt(0);
            char hora2 = hora.charAt(1);
            char minuto1 = hora.charAt(3);
            char minuto2 = hora.charAt(4);
            
            // Convertir caracteres a enteros
            int horas = (hora1 - '0') * 10 + (hora2 - '0');
            int minutos = (minuto1 - '0') * 10 + (minuto2 - '0');
            
            // Calcular los minutos que faltan para medianoche
            int totalMinutos = (24 * 60) - (horas * 60 + minutos);
            
            // Mostrar el resultado
            System.out.println("Faltan " + totalMinutos + " minutos para medianoche.");
        }
        
        scanner.close();
    }
}


/*import java.util.Scanner;

public class CuentaMinutos {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        while (true) {
            String hora = scanner.nextLine();
            
            // Verificar que la entrada tenga el formato correcto
            if (hora.length() == 5 && hora.charAt(2) == ':') {
                // Extraer horas y minutos usando solo la conversión de String a int
                int horas = Integer.parseInt(hora.substring(0, 2));
                int minutos = Integer.parseInt(hora.substring(3, 5));
                
                // Validar horas y minutos
                if (horas >= 0 && horas < 24 && minutos >= 0 && minutos < 60) {
                    // Calcular los minutos que faltan para medianoche
                    int totalMinutos = (24 * 60) - (horas * 60 + minutos);
                    System.out.println(totalMinutos);
                } else {
                    System.out.println("Horas o minutos inválidos");
                }
            } else {
                System.out.println("Formato de hora inválido");
            }
            
            // Salir si se ingresa "00:00"
            if (hora.equals("00:00")) {
                break;
            }
        }
        
        scanner.close();
    }
} */