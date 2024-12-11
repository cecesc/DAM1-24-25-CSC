package ud3.ejerciciostime;

import java.time.Duration;
import java.time.LocalTime;

public class DuracionActividad {
    public static void main(String[] args) {
        LocalTime inicio = LocalTime.of(10, 30, 0);
        System.out.println("Inicio de la actividad: " + inicio);

        LocalTime fin = LocalTime.of(12, 45, 10);
        System.out.println("Fin de la actividad: " + fin);

        Duration duracion = Duration.between(inicio, fin);
        System.out.println("Duración de la actividad: " + duracion.toHours() + " horas, "
                + duracion.toMinutesPart() + " minutos, " + duracion.toSecondsPart() + " segundos");
    }
}
