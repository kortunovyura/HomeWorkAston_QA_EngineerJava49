import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import page.MtsOnlinePaymentPage;

import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

public class MtsOnlinePaymentTest extends BaseTest {
    private MtsOnlinePaymentPage paymentPage;

    @BeforeEach
    public void initPage() {
        paymentPage = new MtsOnlinePaymentPage(driver);
        paymentPage.open();
        paymentPage.acceptCookies();
    }

    @Test
    @DisplayName("Проверка элементов блока онлайн-платежей")
    public void checkPaymentSectionElements() {
        String titleText = paymentPage.getSectionTitleText();
        assertEquals("Онлайн пополнение\nбез комиссии", titleText, "Название блока не соответствует ожидаемому");
        List<WebElement> logos = paymentPage.getPaymentLogos();
        assertFalse(logos.isEmpty(), "Логотипы платёжных систем не найдены");
        for (WebElement logo : logos) {
            assertTrue(logo.isDisplayed(), "Один из логотипов не отображается");
        }
    }

    @Test
    @DisplayName("Проверка ссылки Подробнее о сервисе")
    public void checkMoreDetailsLink() {
        String originalWindow = driver.getWindowHandle();
        paymentPage.clickMoreDetails();
        wait.until(ExpectedConditions.numberOfWindowsToBe(2));
        Set<String> windowHandles = driver.getWindowHandles();
        assertEquals(2, windowHandles.size(), "Новая вкладка не открылась");
        for (String windowHandle : windowHandles) {
            if (!windowHandle.equals(originalWindow)) {
                driver.switchTo().window(windowHandle);
                break;
            }
        }

        assertTrue(driver.getCurrentUrl().contains("/help/poryadok-oplaty-i-bezopasnost/"),
                "Ссылка Подробнее о сервисе ведет не на ту страницу");
    }

    @Test
    @DisplayName("Заполнение формы Услуг связи и отправка")
    public void fillConnectionServicesAndContinue() {
        paymentPage.selectConnectionServices();
        paymentPage.fillPhoneNumber("297777777");
        paymentPage.fillSum("10");
        paymentPage.clickContinue();

        WebElement modal = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class, 'modal')]")));
        assertTrue(modal.isDisplayed(), "Модальное окно с деталями платежа не отобразилось");
        
        wait.until(ExpectedConditions.urlContains("asb.by"));
        assertTrue(driver.getCurrentUrl().contains("asb.by"), "Переход на страницу оплаты не осуществлен");
    }
}
