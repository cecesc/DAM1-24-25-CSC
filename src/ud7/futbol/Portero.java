package ud7.futbol;

import java.io.Serializable;

public class Portero extends Jugador implements Serializable {
    private static final long serialVersionUID = 1L;

    private int golesRecibidos;
    private int penaltisParados;

    public Portero(String nombre, String demarcacion, int partidosJugados, int golesMarcados,
                   int tarjetasAmarillas, int tarjetasRojas, int golesRecibidos, int penaltisParados) {
        super(nombre, demarcacion, partidosJugados, golesMarcados, tarjetasAmarillas, tarjetasRojas);
        this.golesRecibidos = golesRecibidos;
        this.penaltisParados = penaltisParados;
    }

    public Portero() {
        super();
        golesRecibidos = 0;
        penaltisParados = 0;
    }

    public int getGolesRecibidos() {
        return golesRecibidos;
    }

    public void setGolesRecibidos(int golesRecibidos) {
        this.golesRecibidos = golesRecibidos;
    }

    public int getPenaltisParados() {
        return penaltisParados;
    }

    public void setPenaltisParados(int penaltisParados) {
        this.penaltisParados = penaltisParados;
    }

    @Override
    public void imprimir() {
        super.imprimir();
        System.out.println("Goles Recibidos: " + golesRecibidos);
        System.out.println("Penaltis Parados: " + penaltisParados);
    }
}