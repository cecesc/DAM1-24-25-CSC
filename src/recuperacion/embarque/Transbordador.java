package recuperacion.embarque;

import java.util.ArrayList;
import java.util.List;

public class Transbordador {

    public static final int PESO_MAXIMO = 10000;

    private List<Vehiculo> vehiculos;
    private int pesoTotal;

    public Transbordador() {
        vehiculos = new ArrayList<>();
        pesoTotal = 0;
    }

    public void embarcarVehiculo(Vehiculo v) throws Vehiculo.MatriculaRepetidaException, Vehiculo.SuperadoPesoMaximoException {
        for (Vehiculo ve : vehiculos) {
            if (ve.getMatricula().equals(v.getMatricula())) {
                throw new Vehiculo.MatriculaRepetidaException("Matrícula repetida: " + v.getMatricula());
            }
        }
        int pesoVehiculo = v.getPeso();
        if (pesoTotal + pesoVehiculo > PESO_MAXIMO) {
            throw new Vehiculo.SuperadoPesoMaximoException("Se supera el peso máximo permitido.");
        }
        vehiculos.add(v);
        pesoTotal += pesoVehiculo;
    }

    public void resetear() {
        vehiculos.clear();
        pesoTotal = 0;
    }

    public void informe() {
        for (Vehiculo v : vehiculos) {
            System.out.println(v);
        }
        System.out.println("Peso total embarcado: " + pesoTotal + " kg");
    }
}
