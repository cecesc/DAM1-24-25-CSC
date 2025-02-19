package ud5.rol;

import java.util.Random;

public class Personaje {
    String nombre;

    enum raza {
        HUMANO, ELFO, ENANO, HOBBIT, ORCO, TROLL
    };

    raza raza;
    int nivel = 1;
    int experiencia = 0;

    Random rdn = new Random();
    int fuerza = rdn.nextInt(100) + 1;
    int agilidad = rdn.nextInt(100) + 1;
    int constitucion = rdn.nextInt(100) + 1;

    int puntoVida = 50 + constitucion;

    public Personaje(String nombre, raza raza) {
        this.nombre = nombre;
        this.raza = raza;
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
