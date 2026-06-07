import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ArithmeticOperationsTestJunit {

    private final ArithmeticOperations math = new ArithmeticOperations();

    @Test
    public void testAddition() {
        assertEquals(5, math.add(2, 3));
    }

    @Test
    public void testSubtraction() {
        assertEquals(2, math.subtract(5, 3));
    }

    @Test
    public void testMultiplication() {
        assertEquals(15, math.multiply(3, 5));
    }

    @Test
    public void testDivision() {
        assertEquals(2.5, math.divide(5, 2));
    }

    @Test
    public void testDivisionByZero() {
        assertThrows(ArithmeticException.class, () -> math.divide(5, 0));
    }
}
