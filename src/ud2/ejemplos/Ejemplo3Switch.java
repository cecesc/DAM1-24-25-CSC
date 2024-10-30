package ud2.ejemplos;

import java.util.*;
import java.io.*;

public class Ejemplo3Switch {
   public static void main(String[] args) throws IOException {
      int A, B, resultado = 0;
      char operador;
      boolean calculado = true;

      Scanner sc = new Scanner(System.in);
      System.out.print("Introduzca un numero entero:");
      A = sc.nextInt();
      System.out.print("Introduzca otro numero entero:");
      B = sc.nextInt();
      System.out.print("Introduzca un operador (+,-,*,/):");
      operador = (char) System.in.read();
      // operador = sc.nextLine().charAt(0); Tambien podríamos poner esta
      sc.close();

      switch (operador) {
         case '-':
            resultado = A - B;
            break;
         case '+':
            resultado = A + B;
            break;
         case '*':
            resultado = A * B;
            break;
         case '/':
            if (B != 0) {
               resultado = A / B;
            } else {
               System.out.println("\nNo se puede dividir por cero");
               calculado = false;
            }
            break;
         default:
            System.out.println("\nOperador no valido");
            calculado = false;
      }
      if (calculado) {
         System.out.println("\nEl resultado es: " + resultado);
      }
   }
}