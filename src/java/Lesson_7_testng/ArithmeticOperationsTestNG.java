import org.testng.Assert;
import org.testng.annotations.Test;

public class ArithmeticOperationsTestNG {
    private final ArithmeticOperations operations = new ArithmeticOperations();

    @Test
    public void testAdd() {
        Assert.assertEquals(operations.add(5, 3), 8);
    }

    @Test
    public void testSubtract() {
        Assert.assertEquals(operations.subtract(10, 4), 6);
    }

    @Test
    public void testMultiply() {
        Assert.assertEquals(operations.multiply(3, 7), 21);
    }

    @Test
    public void testDivide() {
        Assert.assertEquals(operations.divide(10, 2), 5.0, 0.001);
    }

    @Test(expectedExceptions = ArithmeticException.class)
    public void testDivideByZero() {
        operations.divide(5, 0);
    }
}