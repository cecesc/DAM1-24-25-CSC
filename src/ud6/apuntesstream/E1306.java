package ud6.apuntesstream;

import java.util.function.Consumer;

import ud6.apuntescolecciones.Cliente;
public class E1306 {
    public static <T> void paraCada(T[] t, Consumer<T> c) {
        for (T elem : t) {
            c.accept(elem);
        }
    }
    public static void main(String[] args) {
        Cliente[] clientes = {
            new Cliente("Ana", 30),
            new Cliente("Jorge", 45)
        };
                paraCada(clientes,  cliente  ->  System.out.println(cliente.getNombre()  +  "  -  "  +
cliente.getEdad()));
    }
}
