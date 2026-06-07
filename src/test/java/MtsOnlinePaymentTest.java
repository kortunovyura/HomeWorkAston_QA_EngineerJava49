import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

public class MtsOnlinePaymentTest extends BaseTest {

    private final WebDriver driver = Driver.getInstance();
    private final WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    @BeforeEach
    public void homePage() {
        driver.get("https://www.mts.by/");
        try {
            WebElement acceptCookies = wait.until(ExpectedConditions.elementToBeClickable(By.id("cookie-agree")));
            acceptCookies.click();
        } catch (Exception e) {
        }
    }

    @Test
    @DisplayName("Проверка элементов блока онлайн-платежей")
    public void checkPaymentSectionElements() {
        WebElement sectionTitle = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='pay__wrapper']/h2")));
        assertEquals("Онлайн пополнение\nбез комиссии", sectionTitle.getText().trim(), "Название блока не соответствует ожидаемому");

        List<WebElement> logos = driver.findElements(By.cssSelector(".pay__partners ul li img"));
        assertFalse(logos.isEmpty(), "Логотипы платёжных систем не найдены");

        for (WebElement logo : logos) {
            assertTrue(logo.isDisplayed(), "Один из логотипов не отображается");
        }
    }

    @Test
    @DisplayName("Проверка ссылки Подробнее о сервисе")
    public void checkMoreDetailsLink() {
        WebElement detailsLink = wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Подробнее о сервисе")));
        String originalWindow = driver.getWindowHandle();
        detailsLink.click();

        wait.until(ExpectedConditions.numberOfWindowsToBe(2));
        Set<String> windowHandles = driver.getWindowHandles();
        assertEquals(2, windowHandles.size(), "Новая вкладка не открылась");

        for (String windowHandle : windowHandles) {
            if (!windowHandle.equals(originalWindow)) {
                driver.switchTo().window(windowHandle);
                break;
            }
        }
        assertTrue(driver.getCurrentUrl().contains("/help/poryadok-oplaty-i-bezopasnost/"), "Ссылка Подробнее о сервисе ведет не на ту страницу");
    }

    @Test
    @DisplayName("Заполнение формы Услуг связи и отправка")
    public void fillConnectionServicesAndContinue() {
        WebElement selectDrop = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".pay__form .select__header")));
        selectDrop.click();

        WebElement connectionServiceOption = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//li[@class='select__item']/p[contains(text(), 'Услуги связи')]")));
        connectionServiceOption.click();

        WebElement phoneInput = driver.findElement(By.id("connection-phone"));
        phoneInput.sendKeys("297777777");

        WebElement sumInput = driver.findElement(By.id("connection-sum"));
        sumInput.sendKeys("10");

        WebElement continueButton = driver.findElement(By.xpath("//form[@id='pay-connection']//button[contains(text(), 'Продолжить')]"));
        continueButton.click();

        wait.until(ExpectedConditions.urlContains("asb.by"));
        assertTrue(driver.getCurrentUrl().contains("asb.by"), "Переход на страницу оплаты не осуществлен");
    }
}