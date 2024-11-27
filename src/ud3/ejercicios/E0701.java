/* Diseñar la clase cuentacorriente, que almacena los datos: DNI y nombre del titular, asi como el saldo. Las operaciones típicas con una cuenta corriente son:

● Crear una cuenta: se necesita el DNI y nombre del titular. El saldo inicial será 0.

● Sacar dinero: el método debe indicar si ha sido posible llevar a cabo la operación, si existe saldo suficiente.

● Ingresar dinero: se incrementa el saldo.

● Mostrar información: muestra la información disponible de la cuenta corriente. */

package ud3.ejercicios;

public class E0701 {
    public static void main(String[] args) {
        CuentaCorriente cc= new CuentaCorriente("53713575k", "Maripepi");
        cc.mostrarInfo();

        cc.ingresaDinero(200);
        cc.mostrarInfo();

        System.out.println(cc.sacarDinero(100));
        cc.mostrarInfo();

        cc.ingresaDinero(-200);
        cc.mostrarInfo();

        System.out.println("Fin");
    }
}

   