package driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import lombok.experimental.UtilityClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

@UtilityClass
public class Driver {
    private WebDriver driver;
    private ChromeOptions chromeOptions;

    public void setOptions(ChromeOptions options) {
        chromeOptions = options;
    }

    public WebDriver getInstance() {
        if (driver == null) {
            if (chromeOptions == null) {
                WebDriverManager.chromedriver().setup();
                chromeOptions = new ChromeOptions();
                chromeOptions.addArguments("--start-maximized");
            }
            driver = new ChromeDriver(chromeOptions);
        }
        return driver;
    }

    public void quit() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
