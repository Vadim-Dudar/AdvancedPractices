import edu.naukma.theme4.Calculator;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;


public class ClaculatorTest {
    Calculator calculator;
    @BeforeEach
    public void setup() {
        calculator = new Calculator();
    }

    @Test
    public void testDivide_ValidInput() {
        assertEquals(2, calculator.divide(12, 6));
        assertEquals(-3, calculator.divide(6, -2));
    }

    @Test
    public void testDivide_DivisionByZero() {
        assertThrows(IllegalArgumentException.class, () -> calculator.divide(6, 0));
    }
}
