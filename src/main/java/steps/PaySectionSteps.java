package steps;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import page.MtsOnlinePaymentPage;

import java.time.Duration;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

public class PaySectionSteps {
    private final WebDriver driver;
    private final MtsOnlinePaymentPage paymentPage;
    private final WebDriverWait wait;

    public PaySectionSteps(WebDriver driver) {
        this.driver = driver;
        this.paymentPage = new MtsOnlinePaymentPage(driver);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public PaySectionSteps openPageAndAcceptCookies() {
        paymentPage.open();
        paymentPage.acceptCookies();
        return this;
    }

    public PaySectionSteps verifySectionTitle(String expectedTitle) {
        String actualTitle = paymentPage.getSectionTitleText();
        assertEquals(expectedTitle, actualTitle, "Название блока не соответствует ожидаемому");
        return this;
    }

    public PaySectionSteps verifyPaymentLogosAreDisplayed() {
        List<WebElement> logos = paymentPage.getPaymentLogos();
        assertFalse(logos.isEmpty(), "Логотипы платёжных систем не найдены");
        for (WebElement logo : logos) {
            assertTrue(logo.isDisplayed(), "Один из логотипов не отображается");
        }
        return this;
    }

    public PaySectionSteps clickMoreDetailsLink() {
        paymentPage.clickMoreDetails();
        return this;
    }

    public PaySectionSteps verifyNewWindowOpenedWithUrl(String expectedUrlPart) {
        String originalWindow = driver.getWindowHandle();
        wait.until(ExpectedConditions.numberOfWindowsToBe(2));
        Set<String> windowHandles = driver.getWindowHandles();
        assertEquals(2, windowHandles.size(), "Новая вкладка не открылась");

        for (String windowHandle : windowHandles) {
            if (!windowHandle.equals(originalWindow)) {
                driver.switchTo().window(windowHandle);
                break;
            }
        }
        assertTrue(driver.getCurrentUrl().contains(expectedUrlPart),
                "Ссылка 'Подробнее о сервисе' ведет на некорректную страницу: " + driver.getCurrentUrl());
        return this;
    }

    public PaySectionSteps fillConnectionServicesForm(String phone, String sum) {
        paymentPage.selectConnectionServices();
        paymentPage.fillPhoneNumber(phone);
        paymentPage.fillSum(sum);
        return this;
    }

    public PaySectionSteps clickContinueAndVerifyRedirect(String expectedRedirectUrlPart) {
        paymentPage.clickContinue();
        wait.until(ExpectedConditions.urlContains(expectedRedirectUrlPart));
        assertTrue(driver.getCurrentUrl().contains(expectedRedirectUrlPart),
                "Переход на ожидаемую страницу оплаты не осуществлен");
        return this;
    }
}