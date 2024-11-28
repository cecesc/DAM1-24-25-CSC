package ud3.ejerciciosclases;

public class Ayuda {
    public static void main(String[] args) {
    }
    
}










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