package ud4.practicas.agenda;

public class Persona {
    private String nombre;
    private String apellidos;
    private String telefono;
    private String correo;

    public Persona(String nombre, String apellidos, String telefono, String correo) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.telefono = telefono;
        this.correo = correo;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getCorreo() {
        return correo;
    }

    @Override
    public String toString() {
        return "Nombre: " + nombre + ", Apellidos: " + apellidos +
            ", Teléfono: " + telefono + ", Correo: " + correo;
    }
}

