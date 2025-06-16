package recuperacion.embarque;

public class Camion extends Vehiculo {
    private static final int PESO_POR_CONDUCTOR = 75;
    private int pesoPropio;

    public Camion(String matricula, int pasajeros, int pesoPropio) {
        super(matricula, pasajeros);
        this.pesoPropio = pesoPropio;
    }

    @Override
    public int getPeso() {
        return pesoPropio + pasajeros * PESO_POR_CONDUCTOR;
    }

    @Override
    public String toString() {
        return "Camion: " + matricula + " - Pasajeros: " + pasajeros + " - Peso: " + pesoPropio;
    }
}