package ud5.inmobiliaria;

public class Piso extends Inmueble {
    int planta;

    public Piso(String direccion, int metroCuadrado, int habitaciones, int baños, int planta) {
        super(direccion, metroCuadrado, habitaciones, baños);
        this.planta = planta;
    }

    @Override
    String detalle() {
        return "Piso en " + direccion + ". \n " + metroCuadrado + " m2, " + habitaciones + " hab, " + baños + " baños, "
                + planta + "ª planta. \n Precio de Venta: " + precioVenta + " € \n Precio de Alquiler: "
                + precioAlquiler + " €";
    }

}
