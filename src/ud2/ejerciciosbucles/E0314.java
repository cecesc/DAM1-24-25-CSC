//Diseñar una aplicación que muestre las tablas de multiplicar del 1 al 10
package ud2.ejerciciosbucles;

public class E0314 {
    public static void main(String[] args) {
        int x, n;
        // mostrar la cabecera de la tabla
        System.out.printf("%10s%n", "x", "x*2", "x*3", "x*4", "x*5");
        for (x = 1; x <= 10; x++) { // filas
            for (n = 1; n <= 5; n++) { // columnas
                System.out.printf("%10.0f", x*n);
            } // fin del for para las columnas
            System.out.println();
        } // fin del for para las filas
    }
}
