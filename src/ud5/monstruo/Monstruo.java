package ud5.monstruo;

public class Monstruo {
public String nombre;
public int ataque;
public int defensa;
public int velocidad;
public int puntosVida;

boolean vivo = true;


public boolean perderVida(int puntos) {
    puntosVida -= puntos;
    if (puntosVida <= 0) {
        vivo = false;
        puntosVida = 0;
    }
    return !vivo;
}

public boolean estaVivo() {
    return vivo;
}

}
