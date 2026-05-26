import org.testng.Assert;
import org.testng.annotations.Test;

public class TriangleAreaCalculatorTestNG {
    private final TriangleAreaCalculator calculator = new TriangleAreaCalculator();

    @Test
    public void testValidTriangle() {
        double area = calculator.calculate(3, 4, 5);
        Assert.assertEquals(area, 6.0, 0.001);
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testInvalidTriangle() {
        calculator.calculate(1, 2, 10);
    }
}