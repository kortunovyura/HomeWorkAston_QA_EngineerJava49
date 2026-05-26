import org.testng.Assert;
import org.testng.annotations.Test;

public class FactorialCalculatorTestNG {
    private final FactorialCalculator calculator = new FactorialCalculator();

    @Test
    public void testFactorialOfZero() {
        Assert.assertEquals(calculator.calculate(0), 1L);
    }

    @Test
    public void testFactorialOfPositiveNumber() {
        Assert.assertEquals(calculator.calculate(5), 120L);
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testFactorialOfNegativeNumber() {
        calculator.calculate(-5);
    }
}