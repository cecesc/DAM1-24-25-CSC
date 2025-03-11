package contornos.ud3;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class MathUtilsTest {

    @Test
    void testFactorialPositiveNumbers() {
        assertEquals(1, MathUtils.factorial(0)); 
        assertEquals(1, MathUtils.factorial(1));
        assertEquals(2, MathUtils.factorial(2));
        assertEquals(6, MathUtils.factorial(3));
        assertEquals(24, MathUtils.factorial(4));
        assertEquals(120, MathUtils.factorial(5));
    }

    @Test
    void testFactorialNegativeNumber() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            MathUtils.factorial(-1);
        });
        assertEquals("O número debe ser positivo", exception.getMessage());
    }
}




