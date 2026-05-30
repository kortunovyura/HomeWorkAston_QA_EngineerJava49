import lombok.Setter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.Objects;

public class Driver {
    private final static ThreadLocal<WebDriver> driver = new ThreadLocal<>();
    @Setter 
    private static ChromeOptions options;

    public static WebDriver getInstance() {
        if (Objects.isNull(driver.get())) {
            if (options != null) {
                driver.set(new ChromeDriver(options));
            } else {
                driver.set(new ChromeDriver());
            }
        }
        return driver.get();
    }
    
    public static void quit() {
        if (Objects.nonNull(driver.get())) {
            driver.get().quit();
            driver.remove();
        }
    }
}