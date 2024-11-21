//autor: Celia Sanmartín Chapela
package ud2.cscexamen;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.Test;

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

    @Test
    public void causaFinBombillaTest() {
        assertEquals("ERROR", causaFinBombilla(100, 100, 100));
        assertEquals("ERROR", causaFinBombilla(1000, -10, 10));
        assertEquals("ERROR", causaFinBombilla(0, 10, 10));
        assertEquals("ERROR", causaFinBombilla(1000, 10, 0));
        assertEquals("ENCENDIDOS", causaFinBombilla(500, 400, 1));
        assertEquals("HORAS", causaFinBombilla(1000, 10000, 1));
        assertEquals("HORAS", causaFinBombilla(1000, 200, 10));
        assertEquals("HORAS", causaFinBombilla(2000, 700, 3));
        assertEquals("ENCENDIDOS", causaFinBombilla(2000, 600, 3));
        assertEquals("ENCENDIDOS", causaFinBombilla(1000, 100, 1));
        assertEquals("ENCENDIDOS", causaFinBombilla(1000, 100, 9));
        assertEquals("ENCENDIDOS + HORAS", causaFinBombilla(1000, 100, 10));
    }

}
