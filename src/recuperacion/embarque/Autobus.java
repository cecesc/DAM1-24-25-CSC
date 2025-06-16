package recuperacion.embarque;

public class Autobus extends Vehiculo {
    private static final int PESO_POR_PASAJERO = 75;
    private int pesoPropio;

    public Autobus(String matricula, int pasajeros, int pesoPropio) {
        super(matricula, pasajeros);
        this.pesoPropio = pesoPropio;
    }

    @Override
    public int getPeso() {
        return pesoPropio + pasajeros * PESO_POR_PASAJERO;
    }

    @Override
    public String toString() {
        return "Autobus: " + matricula + " - Pasajeros: " + pasajeros + " - Peso: " + pesoPropio;
    }
}