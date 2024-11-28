/*
Ejercicios para hacer en java
EP0711. Escribe la clase MarcaPagina, que ayuda a llevar el control de la lectura de un
libro. Deberá disponer de métodos para incrementar la página leída, para obtener
información de la última página que se ha leído y para comenzar desde el principio una
nueva lectura del mismo libro.

EP0712. Implementa una clase que permita resolver ecuaciones de segundo grado. Los
coeficientes pueden indicarse en el constructor y modificarse a posteriori. Es fundamental
que la clase disponga de un método que devuelva las distintas soluciones y de un método
que nos informe si el discriminante es positivo.

EP0714. Crea una clase que sea capaz de mostrar el importe de un cambio, por ejemplo, al
realizar una compra, con el menor número de monedas y billetes posibles. */

package ud3.ejerciciosclases;

public class EP0711 {
    
}
/*public class MarcaPagina {
    private int paginaLeida;
    private int totalPaginas;

    public MarcaPagina(int totalPaginas) {
        this.totalPaginas = totalPaginas;
        this.paginaLeida = 0; // Al iniciar, no se ha leído ninguna página
    }

    // Método para incrementar la página leída
    public void incrementarPagina() {
        if (paginaLeida < totalPaginas) {
            paginaLeida++;
        } else {
            System.out.println("Ya has leído todas las páginas del libro.");
        }
    }

    // Método para obtener la última página leída
    public int obtenerPaginaLeida() {
        return paginaLeida;
    }

    // Método para reiniciar la lectura
    public void reiniciarLectura() {
        paginaLeida = 0;
    }

    public static void main(String[] args) {
        MarcaPagina marca = new MarcaPagina(100);
        marca.incrementarPagina();
        System.out.println("Página leída: " + marca.obtenerPaginaLeida());
        marca.reiniciarLectura();
        System.out.println("Lectura reiniciada. Página leída: " + marca.obtenerPaginaLeida());
    }
}*/


/*public class EcuacionSegundoGrado {
    private double a;
    private double b;
    private double c;

    public EcuacionSegundoGrado(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    // Método para modificar los coeficientes
    public void setCoeficientes(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    // Método para calcular el discriminante
    public double calcularDiscriminante() {
        return b * b - 4 * a * c;
    }

    // Método para obtener las soluciones
    public double[] obtenerSoluciones() {
        double discriminante = calcularDiscriminante();
        if (discriminante < 0) {
            return new double[0]; // No hay soluciones reales
        } else if (discriminante == 0) {
            double x = -b / (2 * a);
            return new double[]{x}; // Una solución
        } else {
            double x1 = (-b + Math.sqrt(discriminante)) / (2 * a);
            double x2 = (-b - Math.sqrt(discriminante)) / (2 * a);
            return new double[]{x1, x2}; // Dos soluciones
        }
    }

    // Método para verificar si el discriminante es positivo
    public boolean esDiscriminantePositivo() {
        return calcularDiscriminante() > 0;
    }

    public static void main(String[] args) {
        EcuacionSegundoGrado ecuacion = new EcuacionSegundoGrado(1, -3, 2);
        double[] soluciones = ecuacion.obtenerSoluciones();
        System.out.println("Soluciones: ");
        for (double sol : soluciones) {
            System.out.println(sol);
        }
        System.out.println("¿Discriminante positivo? " + ecuacion.esDiscriminantePositivo());
    }
}*/


/*import java.util.HashMap;
import java.util.Map;

public class Cambios {
    private static final int[] DENOMINACIONES = {50000, 20000, 10000, 5000, 2000, 1000, 500, 200, 100, 50, 20, 10, 5, 1};

    public static Map<Integer, Integer> calcularCambio(int totalCompra, int dineroEntregado) {
        Map<Integer, Integer> cambio = new HashMap<>();
        int cantidadCambio = dineroEntregado - totalCompra;

        if (cantidadCambio < 0) {
            System.out.println("Dinero entregado no es suficiente.");
            return cambio; // Retornar un mapa vacío si no hay suficiente dinero
        }

        for (int denominacion : DENOMINACIONES) {
            int numBilletes = cantidadCambio / denominacion;
            if (numBilletes > 0) {
                cambio.put(denominacion, numBilletes);
                cantidadCambio -= numBilletes * denominacion;
            }
        }
        return cambio;
    }

    public static void main(String[] args) {
        int totalCompra = 12345; // Total de la compra
        int dineroEntregado = 20000; // Dinero entregado
        Map<Integer, Integer> cambio = calcularCambio(totalCompra, dineroEntregado);
        
        System.out.println("Cambio a devolver:");
        for (Map.Entry<Integer, Integer> entry : cambio.entrySet()) {
            System.out.println("Billetes de " + entry.getKey() + ": " + entry.getValue());
        }
    }
}*/