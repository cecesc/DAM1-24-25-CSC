package ud5.inmobiliaria;

public class Casa extends Inmueble {
    int terreno;


    public Casa(String direccion, int metroCuadrado, int habitaciones, int baños, int terreno) {
        super(direccion, metroCuadrado, habitaciones, baños);
        this.terreno = terreno;
    }

    @Override
    String detalle() {
        return "Casa en " + direccion + ". \n " + metroCuadrado + " m2, " + habitaciones + " hab, " + baños
                + " baños, con terreno de " + terreno + " m2 \n Precio de Venta: " + precioVenta
                + " € \n Precio de Alquiler: " + precioAlquiler + " €";
    }
}
