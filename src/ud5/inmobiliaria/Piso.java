package ud5.inmobiliaria;

public class Piso extends Inmueble {
    int planta;

    public Piso(String direccion, int metroCuadrado, int habitaciones, int baños, int planta) {
        super(direccion, metroCuadrado, habitaciones, baños);
        this.planta = planta;
    }

    @Override
    public String detalle() {
        String detalle = "Piso en " + getDireccion() + ".\n" + getMetrosCuadrados() + " m2, " +
                getHabitaciones() + " hab, " + getAseos() + " baños, " +
                getPlanta() + "ª planta.\n";
        if (getPrecioAlquiler() != 0) {
            detalle += "Precio de alquiler: " + getPrecioAlquiler() + "\n";
        }
        if (getPrecioVenta() != 0) {
            detalle += "Precio de venta: " + getPrecioVenta() + "\n";
        }
        return detalle;
    }

    public int getPlanta() {
        return planta;
    }

    public void setPlanta(int planta) {
        this.planta = planta;
    }

}
