package contornos.ud3;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

import org.junit.jupiter.api.Test;

public class NumberUtilsTest {
   @Test
    void testNumeroPrimo() {
        assertTrue(NumberUtils.isPrime(7));
    }

    @Test
    void testNumeroNoPrimo() {
        assertFalse(NumberUtils.isPrime(8));
    }

    @Test
    void testNumeroNegativo() {
        assertFalse(NumberUtils.isPrime(-3));
    }

    @Test
    void testNumeroCero() {
        assertFalse(NumberUtils.isPrime(0));
    }

    @Test
    void testNumeroUno() {
        assertFalse(NumberUtils.isPrime(1));
    }

    @Test
    void testPrimoPequeño() {
        assertTrue(NumberUtils.isPrime(2));
    }

    @Test
    void testPrimoGrande() {
        assertTrue(NumberUtils.isPrime(97));
    }

    @Test
    void testNoPrimoGrande() {
        assertFalse(NumberUtils.isPrime(100));
    }

}
