package recuperacion.inmobiliaria;


public class Piso extends Inmueble {
    private int planta;

    public Piso(String direccion, int metros, int habitaciones, int banos, int planta) {
        super(direccion, metros, habitaciones, banos);
        this.planta = planta;
    }

    @Override
    public String detalle() {
        StringBuilder sb = new StringBuilder();
        sb.append("Piso en ").append(direccion).append(".\n")
          .append(metros).append(" m2, ")
          .append(habitaciones).append(" hab, ")
          .append(banos).append(" baños, ")
          .append(planta).append("ª planta.\n");
        if (precioAlquiler != null)
            sb.append("Precio de Alquiler: ").append(precioAlquiler).append(" €\n");
        if (precioVenta != null)
            sb.append("Precio de Venta: ").append(precioVenta).append(" €\n");
        return sb.toString();
    }
}
