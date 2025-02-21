package ud5.inmobiliaria;

public class Piso extends Inmueble {
    int planta;

    public Piso(String calle, int metroCuadrado, int habitaciones, int baños, int planta) {
        this.calle = calle;
        this.metroCuadrado = metroCuadrado;
        this.habitaciones = habitaciones;
        this.baños = baños;
        this.planta = planta;
    }

    String detalle() {
        return " en " + calle + ". \n " + metroCuadrado + " m2, " + habitaciones + " hab, " + baños + " baños, "
                + planta + "ª planta. \n Precio de Venta: " + precioVenta + " € \n Precio de Alquiler: "
                + precioAlquiler + " €";
    }

}
