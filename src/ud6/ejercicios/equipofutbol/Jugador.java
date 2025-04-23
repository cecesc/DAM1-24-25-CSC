package ud6.ejercicios.equipofutbol;

import ud6.ejercicios.equipofutbol.Ep1237.Posicion;

public class Jugador {
 protected final String dni;
 protected String nombre;
 protected Posicion posicion;
 protected double estatura;

    public Jugador(String dni, String nombre, Posicion posicion, double estatura) {
        this.dni = dni;
        this.nombre = nombre;
        this.posicion = posicion;
        this.estatura = estatura;
    }

    public String getDni() { return dni; }
    public String getNombre() { return nombre; }
    public Posicion getPosicion() { return posicion; }
    public double getEstatura() { return estatura; }

    public void setNombre(String nombre) { this.nombre = nombre; }
    public void setPosicion(Posicion posicion) { this.posicion = posicion; }
    public void setEstatura(double estatura) { this.estatura = estatura; }

    public String toString() {
        return nombre + " (" + posicion + ")";
    }
}
