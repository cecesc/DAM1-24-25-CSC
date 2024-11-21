package ud2.cscexamen;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.Test;

public class DuracionBombillas {

    public static String causaFinBombilla(int maxHoras, int maxEncendidos, int maxHorasEncendida) {
        // Validar los parámetros de entrada
        if (maxHoras <= 0 || maxEncendidos <= 0 || maxHorasEncendida <= 0 || maxHorasEncendida > 10) {
            return "ERROR";
        }

        // Calcular el tiempo total que la bombilla puede funcionar
        int horasPorEncendido = maxHorasEncendida;
        int totalHorasEncendida = maxEncendidos * horasPorEncendido;

        // Determinar la causa de la muerte de la bombilla
        boolean horasLimiteAlcanzado = totalHorasEncendida >= maxHoras;
        boolean encendidosLimiteAlcanzado = maxEncendidos <= (maxHoras / horasPorEncendido);

        if (horasLimiteAlcanzado && encendidosLimiteAlcanzado) {
            return "ENCENDIDOS + HORAS";
        } else if (horasLimiteAlcanzado) {
            return "HORAS";
        } else if (encendidosLimiteAlcanzado) {
            return "ENCENDIDOS";
        }

        return "Ninguna causa"; // Esto no debería ocurrir con los parámetros válidos
    }

    public static void main(String[] args) {
        // Ejemplo de uso
        int maxHoras = 1000, maxEncendidos = 100, maxHorasEncendida = 10;
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