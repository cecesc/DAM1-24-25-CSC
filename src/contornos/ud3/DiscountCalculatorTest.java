package contornos.ud3;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.Test;

public class DiscountCalculatorTest {
      @Test
    void testDescuentoValido() {
        assertEquals(90.0, DiscountCalculator.applyDiscount(100, 10));
    }

    @Test
    void testDescuentoCero() {
        assertEquals(50.0, DiscountCalculator.applyDiscount(50, 0));
    }

    @Test
    void testDescuentoTotal() {
        assertEquals(0.0, DiscountCalculator.applyDiscount(50, 100));
    }

    @Test
    void testDescuentoNegativo() {
        assertThrows(IllegalArgumentException.class, () -> DiscountCalculator.applyDiscount(50, -10));
    }

    @Test
    void testDescuentoMayorCien() {
        assertThrows(IllegalArgumentException.class, () -> DiscountCalculator.applyDiscount(50, 110));
    }

    @Test
    void testPrecioCero() {
        assertEquals(0.0, DiscountCalculator.applyDiscount(0, 50));
    }
}
