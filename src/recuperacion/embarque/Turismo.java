package recuperacion.embarque;

public class Turismo extends Vehiculo {
    private static final int PESO_BASE = 1000;
    private static final int PESO_POR_PASAJERO = 75;

    public Turismo(String matricula, int pasajeros) {
        super(matricula, pasajeros);
    }

    @Override
    public int getPeso() {
        return PESO_BASE + pasajeros * PESO_POR_PASAJERO;
    }

    @Override
    public String toString() {
        return "Turismo: " + matricula + " - Pasajeros: " + pasajeros;
    }
}