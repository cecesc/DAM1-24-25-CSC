//Autor: Celia Sanmartín Chapela
package contornos.ud3.cscexamen;

import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

public class EmailValidatorTest {
    @Test
    void testIsValid() {
        assertFalse(EmailValidator.isValid(" "));
    }

    @Test
    void testIsValidSoloArroba() {
        assertFalse(EmailValidator.isValid("@"));
    }

    @Test
    void testSinArroba() {
        assertFalse(EmailValidator.isValid("javierinstituto.com"));
    }

    @Test
    void testValid() {
        assertTrue(EmailValidator.isValid("javier@instituto.com"));
    }

    @Test
    void testSinPunto() {
        assertFalse(EmailValidator.isValid("javier@institutocom"));
    }

    @Test
    void testSinNadaTrasArroba() {
        assertFalse(EmailValidator.isValid("javier@"));
    }

    @Test
    void testSinNadaAntesArroba() {
        assertFalse(EmailValidator.isValid("@instituto.com"));
    }
}
