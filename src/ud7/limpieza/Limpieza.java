package ud7.limpieza;

import java.io.Serializable;
import java.time.LocalDate;

public class Limpieza implements Serializable {
    private LocalDate fecha;
    private String equipo;
    private String playa;
    private double kilos;

    public Limpieza(LocalDate fecha, String equipo, String playa, double kilos) {
        this.fecha = fecha;
        this.equipo = equipo;
        this.playa = playa;
        this.kilos = kilos;
    }

    public LocalDate getFecha() { return fecha; }
    public String getEquipo() { return equipo; }
    public String getPlaya() { return playa; }
    public double getKilos() { return kilos; }

    @Override
    public String toString() {
        return fecha + " | " + equipo + " | " + playa + " | " + kilos + " kg";
    }
}
