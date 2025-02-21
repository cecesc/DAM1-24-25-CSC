package ud5.apuntesherencia.E0801;

public class Hora {
    byte hora;
    byte minuto;

    public Hora(byte hora, byte minuto) {
        if(!setHora(hora)){
            throw new IllegalArgumentException("El minuto debe de estar entre 0 y 23");
        }
        if(!setMinuto(minuto)){
            throw new IllegalArgumentException("El minuto debe de estar entre 0 y 59");
        }
    }

    void dec(){
        
    }

    void inc() {
        minuto++;
        if (minuto == 60) {
            minuto = 0;
            hora++;
            if (hora == 24) {
                hora = 0;
            }
        }
    }

    boolean setMinuto(byte valor) {
        if (valor >= 0 && valor < 60) {
            minuto = (byte)valor;
            return true;
        } else
            return false;
    }

    boolean setHora(byte valor) {
        if (valor >= 0 && valor < 24) {
            hora = (byte)valor;
            return true;
        } else
            return false;
    }

    @Override
    public String toString() {
        return String.format("%02d:%02d", hora, minuto);
    }

    public static void main(String[] args) {
        Hora hora = new Hora(8, 03);
        System.out.println(hora);
        hora.inc();
    }

}
