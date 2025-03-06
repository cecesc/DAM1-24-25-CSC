package ud5.apuntesherencia.calendario;

public class CalendarioExacto extends Calendario {
    private int hora;
    private int minuto;

    public CalendarioExacto(int año, int mes, int dia, int hora, int minuto) {
        super(año, mes, dia);
        this.hora = hora;
        this.minuto = minuto;
    }

    public void incrementarMinuto() {
        minuto++;
        if (minuto >= 60) {
            minuto = 0;
            incrementarHora();
        }
    }

    public void incrementarHora() {
        hora++;
        if (hora >= 24) {
            hora = 0;
            incrementarDia();  // Este método viene heredado de Calendario
        }
    }

    @Override
    public String toString() {
        return super.toString() + String.format(" %02d:%02d", hora, minuto);
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof CalendarioExacto)) return false;
        CalendarioExacto otro = (CalendarioExacto) obj;
        return super.equals(otro) && this.hora == otro.hora && this.minuto == otro.minuto;
    }
}
