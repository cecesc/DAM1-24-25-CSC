package contornos.ud5.cadenasupermercado;

public class Proveedor {
    private int id;
    private String nombre;
    private String direccion;

    
    public Proveedor(int id, String nombre, String direccion) {
        this.id = id;
        this.nombre = nombre;
        this.direccion = direccion;
    }


    @Override
    public String toString() {
        return "Proveedor [id=" + id + ", nombre=" + nombre + ", direccion=" + direccion + "]";
    }


}
