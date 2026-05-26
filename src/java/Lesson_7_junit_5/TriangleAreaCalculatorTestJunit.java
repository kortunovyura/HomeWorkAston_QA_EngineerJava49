import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class TriangleAreaCalculatorTestJunit {

    private final TriangleAreaCalculator calculator = new TriangleAreaCalculator();

    @Test
    void testValidTriangleArea() {
        assertEquals(6.0, calculator.calculate(3, 4, 5), 0.001);
    }

    @Test
    void testInvalidTriangleSides() {
        assertThrows(IllegalArgumentException.class, () -> calculator.calculate(1, 2, 10));
    }
}