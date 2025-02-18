package ud5.rol;

import java.util.Random;

public class Personaje {
    String nombre;
    Raza raza;
    int nivel = 1;
    int experiencia = 0;
    int puntoVida = 50;

    Random rdn = new Random();
    int fuerza = rdn.nextInt(100) + 1;
    int agilidad = rdn.nextInt(100) + 1;
    int constitucion = rdn.nextInt(100) + 1;

    public Personaje(String nombre, Raza raza, int nivel, int experiencia, int puntoVida, int fuerza,
            int agilidad, int constitucion) {
        this.nombre = nombre;
        this.raza = raza;
        this.nivel = nivel;
        this.experiencia = experiencia;
        this.puntoVida = puntoVida;

        this.fuerza = fuerza;
        this.agilidad = agilidad;
        this.constitucion = constitucion;
    }

    public static void mostrar(String nombre, Raza raza, int fuerza, int agilidad, int constitucion, int nivel,
            int experiencia, int puntoVida) {
        System.out.println("Nombre: " + nombre + "Raza: " + raza + "Fuerza: " + fuerza + "Agilidad: " + agilidad
                + "Constitucion: " + constitucion + "Nivel: " + nivel + "Experiencia: " + experiencia
                + "Puntos de vida: " + puntoVida);
    }

    @Override
    public String toString() {
        return nombre + "(" + puntoVida + "/" + puntoVida + ")";
    }

}
