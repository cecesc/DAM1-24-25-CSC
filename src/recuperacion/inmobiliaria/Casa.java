package recuperacion.inmobiliaria;

public class Casa extends Inmueble {
    private int metrosTerreno;

    public Casa(String direccion, int metros, int habitaciones, int banos, int metrosTerreno) {
        super(direccion, metros, habitaciones, banos);
        this.metrosTerreno = metrosTerreno;
    }

    @Override
    public String detalle() {
        StringBuilder sb = new StringBuilder();
        sb.append("Casa en ").append(direccion).append(".\n")
          .append(metros).append(" m2, ")
          .append(habitaciones).append(" hab, ")
          .append(banos).append(" baños, ")
          .append("con terreno de ").append(metrosTerreno).append(" m2.\n");
        if (precioAlquiler != null)
            sb.append("Precio de Alquiler: ").append(precioAlquiler).append(" €\n");
        if (precioVenta != null)
            sb.append("Precio de Venta: ").append(precioVenta).append(" €\n");
        return sb.toString();
    }
}