//autor: Celia Sanmartín Chapela
package ud2.cscexamen;

public class DuracionBombillas {

    public static String causaFinBombilla(int maxHoras, int maxEncendidos, int maxHorasEncendida) {
        String causaMuerte = "";
        int horas = 0, encendidos = 0;

        if (horas == maxHoras) {
            System.out.println("La causa de la muerte de la bombilla fueron HORAS");
            if (encendidos == maxEncendidos) {
                System.out.println("La causa de la muerte de la bombilla fue los ENCENDIDOS");
                if (horas == maxHoras && encendidos == maxEncendidos) {
                    System.out.println("La causa de la muerte de la bombilla fue las HORAS + ENCENDIDOS");
                }
            }
        }
        return causaMuerte;
    }

    public static void main(String[] args) {
        int maxHoras = 0, maxEncendidos = 0, maxHorasEncendida = 0;
        System.out.println(causaFinBombilla(maxHoras, maxEncendidos, maxHorasEncendida));

    }

}
