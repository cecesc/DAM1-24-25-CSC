package ud5.rol;

import java.util.Random;

public class Personaje {
    String nombre;
    enum raza { HUMANO, ELFO, ENANO, HOBBIT, ORCO, TROLL };
    raza raza;
    int nivel = 1;
    int experiencia = 0;
    int fuerza, agilidad, constitucion
    Random rdn = new Random();

    

    public Personaje(String nombre, Raza raza) throws IllegalArgumentException {
        if (nombre == null || nombre.isEmpty()) {
            throw new IllegalArgumentException("El nombre no puede estar vacío.");
        }
        if (raza == null) {
            throw new IllegalArgumentException("La raza no puede ser nula.");
        }
        this.nombre = nombre;
        this.raza = raza;

        this.fuerza = rdn.nextInt(100) + 1;
        this.agilidad = rdn.nextInt(100) + 1;
        this.constitucion = rdn.nextInt(100) + 1;
        this.puntoVida = 50 + constitucion;
    }

    public Personaje(String nombre) {
        this.nombre = nombre;
        this.raza = raza.HUMANO;
    }

    void mostrar() {
        System.out.println("Nombre: " + nombre);
        System.out.println("Raza: " + raza);
        System.out.println("Nivel: " + nivel);
        System.out.println("Experiencia: " + experiencia);
        System.out.println("Puntos de vida: " + puntoVida);
        System.out.println("Fuerza: " + fuerza);
        System.out.println("Agilidad: " + agilidad);
        System.out.println("Constitucion: " + constitucion);

    }

    @Override
    public String toString() {
        return nombre + "  ( " + puntoVida + " / " + puntoVida + " )";
    }
}
