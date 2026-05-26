import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class FactorialCalculatorTestJunit {

    private final FactorialCalculator calculator = new FactorialCalculator();

    @Test
    void testFactorialOfZero() {
        assertEquals(1, calculator.calculate(0));
    }

    @Test
    void testFactorialOfPositiveNumber() {
        assertEquals(120, calculator.calculate(5));
    }

    @Test
    void testFactorialExceptionForNegativeNumber() {
        assertThrows(IllegalArgumentException.class, () -> calculator.calculate(-1));
    }
}
