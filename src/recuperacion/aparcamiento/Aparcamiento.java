package recuperacion.aparcamiento;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Aparcamiento {
    private int capacidadMaxima;
    private Vehiculo[] plazas;
    private double alturaMaxima;

    public Aparcamiento() {
        this(100);
    }

    public Aparcamiento(int capacidadMaxima) {
        this.capacidadMaxima = capacidadMaxima;
        this.plazas = new Vehiculo[capacidadMaxima];
        this.alturaMaxima = 4.0;
    }

    public int getCapacidadMaxima() {
        return capacidadMaxima;
    }

    public boolean aparcarVehiculo(Vehiculo vehiculo) {
        if (vehiculo == null || consultarPlazaVehiculo(vehiculo) != -1)
            return false;

        if (vehiculo instanceof VehiculoPesado pesado &&
            pesado.getAltura() > alturaMaxima)
            return false;

        for (int i = 0; i < plazas.length; i++) {
            if (plazas[i] == null) {
                plazas[i] = vehiculo;
                return true;
            }
        }
        return false;
    }

    public boolean sacarVehiculo(Vehiculo vehiculo) {
        for (int i = 0; i < plazas.length; i++) {
            if (vehiculo.equals(plazas[i])) {
                plazas[i] = null;
                return true;
            }
        }
        return false;
    }

    public int numPlazasLibres() {
        int libres = 0;
        for (Vehiculo v : plazas)
            if (v == null) libres++;
        return libres;
    }

    public void mostrarEstado() {
        for (int i = 0; i < plazas.length; i++) {
            System.out.println("Plaza " + i + ": " +
                (plazas[i] == null ? "Libre" : "Ocupada"));
        }
    }

    public void mostrarEstadoDetallado() {
        for (int i = 0; i < plazas.length; i++) {
            if (plazas[i] != null) {
                System.out.printf("Plaza %d - %s%n", i, plazas[i]);
            }
        }
    }

    public Vehiculo consultarPlaza(int numeroPlaza) {
        if (numeroPlaza >= 0 && numeroPlaza < capacidadMaxima)
            return plazas[numeroPlaza];
        return null;
    }

    public int consultarPlazaVehiculo(Vehiculo vehiculo) {
        for (int i = 0; i < plazas.length; i++) {
            if (vehiculo.equals(plazas[i]))
                return i;
        }
        return -1;
    }

    public int[] plazasLibres() {
        return filtrarPlazas(true);
    }

    public int[] plazasOcupadas() {
        return filtrarPlazas(false);
    }

    private int[] filtrarPlazas(boolean libres) {
        List<Integer> lista = new ArrayList<>();
        for (int i = 0; i < plazas.length; i++) {
            if ((libres && plazas[i] == null) || (!libres && plazas[i] != null)) {
                lista.add(i);
            }
        }
        return lista.stream().mapToInt(i -> i).toArray();
    }

    public int numPlazasOcupadas() {
        return capacidadMaxima - numPlazasLibres();
    }

    public boolean aparcarGrupoVehiculos(List<Vehiculo> vehiculos) {
        if (vehiculos == null || vehiculos.isEmpty())
            return false;

        for (Vehiculo v : vehiculos)
            if (consultarPlazaVehiculo(v) != -1 || (v instanceof VehiculoPesado vp && vp.getAltura() > alturaMaxima))
                return false;

        if (numPlazasLibres() < vehiculos.size())
            return false;

        for (Vehiculo v : vehiculos)
            aparcarVehiculo(v);

        return true;
    }

    public boolean sacarGrupoVehiculos(List<Vehiculo> vehiculos) {
        boolean todos = true;
        for (Vehiculo v : vehiculos) {
            boolean sacado = sacarVehiculo(v);
            if (!sacado) todos = false;
        }
        return todos;
    }

    public List<Vehiculo> vehiculosAparcados() {
        List<Vehiculo> lista = new ArrayList<>();
        for (Vehiculo v : plazas) {
            if (v != null)
                lista.add(v);
        }
        if (lista.isEmpty()) return null;
        Collections.sort(lista);
        return lista;
    }

    public Map<Integer, Vehiculo> plazasVehiculos() {
        Map<Integer, Vehiculo> mapa = new TreeMap<>();
        for (int i = 0; i < plazas.length; i++) {
            if (plazas[i] != null)
                mapa.put(i, plazas[i]);
        }
        return mapa.isEmpty() ? null : mapa;
    }

    public Map<Vehiculo, Integer> vehiculosPlazas() {
        Map<Vehiculo, Integer> mapa = new TreeMap<>();
        for (int i = 0; i < plazas.length; i++) {
            if (plazas[i] != null)
                mapa.put(plazas[i], i);
        }
        return mapa.isEmpty() ? null : mapa;
    }

    public double getAlturaMaxima() {
        return alturaMaxima;
    }

    public void setAlturaMaxima(double alturaMaxima) {
        this.alturaMaxima = alturaMaxima;
    }
}

