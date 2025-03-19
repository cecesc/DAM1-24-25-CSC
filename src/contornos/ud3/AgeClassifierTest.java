package contornos.ud3;

import org.junit.Test;
import static org.junit.Assert.*;

public class AgeClassifierTest {

    @Test
    public void testClassifyInfantil_LowerBound() {
        assertEquals("Infantil", AgeClassifier.classify(0));
    }

    @Test
    public void testClassifyInfantil_UpperBound() {
        assertEquals("Infantil", AgeClassifier.classify(12));
    }

    @Test
    public void testClassifyAdolescente_LowerBound() {
        assertEquals("Adolescente", AgeClassifier.classify(13));
    }

    @Test
    public void testClassifyAdolescente_UpperBound() {
        assertEquals("Adolescente", AgeClassifier.classify(17));
    }

    @Test
    public void testClassifyAdulto_LowerBound() {
        assertEquals("Adulto", AgeClassifier.classify(18));
    }

    @Test
    public void testClassifyAdulto_UpperBound() {
        assertEquals("Adulto", AgeClassifier.classify(64));
    }

    @Test
    public void testClassifySenior_LowerBound() {
        assertEquals("Senior", AgeClassifier.classify(65));
    }

    @Test
    public void testClassifySenior_UpperBound() {
        assertEquals("Senior", AgeClassifier.classify(120));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testClassifyInvalidAge_Negative() {
        AgeClassifier.classify(-1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testClassifyInvalidAge_Excessive() {
        AgeClassifier.classify(121);
    }
}
