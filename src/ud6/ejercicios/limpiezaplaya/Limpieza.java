package ud6.ejercicios.limpiezaplaya;


    import java.io.Serializable;
import java.time.LocalDate;

public class Limpieza implements Serializable {
    private LocalDate data;
    private String equipo;
    private String praia;
    private int kilos;

    public Limpieza(LocalDate data, String equipo, String praia, int kilos) {
        this.data = data;
        this.equipo = equipo;
        this.praia = praia;
        this.kilos = kilos;
    }

    public LocalDate getData() {
        return data;
    }

    public String getEquipo() {
        return equipo;
    }

    public String getPraia() {
        return praia;
    }

    public int getKilos() {
        return kilos;
    }

    @Override
    public String toString() {
        return data + " - " + equipo + " - " + praia + " - " + kilos + "kg";
    }
}

