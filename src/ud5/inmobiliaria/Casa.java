package ud5.inmobiliaria;

public class Casa extends Inmueble {
    int terreno;

    public Casa(int terreno) {
        this.terreno = terreno;
    }

    public Casa(String calle, int metroCuadrado, int habitaciones, int baños, int terreno) {
        this.calle = calle;
        this.metroCuadrado = metroCuadrado;
        this.habitaciones = habitaciones;
        this.baños = baños;
        this.terreno = terreno;

    }

    String detalle() {
        return "en " + calle + ". \n " + metroCuadrado + " m2, " + habitaciones + " hab, " + baños
                + " baños, con terreno de " + terreno + " m2 \n Precio de Venta: " + precioVenta
                + " € \n Precio de Alquiler: " + precioAlquiler + " €";
    }
}
