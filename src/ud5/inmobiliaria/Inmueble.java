package ud5.inmobiliaria;

public class Inmueble {
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

}
