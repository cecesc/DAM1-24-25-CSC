package ud5.clasesejercicios.E0710.personal;

public class Mecanico {
    String nombre;
    String telefono;
    public enum Especialidad {FRENO, HIDRAULICA, ELECTRICIDAD, MOTOR};
    Especialidad especialidad;
    
    public Mecanico() {
    }

    public Mecanico(String nombre, String telefono, Especialidad especialidad) {
        this.nombre = nombre;
        this.telefono = telefono;
        this.especialidad = especialidad;
    }


    
}
