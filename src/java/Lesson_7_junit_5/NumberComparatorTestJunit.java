
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class NumberComparatorTestJunit {

    private final NumberComparator comparator = new NumberComparator();

    @Test
    void testFirstNumberIsGreater() {
        assertEquals(1, comparator.compare(10, 5));
    }

    @Test
    void testSecondNumberIsGreater() {
        assertEquals(-1, comparator.compare(3, 7));
    }

    @Test
    void testNumbersAreEqual() {
        assertEquals(0, comparator.compare(5, 5));
    }
}