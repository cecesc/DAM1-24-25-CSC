package ud5.rol;

import java.util.Random;

public class Monstruo extends Personaje {
    enum Monstruos {
        Orco, Troll, Aranha, Dragon
    };

    Monstruos monstruo;
    public String nombre;

    Random rdn = new Random();

    int ataqueOrco = rdn.nextInt(30, 80) + 1;
    int defensaOrco = rdn.nextInt(30, 50) + 1;
    int velocidadOrco = rdn.nextInt(30, 60) + 1;
    int puntosVidaOrco = rdn.nextInt(30, 100) + 1;

    int ataqueTroll = rdn.nextInt(60, 120) + 1;
    int defensaTroll = rdn.nextInt(50, 70) + 1;
    int velocidadTroll = rdn.nextInt(20, 40) + 1;
    int puntosVidaTroll = rdn.nextInt(100, 200) + 1;

    int ataqueAranha = rdn.nextInt(10, 50) + 1;
    int defensaAranha = rdn.nextInt(20, 40) + 1;
    int velocidadAranha = rdn.nextInt(40, 70) + 1;
    int puntosVidaAranha = rdn.nextInt(30, 80) + 1;

    int ataqueDragon = rdn.nextInt(100, 200) + 1;
    int defensaDragon = rdn.nextInt(60, 100) + 1;
    int velocidadDragon = rdn.nextInt(80, 120) + 1;
    int puntosVidaDragon = rdn.nextInt(120, 250) + 1;

    boolean vivo = true;

    public Monstruo(String nombre) {
        super(nombre);
    }

    public Monstruo(String nombre, Monstruos monstruo) {
        super(nombre);
        this.monstruo = Monstruos.Orco;

    }

    public boolean perderVida(int puntos) {
        puntosVidaOrco -= puntos;
        if (puntosVidaOrco <= 0) {
            vivo = false;
            puntosVidaOrco = 0;
        }
        return !vivo;
    }

    public boolean estaVivo() {
        return vivo;
    }

    public int atacar(Monstruo m) {
        int puntAtaque = rdn.nextInt(100) + 1;
        int puntDefensa = rdn.nextInt(100) + 1;

        int ataque = puntAtaque + fuerza;
        int defensa = puntDefensa + agilidad;
        int daño = Math.max(0, Math.min(ataque - defensa, m.puntoVida));
        m.perderVida(daño);
        this.sumarExperiencia(daño);
        m.sumarExperiencia(daño);
        return daño;
    }

    @Override
    public String toString() {
        return nombre + "-" + monstruo + "  ( " + puntosVidaOrco + " )";
    }
    
    @Override
    void mostrar() {
        System.out.println("Nombre: " + nombre);
        System.out.println("Monstruo: " + monstruo);
        System.out.println("Puntos de vida: " + puntosVidaDragon);
        System.out.println("Velocidad: " + velocidadDragon);
        System.out.println("Potencia de ataque: " + ataqueDragon);
        System.out.println("Aguante de defensa: " + defensaDragon);
    }

    public static void main(String[] args) {
        System.out.println();
        Monstruo sd= new Monstruo("fe", Monstruos.Dragon);
        sd.mostrar();
    }
}
