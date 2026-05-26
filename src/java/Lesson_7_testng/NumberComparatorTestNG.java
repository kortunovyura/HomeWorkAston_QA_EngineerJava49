import org.testng.Assert;
import org.testng.annotations.Test;

public class NumberComparatorTestNG {
    private final NumberComparator comparator = new NumberComparator();

    @Test
    public void testFirstGreaterThanSecond() {
        Assert.assertEquals(comparator.compare(10, 5), 1);
    }

    @Test
    public void testFirstLessThanSecond() {
        Assert.assertEquals(comparator.compare(3, 7), -1);
    }

    @Test
    public void testNumbersAreEqual() {
        Assert.assertEquals(comparator.compare(5, 5), 0);
    }
}