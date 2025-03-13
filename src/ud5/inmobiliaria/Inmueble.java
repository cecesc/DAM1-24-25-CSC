package ud5.inmobiliaria;

import java.util.Arrays;
import java.util.Comparator;

public abstract class Inmueble {
    public String direccion;
    public int precioAlquiler;
    public int precioVenta;
    public int metroCuadrado;
    public int habitaciones;
    public int baños;

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

    static void mostrarInmuebles(Inmueble[] t) {
        for (int i = 0; i < t.length; i++) {
            System.out.println(t[i].toString());
        }
    }

    static void sortMetrosDesc(Inmueble[] t) {
        Comparator c = new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                int metros1 = ((Inmueble) o1).getMetrosCuadrados();
                int metros2 = ((Inmueble) o2).getMetrosCuadrados();

                return -(metros1 - metros2);
            }
        };
        Arrays.sort(t, c);
    }

    static void sortHabMetrosDesc(Inmueble[] t) {
        Comparator c = new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                int hab1 = ((Inmueble) o1).getHabitaciones();
                int hab2 = ((Inmueble) o2).getHabitaciones();
                int res = -(hab1 - hab2);
                if (res == 0) {
                    int metros1 = ((Inmueble) o1).getMetrosCuadrados();
                    int metros2 = ((Inmueble) o2).getMetrosCuadrados();
                    res = -(metros1 - metros2);
                }
                return res;
            }
        };
        Arrays.sort(t, c);
    }

    static void sortPrecioAlquilerAsc(Inmueble[] t) {
        Comparator c = new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                int precio1 = ((Inmueble) o1).getPrecioVenta();
                int precio2 = ((Inmueble) o2).getPrecioVenta();
                return precio1 - precio2;
            }
        };
        Arrays.sort(t, c);
    }

    static void sortPrecioVentaAsc(Inmueble[] t) {
        Comparator c = new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                int precio1 = ((Inmueble) o1).getPrecioVenta();
                int precio2 = ((Inmueble) o2).getPrecioVenta();
                return precio1 - precio2;
            }
        };

    }

    public int getPrecioAlquiler() {
        return precioAlquiler;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getMetrosCuadrados() {
        return metroCuadrado;
    }

    public void setMetrosCuadrados(int metrosCuadrados) {
        this.metroCuadrado = metrosCuadrados;
    }

    public int getHabitaciones() {
        return habitaciones;
    }

    public void setHabitaciones(int habitaciones) {
        this.habitaciones = habitaciones;
    }

    public int getAseos() {
        return baños;
    }

    public void setAseos(int aseos) {
        this.baños = aseos;
    }


    public int getPrecioVenta() {
        return precioVenta;
    }

    
}