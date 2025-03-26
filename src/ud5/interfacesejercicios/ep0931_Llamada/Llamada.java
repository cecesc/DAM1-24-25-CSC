package ud5.interfacesejercicios.ep0931_Llamada;

import java.util.Date;

class Llamada implements Comparable<Llamada> {
    String numeroCliente;
    String numeroInterlocutor;
    boolean saliente;
    Date inicio;
    Date fin;
    Zona zona;

    enum Zona { A, B, C, D, E }
    
    private static final double[] TARIFAS = {0.10, 0.20, 0.30, 0.40, 0.50};

    public Llamada(String numeroCliente, String numeroInterlocutor, boolean saliente, Date inicio, Date fin, Zona zona) {
        this.numeroCliente = numeroCliente;
        this.numeroInterlocutor = numeroInterlocutor;
        this.saliente = saliente;
        this.inicio = inicio;
        this.fin = fin;
        this.zona = zona;
    }

    public int getDuracionMinutos() {
        return (int) ((fin.getTime() - inicio.getTime()) / 60000);
    }

    public double getCoste() {
        return saliente ? getDuracionMinutos() * TARIFAS[zona.ordinal()] : 0;
    }

    @Override
    public String toString() {
        return numeroCliente + " ? " + numeroInterlocutor + " - Inicio: " + inicio + " - Duración: " + getDuracionMinutos() + " min - Coste: " + getCoste() + "€";
    }

    @Override
    public int compareTo(Llamada otra) {
        int cmp = this.numeroCliente.compareTo(otra.numeroCliente);
        return cmp != 0 ? cmp : this.inicio.compareTo(otra.inicio);
    }
}
