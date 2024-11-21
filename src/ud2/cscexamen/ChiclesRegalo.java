//Autor: Celia Sanmartín Chapela
package ud2.cscexamen;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.Test;

public class ChiclesRegalo {
    public static int totalChicles(int chiclesComprados, int envoltoriosReunir, int totalChiclesGratis) {

        do {
            if (chiclesComprados < 0 || envoltoriosReunir < 0 || totalChiclesGratis < 0) {
                System.out.println("Error. Numero inválido");
            }
        } while (chiclesComprados < 0 || envoltoriosReunir < 0 || totalChiclesGratis < 0);

        while (chiclesComprados == 5 || chiclesComprados % 5 == 0) {
            totalChiclesGratis++;
        }

        return totalChiclesGratis;
    }

    public static void main(String[] args) {
        System.out.println(totalChicles(0, 0, 0));
    }

    @Test
    public void ChiclesRegaloTest() {
        assertEquals(31, totalChicles(25, 5, 1));
        assertEquals(6, totalChicles(5, 5, 1));
        assertEquals(111, totalChicles(100, 10, 1));
        assertEquals(100, totalChicles(100, 0, 0));
        assertEquals(-1, totalChicles(20, 2, 5));
        assertEquals(-1, totalChicles(10, -1, 0));

    }
}
