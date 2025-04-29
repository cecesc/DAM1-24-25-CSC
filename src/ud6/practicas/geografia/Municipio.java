package Geografia;

public class Municipio implements Comparable<Municipio> {

    private String nombre;
    private int poblacion;
    private double temperaturMedia;
    private double altitud;
    
    public Municipio(String nombre, int poblacion, double temperaturMedia, double altitud) {
        this.nombre = nombre;
        this.poblacion = poblacion;
        this.temperaturMedia = temperaturMedia;
        this.altitud = altitud;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getPoblacion() {
        return poblacion;
    }

    public void setPoblacion(int poblacion) {
        this.poblacion = poblacion;
    }

    public double getTemperaturMedia() {
        return temperaturMedia;
    }

    public void setTemperaturMedia(double temperaturMedia) {
        this.temperaturMedia = temperaturMedia;
    }

    public double getAltitud() {
        return altitud;
    }

    public void setAltitud(double altitud) {
        this.altitud = altitud;
    }

    @Override
    public String toString() {
        return "Municipio [nombre=" + nombre + ", poblacion=" + poblacion + ", temperaturMedia=" + temperaturMedia
                + ", altitud=" + altitud + "]";
    }

    @Override
    public int compareTo(Municipio o) {
        return this.poblacion - o.getPoblacion();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        Municipio municipio = (Municipio) obj;

        return nombre != null ? nombre.equals(municipio.nombre) : municipio.nombre == null;
    }

    @Override
    public int hashCode() {
        return nombre != null ? nombre.hashCode() : 0;
    }
}