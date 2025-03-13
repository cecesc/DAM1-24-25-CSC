package ud5.inmobiliaria;

public class Casa extends Inmueble {
    int terreno;


    public Casa(String direccion, int metroCuadrado, int habitaciones, int baños, int terreno) {
        super(direccion, metroCuadrado, habitaciones, baños);
        this.terreno = terreno;
    }

    @Override
    public String detalle() {
        String detalle = "Casa en " + getDireccion() + ".\n" + getMetrosCuadrados() + " m2, " +
                getHabitaciones() + " hab, " + getAseos() + " baños, con terreno de " +
                getMetrosCuadradosFinca() + " m2.\n";
        if (getPrecioAlquiler() != 0) {
            detalle += "Precio de alquiler: " + getPrecioAlquiler() + "\n";
        }
        if (getPrecioVenta() != 0) {
            detalle += "Precio de venta: " + getPrecioVenta() + "\n";
        }
        return detalle;
    }

    
    public int getMetrosCuadradosFinca() {
        return terreno;
    }

    
}
