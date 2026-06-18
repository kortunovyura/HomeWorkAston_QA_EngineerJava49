package test;

import driver.Driver;
import lombok.AccessLevel;
import lombok.Getter;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class BaseTest {
    @Getter(AccessLevel.PROTECTED)
    private static WebDriver driver;

    @BeforeAll
    public static void setUp() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        Driver.setOptions(options);
        driver = Driver.getInstance();
    }

    @AfterAll
    public static void tearDown() {
        Driver.quit();
    }
}
