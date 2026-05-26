import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ArithmeticOperationsTestJunit {

    private final ArithmeticOperations math = new ArithmeticOperations();

    @Test
    void testAddition() {
        assertEquals(5, math.add(2, 3));
    }

    @Test
    void testSubtraction() {
        assertEquals(2, math.subtract(5, 3));
    }

    @Test
    void testMultiplication() {
        assertEquals(15, math.multiply(3, 5));
    }

    @Test
    void testDivision() {
        assertEquals(2.5, math.divide(5, 2));
    }

    @Test
    void testDivisionByZero() {
        assertThrows(ArithmeticException.class, () -> math.divide(5, 0));
    }
}