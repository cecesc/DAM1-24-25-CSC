package ud3.ejerciciostime;

import java.time.LocalDate;
import java.time.Period;

public class IntervaloFechas {
    public static void main(String[] args) {
        LocalDate inicio = LocalDate.of(2024, 9, 17);
        System.out.println("Inicio de la actividad: " + inicio);

        LocalDate fin = LocalDate.of(2026, 6, 25);
        System.out.println("Fin de la actividad: " + fin);

        Period duracion = Period.between(inicio, fin);
        System.out.println("Duración de la actividad: " + duracion.getYears() + " años, "
                + duracion.getMonths() + " meses, " + duracion.getDays() + " días");
    }
}
