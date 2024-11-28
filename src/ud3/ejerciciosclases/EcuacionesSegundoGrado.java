/* Implementa una clase que permita resolver ecuaciones de segundo grado. Los coeficientes pueden indicarse en el constructor y modificarse a posteriori. Es fundamental que la clase disponga de un método que devuelva las distintas soluciones y de un método que nos informe si el discriminante es positivo. */

package ud3.ejerciciosclases;

public class EcuacionesSegundoGrado {
    private double a;
    private double b;
    private double c;

    public EcuacionesSegundoGrado(double a, double b, double c) {
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
            return new double[] { x }; // Una solución
        } else {
            double x1 = (-b + Math.sqrt(discriminante)) / (2 * a);
            double x2 = (-b - Math.sqrt(discriminante)) / (2 * a);
            return new double[] { x1, x2 }; // Dos soluciones
        }
    }

    // Método para verificar si el discriminante es positivo
    public boolean esDiscriminantePositivo() {
        return calcularDiscriminante() > 0;
    }

    public static void main(String[] args) {
        EcuacionesSegundoGrado ecuacion = new EcuacionesSegundoGrado(1, -3, 2);
        double[] soluciones = ecuacion.obtenerSoluciones();
        System.out.println("Soluciones: ");
        for (double sol : soluciones) {
            System.out.println(sol);
        }
        System.out.println("¿Discriminante positivo? " + ecuacion.esDiscriminantePositivo());
    }
}
