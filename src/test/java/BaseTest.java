package test;

import driver.Driver;
import io.qameta.allure.Attachment;
import lombok.AccessLevel;
import lombok.Getter;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.RegisterExtension;
import org.junit.jupiter.api.extension.TestWatcher;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.Optional;

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

    @RegisterExtension
    TestWatcher watcher = new TestWatcher() {
        @Override
        public void testFailed(ExtensionContext context, Throwable cause) {
            if (driver != null) {
                saveScreenshot(context.getDisplayName() + "_failed");
            }
        }
    };

    @Attachment(value = "Скриншот падения {screenshotName}", type = "image/png")
    public byte[] saveScreenshot(String screenshotName) {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }
}
