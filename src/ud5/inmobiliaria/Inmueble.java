package ud5.inmobiliaria;

public class Inmueble {
    public String calle;
    int precioAlquiler;
    int precioVenta;
    int metroCuadrado;
    int habitaciones;
    int baños;

    public void setPrecioAlquiler(int precioAlquiler) {
        this.precioAlquiler = precioAlquiler;
    }

    public void setPrecioVenta(int precioVenta) {
        this.precioVenta = precioVenta;
    }

    @Override
    public String toString() {
        return "Inmueble en " + calle + " ( " + metroCuadrado + " m2, " + habitaciones + " hab)";
    }

    /*
     * Inmueble en Calle Curtidoira (100 m2, 3 hab) --
     * Inmueble en Carretera de Marín (250 m2, 4 hab) --
     * Piso en Calle Curtidoira.
     * 100 m2, 3 hab, 2 baños, 5ª planta.
     * Precio de Alquiler: 500 €
     * Precio de Venta: 200000 €
     * Piso en Praza Maior.
     * 80 m2, 2 hab, 2 baños, 3ª planta.
     * Precio de Alquiler: 400 €
     * Casa en Lapaman.
     * 150 m2, 3 hab, 2 baños, con t
     */

    String detalle() {
        return "en " + calle + ". \n " + metroCuadrado + " m2, " + habitaciones + " hab, " + baños
                + " baños \n Precio de Venta: " + precioVenta + " € \n Precio de Alquiler: " + precioAlquiler + " €";
    }

}
