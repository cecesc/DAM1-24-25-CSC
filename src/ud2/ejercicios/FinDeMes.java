package ud2.ejercicios;

import java.util.Scanner;

public class FinDeMes {
    // Función que verifica si se llega a fin de mes con saldo positivo o cero
    public static String verificarSaldo(int saldoInicial, int cambioEstimado) {
        int saldoFinal = saldoInicial + cambioEstimado;
        return saldoFinal >= 0 ? "SI" : "NO";
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        while (true) {
            // Solicitar al usuario que ingrese el saldo inicial y el cambio estimado
            System.out.print("Ingrese el saldo inicial y el cambio estimado (0 0 para salir): ");
            int saldoInicial = scanner.nextInt();
            int cambioEstimado = scanner.nextInt();
            
            // Terminar si ambos valores son cero
            if (saldoInicial == 0 && cambioEstimado == 0) {
                break;
            }
            
            // Llamar a la función y mostrar el resultado
            System.out.println(verificarSaldo(saldoInicial, cambioEstimado));
        }
        
        // Cerrar el Scanner
        scanner.close();
    }
}