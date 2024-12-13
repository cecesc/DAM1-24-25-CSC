//Autor: Celia Sanmartín Chapela

package ud3.cscexamen;

import java.util.Random;

public class CocheCarreras {
private String nombre;
private int velocidadMax;
private int maxTurbos;
private int maxAutonomia;
private int turbosRestantes;
private int autonomiaRestante;
private int distanciaRecorrida = 0;

public CocheCarreras(String nombre, int velocidadMax, int maxTurbos, int maxAutonomia) {
    if (velocidadMax < 1 || velocidadMax > 100) {
        throw new IllegalArgumentException(
                "La velocidad máxmima debe estar comprendida entre 1 y 100 metros por segundo.");
    }
    if (maxTurbos < 1) {
        throw new IllegalArgumentException("El número de turbos no puede ser negativo.");
    }

    if (maxAutonomia < 1) {
        throw new IllegalArgumentException("El número de metros de autonomía no puede ser negativo.");
    }

    this.velocidadMax = velocidadMax;
    this.nombre = nombre;
    this.maxTurbos = maxTurbos;
    this.maxAutonomia = maxAutonomia;
    this.turbosRestantes = maxTurbos;
    this.autonomiaRestante = maxAutonomia;
}

public CocheCarreras(String nombre, int velocidadMax, int maxAutonomia) {
    this(nombre, velocidadMax, 3, maxAutonomia);
}

public int avanzar() {
    Random rd = new Random();
    int avance;
    do {
        avance = rd.nextInt(1, velocidadMax + 1);
    } while (avance > autonomiaRestante);

    autonomiaRestante -= avance;
    distanciaRecorrida += avance;

    return avance;
}

public int usarTurbo() {
    int avance = 0;
    if (turbosRestantes > 0) {
        avance = velocidadMax * 150 / 100;
        if (avance > autonomiaRestante) {
            avance = autonomiaRestante;
        }
        autonomiaRestante -= avance;
        distanciaRecorrida += avance;
        turbosRestantes--;
    }
    return avance;
}

public void repostar() {
    this.autonomiaRestante = this.maxAutonomia;
    this.maxTurbos = this.turbosRestantes;
}

public void reiniciarDistancia() {
    this.distanciaRecorrida = 0;
}

public void mostrar() {
    System.out.println("Coche: " + this.nombre);
    System.out.println("Velocidad Máxima: " + this.velocidadMax + " mps");
    System.out.println("Turbos: " + turbosRestantes + "/" + maxTurbos);
    System.out.println("Autonomía: " + autonomiaRestante + "/" + maxAutonomia);
    System.out.println();
}

public String getNombre() {
    return nombre;
}
public int getVelocidadMax() {
    return velocidadMax;
}

public int getTurbosRestantes() {
    return turbosRestantes;
}

public int getAutonomiaRestante() {
    return autonomiaRestante;
}

public int getDistanciaRecorrida() {
    return distanciaRecorrida;
}

public static void main(String[] args) {
    System.out.println("RAYO");
    System.out.println("====");
    CocheCarreras rayo = new CocheCarreras("Rayo", 90, 400);
    rayo.mostrar();
    rayo.avanzar();
    rayo.usarTurbo();
    rayo.mostrar();
    System.out.println("TRUENO");
    System.out.println("======");
    CocheCarreras trueno = new CocheCarreras("Trueno", 60, 5, 300);
    trueno.mostrar();
    while (trueno.getAutonomiaRestante() != 0)
        trueno.usarTurbo();
    trueno.mostrar();
    trueno.repostar();
    trueno.mostrar();
}

}