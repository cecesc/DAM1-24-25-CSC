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

    public void mostrarSoluciones() {
        double discriminante = b * b - 4 * a * c;

        if (discriminante < 0) {
            System.out.println("No hay soluciones reales.");
        } else if (discriminante == 0) {
            double solucion = -b / (2 * a);
            System.out.println("La solución es: " + solucion);
        } else {
            double sol1 = (-b + Math.sqrt(discriminante)) / (2 * a);
            double sol2 = (-b - Math.sqrt(discriminante)) / (2 * a);
            System.out.println("Las soluciones son: " + sol1 + " y " + sol2);
        }
    }

    public boolean esDiscriminantePositivo() {
        return (b * b - 4 * a * c) > 0;
    }
}