package ud5.apuntesherencia.calendario;

public class Calendario {
    private int año;
    private int mes;
    private int dia;

    public Calendario(int año, int mes, int dia) {
        this.año = año;
        this.mes = mes;
        this.dia = dia;
    }

    public void incrementarDia() {
        dia++;
        if (dia > diasDelMes(mes, año)) {
            dia = 1;
            incrementarMes();
        }
    }

    public void incrementarMes() {
        mes++;
        if (mes > 12) {
            mes = 1;
            año++;
        }
    }

    private int diasDelMes(int mes, int año) {
        switch (mes) {
            case 4, 6, 9, 11:
                return 30;
            case 2:
                return esBisiesto(año) ? 29 : 28;
            default:
                return 31;
        }
    }

    private boolean esBisiesto(int año) {
        return (año % 4 == 0 && año % 100 != 0) || (año % 400 == 0);
    }

    @Override
    public String toString() {
        return String.format("%04d-%02d-%02d", año, mes, dia);
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Calendario)) return false;
        Calendario otro = (Calendario) obj;
        return this.año == otro.año && this.mes == otro.mes && this.dia == otro.dia;
    }
}
