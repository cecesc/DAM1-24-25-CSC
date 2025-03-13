package ud5.inmobiliaria;

import java.util.Arrays;
import java.util.Comparator;

public class Inmueble implements Comparable {
    public String direccion;
    int precioAlquiler;
    int precioVenta;
    int metroCuadrado;
    int habitaciones;
    int baños;



    
    public Inmueble(String direccion, int metroCuadrado, int habitaciones, int baños) {
        this.direccion = direccion;
        this.metroCuadrado = metroCuadrado;
        this.habitaciones = habitaciones;
        this.baños = baños;
    }

    public void setPrecioAlquiler(int precioAlquiler) {
        this.precioAlquiler = precioAlquiler;
    }

    public void setPrecioVenta(int precioVenta) {
        this.precioVenta = precioVenta;
    }

    @Override
    public String toString() {
        return "Inmueble en " + direccion + " ( " + metroCuadrado + " m2, " + habitaciones + " hab)";
    }


    String detalle() {
        return "en " + direccion + ". \n " + metroCuadrado + " m2, " + habitaciones + " hab, " + baños
                + " baños \n Precio de Venta: " + precioVenta + " € \n Precio de Alquiler: " + precioAlquiler + " €";
    }

    
    @Override
    public int compareTo(Inmueble otro) {
        return this.direccion.compareTo(otro.direccion);
    }

    public static void mostrarInmuebles(Inmueble[] t) {
        for (Inmueble i : t) {
            System.out.println(i);
        }
    }

    public static void sortMetrosDesc(Inmueble[] t) {
        Arrays.sort(t, Comparator.comparingInt((Inmueble i) -> i.metroCuadrado).reversed());
    }

    public static void sortHabMetrosDesc(Inmueble[] t) {
        Arrays.sort(t, Comparator.comparingInt((Inmueble i) -> i.habitaciones)
                .thenComparingInt(i -> i.metroCuadrado)
                .reversed());
    }

    public static void sortPrecioAlquilerAsc(Inmueble[] t) {
        Arrays.sort(t, Comparator.comparingInt(i -> (i.precioAlquiler > 0 ? i.precioAlquiler : Integer.MAX_VALUE)));
    }

    public static void sortPrecioVentaAsc(Inmueble[] t) {
        Arrays.sort(t, Comparator.comparingInt(i -> (i.precioVenta > 0 ? i.precioVenta : Integer.MAX_VALUE)));
    }
}
/*package ud5.inmobiliaria;



    @Override
    public int compareTo(Inmueble otro) {
        return this.direccion.compareTo(otro.direccion);
    }

    public static void mostrarInmuebles(Inmueble[] t) {
        for (Inmueble i : t) {
            System.out.println(i);
        }
    }

    public static void sortMetrosDesc(Inmueble[] t) {
        Arrays.sort(t, Comparator.comparingInt((Inmueble i) -> i.metroCuadrado).reversed());
    }

    public static void sortHabMetrosDesc(Inmueble[] t) {
        Arrays.sort(t, Comparator.comparingInt((Inmueble i) -> i.habitaciones)
                .thenComparingInt(i -> i.metroCuadrado)
                .reversed());
    }

    public static void sortPrecioAlquilerAsc(Inmueble[] t) {
        Arrays.sort(t, Comparator.comparingInt(i -> (i.precioAlquiler > 0 ? i.precioAlquiler : Integer.MAX_VALUE)));
    }

    public static void sortPrecioVentaAsc(Inmueble[] t) {
        Arrays.sort(t, Comparator.comparingInt(i -> (i.precioVenta > 0 ? i.precioVenta : Integer.MAX_VALUE)));
    }
}
 */