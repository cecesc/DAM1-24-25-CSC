package ud7.animales;

import java.io.Serializable;

public class Felino implements Serializable {
    private String nombre;
    private String especie;
    private int edad;
    private String colorPelaje;
    protected static int numeroEjemplares = 0;
    private int id;

    public Felino(String esp, int ed, String color) {
        this.especie = esp;
        this.edad = ed;
        this.colorPelaje = color;
        numeroEjemplares++;
        this.id = numeroEjemplares;
    }

    public Felino() {
        this("indeterminado", 0, "indeterminado");
    }

    // Getters y setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEspecie() {
        return especie;
    }

    public int getEdad() {
        return edad;
    }

    public String getColorPelaje() {
        return colorPelaje;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Felino{" +
                "nombre='" + nombre + '\'' +
                ", especie='" + especie + '\'' +
                ", edad=" + edad +
                ", colorPelaje='" + colorPelaje + '\'' +
                ", id=" + id +
                '}';
    }
}