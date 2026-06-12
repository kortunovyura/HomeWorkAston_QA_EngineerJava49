import driver.Driver;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;

public class BaseTest {
    protected WebDriver driver;

    @BeforeEach
    public void setUp() {
        driver = Driver.initDriver();
        driver.get("https://www.mts.by/");
    }

    @AfterEach
    public void tearDown() {
        Driver.closeDriver();
    }
}