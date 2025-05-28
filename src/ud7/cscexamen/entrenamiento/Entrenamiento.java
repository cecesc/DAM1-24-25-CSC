//Autor:Celia Sanmartín Chapela
package ud7.cscexamen.entrenamiento;

import java.io.Serializable;

public class Entrenamiento implements Serializable {
    public String nombre;
    public String fecha;
    public double kilometros;

    public Entrenamiento(String nombre, String fecha, double kilometros) {
        this.nombre = nombre;
        this.fecha = fecha;
        this.kilometros = kilometros;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public double getKilometros() {
        return kilometros;
    }

    public void setKilometros(double kilometros) {
        this.kilometros = kilometros;
    }

    @Override
    public String toString() {
        return nombre + "   " + fecha + "    " + kilometros;
    }

}
