package ud5.rol.monstruo;

import java.util.Random;

import ud5.rol.Personaje;

public class Monstruo extends Personaje {
    String nombre;
    int ataque, defensa, velocidad, puntosVida, maxVida;

    public Monstruo(String nombre, int ataque, int defensa, int velocidad, int puntosVida) {
        super(nombre);
        this.ataque = ataque;
        this.defensa = defensa;
        this.velocidad = velocidad;
        this.puntosVida = puntosVida;
    }

    public boolean estaVivo() {
        return puntosVida > 0;
    }

    public boolean perderVida(int puntos) {
        puntosVida -= puntos;
        if (puntosVida <= 0) {
            puntosVida = 0;
            return true;
        }
        return false;
    }

    public int atacar(Personaje enemigo) {
        Random rdn = new Random();
        int puntAtaque = rdn.nextInt(100) + 1 + ataque;
        int puntDefensa = rdn.nextInt(100) + 1 + enemigo.agilidad;
        int daño = Math.max(0, Math.min(puntAtaque - puntDefensa, enemigo.puntoVida));
        enemigo.perderVida(daño);
        return daño;
    }

    public String toString() {
        return (nombre != null ? nombre + "-" : "") + getClass().getSimpleName() + " (" + puntosVida + ")";
    }

    public static void main(String[] args) {
        Monstruo m = generaMonstruoAleatorio();
        System.out.println("Monstruo generado: " + m);
    }

    public static Monstruo generaMonstruoAleatorio() {
        Random rdn = new Random();
        int prob = rdn.nextInt(100);
        if (prob < 40)
            return new Orco();
        if (prob < 70)
            return new Aranha();
        if (prob < 90)
            return new Troll();
        return new Dragon();
    }
//Prueba
    public static int rnd(int min, int max) {
        return new Random().nextInt(max - min + 1) + min;

    }
}
