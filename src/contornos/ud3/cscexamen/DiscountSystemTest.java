package contornos.ud3.cscexamen;
//Autor: Celia Sanmartín Chapela

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

public class DiscountSystemTest {
        @Test
    void testDiscountNegativeNumber() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            DiscountSystem.applyDiscount(-1, false);
        });
        assertEquals("O importe non pode ser negativo", exception.getMessage());
    }
    //*descuento/100

    @Test
    void testNotDiscount() {
        assertEquals(20.0, DiscountSystem.applyDiscount(20, false));
    }

    @Test
    void testApplyDiscount05() {
        assertEquals(47.5, DiscountSystem.applyDiscount(50, false));
    }

    @Test
    void testApplyDiscount052() {
        assertEquals(66.5, DiscountSystem.applyDiscount(70, false));
    }

    @Test
    void testApplyDiscount10() {
        assertEquals(90, DiscountSystem.applyDiscount(100, false));
    }

    @Test
    void testApplyDiscount102() {
        assertEquals(108.0, DiscountSystem.applyDiscount(120, false));
    }
@Test
    void testOnlyIsCustomer() {
        assertEquals(30.0, DiscountSystem.applyDiscount(30, true));
    }

    @Test
    void testIsCustomerAnd200() {
        assertEquals(170.0, DiscountSystem.applyDiscount(200, true));
    }


}
