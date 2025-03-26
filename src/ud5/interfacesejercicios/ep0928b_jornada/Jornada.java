package ud5.interfacesejercicios.ep0928b_jornada;

import java.time.LocalDateTime;
import java.util.Date;

public class Jornada implements Comparable<Jornada> {
String dni;
Date fecha;
int horaEntrada;
int horaSalida;



public Jornada(String dni, Date fecha, int horaEntrada, int horaSalida) {
    this.dni = dni;
    this.fecha = fecha;
    this.horaEntrada = horaEntrada;
    this.horaSalida = horaSalida;
}

public int getMinutosTrabajados() {
    return (horaSalida - horaEntrada) * 60;
}

@Override
public String toString() {
    return dni + " - " + fecha + " - " + getMinutosTrabajados() + " minutos";
}

@Override
public int compareTo(Jornada otra) {
    int cmp = this.dni.compareTo(otra.dni);
    return cmp != 0 ? cmp : this.fecha.compareTo(otra.fecha);
}
}
