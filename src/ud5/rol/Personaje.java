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
    final int MAX_VIDA = constitucion + 50;
    boolean vivo = true;

    public Personaje(String nombre, raza raza) throws IllegalArgumentException {
        if (nombre == null || nombre.isEmpty()) {
            throw new IllegalArgumentException("El nombre no puede estar vacío.");
        }
        if (raza == null) {
            throw new IllegalArgumentException("La raza no puede ser nula.");
        }
        this.nombre = nombre;
        this.raza = raza;
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
        return nombre + "  ( " + puntoVida + " / " + MAX_VIDA + " )";
    }

    public byte sumarExperiencia(int puntos) {
        experiencia += puntos;
        byte nivelSubido = 0;
        while (experiencia / 1000 > nivel - 1) {
            subirNivel();
            nivelSubido++;
        }
        return nivelSubido;
    }

    public void subirNivel() {
        nivel++;
        fuerza *= 1.05;
        agilidad *= 1.05;
        constitucion *= 1.05;
    }

    public void curar() {
        if (puntoVida < MAX_VIDA) {
            puntoVida = MAX_VIDA;
        }
    }

    public boolean perderVida(int puntos) {
        puntoVida -= puntos;
        if (puntoVida <= 0) {
            vivo = false;
            puntoVida = 0;
        }
        return !vivo;
    }

    public boolean estaVivo() {
        return vivo;
    }

    public int atacar(Personaje enemigo) {
        int puntAtaque = rdn.nextInt(100) + 1;
        int puntDefensa = rdn.nextInt(100) + 1;

        int ataque = puntAtaque + fuerza;
        int defensa = puntDefensa + agilidad;
        int daño = Math.max(0, Math.min(ataque - defensa, enemigo.puntoVida));
        enemigo.perderVida(daño);
        this.sumarExperiencia(daño);
        enemigo.sumarExperiencia(daño);
        return daño;
    }

    public String getNombre() {
        return nombre;
    }

    public int getPuntoVida() {
        return puntoVida;
    }

}
