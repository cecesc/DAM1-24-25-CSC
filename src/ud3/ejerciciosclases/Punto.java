/*EP0716. Escribe la clase Punto que representa un punto en el plano (con un componente x y un componente y), con los métodos:
● Punto(double x, double y): construye un objeto con los datos pasados como parámetros.
● void desplazaX(double dx): incrementa el componente x en la cantidad dx..
● void desplazaY(double dy): incrementa el componente y en la cantidad dy.
● void desplaza(double dx, double dy): desplaza ambos componentes según las cantidades dx (en el eje x) y dy (en el componente y).
● double distanciaEuclidea(Punto otro): calcula y devuelve la distancia euclidea entre el punto invocante y el punto otro.
● void muestra(): muestra por consola la información relativa al punto. Ejemplo: (1.5, 4.6)
 */

package ud3.ejerciciosclases;

public class Punto {

    private double x;
    private double y;

    public Punto(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public void desplazaX(double dx) {
        x += dx;
    }

    public void desplazaY(double dy) {
        y += dy;
    }

    public void desplaza(double dx, double dy) {
        desplazaX(dx);
        desplazaY(dy);
    }

    public double distanciaEuclidea(Punto otro) {
        return Math.sqrt(Math.pow(otro.x - this.x, 2) + Math.pow(otro.y - this.y, 2));
    }

    public void muestra() {
        System.out.println("(" + x + ", " + y + ")");
    }
}
