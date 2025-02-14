package ud5.clasesejercicios.E0710.personal;

import java.time.LocalDate;

import ud5.clasesejercicios.E0710.maquinista.Locomotora;

public class Mecanico {
    String nombre;
    String telefono;
    Especialidad especialidad;
    
    public Mecanico() {
    }

    public Mecanico(String nombre, String telefono, Especialidad especialidad) {
        this.nombre = nombre;
        this.telefono = telefono;
        this.especialidad = especialidad;
    }

    @Override
    public String toString() {
        return "Mecanico [nombre=" + nombre + ", telefono=" + telefono + ", especialidad=" + especialidad + "]";
    }

    public void revisar(Locomotora locomotora){
        System.out.println("El mecánico"+ nombre + " ha revisado " + especialidad
        + " de la locomotrora" + locomotora +" con fecha " +LocalDate.now());
        
    }

    
}
