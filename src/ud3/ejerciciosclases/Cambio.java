/* Crea una clase que sea capaz de mostrar el importe de un cambio, por ejemplo, al realizar una compra, 
con el menor número de monedas y billetes posibles. */

package ud3.ejerciciosclases;

public class Cambio {
    private int cantidad;

    public Cambio(int cantidad) {
        this.cantidad = cantidad;
    }

    public void mostrarCambio() {
        int billete100 = cantidad / 100;
        cantidad %= 100;

        int billete50 = cantidad / 50;
        cantidad %= 50;

        int billete20 = cantidad / 20;
        cantidad %= 20;

        int billete10 = cantidad / 10;
        cantidad %= 10;

        int billete5 = cantidad / 5;
        cantidad %= 5;

        int moneda2 = cantidad / 2;
        cantidad %= 2;

        int moneda1 = cantidad;

        // Mostrar el resultado
        if (billete100 > 0) {
            System.out.println(billete100 + " billete(s) de 100 euros");
        }
        if (billete50 > 0) {
            System.out.println(billete50 + " billete(s) de 50 euros");
        }
        if (billete20 > 0) {
            System.out.println(billete20 + " billete(s) de 20 euros");
        }
        if (billete10 > 0) {
            System.out.println(billete10 + " billete(s) de 10 euros");
        }
        if (billete5 > 0) {
            System.out.println(billete5 + " billete(s) de 5 euros");
        }
        if (moneda2 > 0) {
            System.out.println(moneda2 + " moneda(s) de 2 euros");
        }
        if (moneda1 > 0) {
            System.out.println(moneda1 + " moneda(s) de 1 euro");
        }
    }
}
