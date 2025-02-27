package ud5.monstruo;

import java.util.Random;

public class Monstruo {
    String nombre;
    int ataque; 
    int defensa;
    int velocidad;
    int puntosVida;
    int agilidad;
    int puntoVida;

    public Monstruo(String nombre) {
        this.nombre = nombre;
    }

    public Monstruo( int ataque, int defensa, int velocidad, int puntosVida) {
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

    public int atacar(Monstruo monster) {
        Random rdn = new Random();
        int puntAtaque = rdn.nextInt(100) + 1 + ataque;
        int puntDefensa = rdn.nextInt(100) + 1 + monster.agilidad;
        int daño = Math.max(0, Math.min(puntAtaque - puntDefensa, monster.puntoVida));
        monster.perderVida(daño);
        return daño;
    }

    public String toString() {
        return (nombre != null ? nombre + "-" : "") + getClass().getSimpleName() + " (" + puntosVida + ")";
    }

    public static void main(String[] args) {
        Monstruo monster = generaMonstruoAleatorio();
        System.out.println(monster);
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

    public static int rnd(int min, int max) {
        return new Random().nextInt(max - min + 1) + min;

    }

}
