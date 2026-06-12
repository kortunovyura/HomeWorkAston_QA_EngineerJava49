package steps;

import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import page.MtsOnlinePaymentPage;

import java.time.Duration;

public class PaySectionSteps {
    private final WebDriver driver;
    private final MtsOnlinePaymentPage page;
    private final WebDriverWait wait;

    public PaySectionSteps(WebDriver driver) {
        this.driver = driver;
        this.page = new MtsOnlinePaymentPage(driver);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @Step("Проверить название блока")
    public PaySectionSteps verifyBlockTitle(String expectedTitle) {
        wait.until(ExpectedConditions.visibilityOf(page.getBlockTitle()));
        Assertions.assertEquals(expectedTitle, page.getBlockTitle().getText().trim());
        return this;
    }

    @Step("Проверить наличие логотипов платежных систем")
    public PaySectionSteps verifyPaymentLogosAreVisible() {
        Assertions.assertFalse(page.getPaymentLogos().isEmpty(), "Логотипы платежных систем не найдены");
        for (WebElement logo : page.getPaymentLogos()) {
            Assertions.assertTrue(logo.isDisplayed(), "Логотип скрыт на странице");
        }
        return this;
    }

    @Step("Нажать на ссылку 'Подробнее о сервисе'")
    public void clickMoreDetailsLink() {
        page.getDetailsLink().click();
    }

    @Step("Выбрать вариант оплаты: {tabName}")
    public PaySectionSteps selectPaymentTab(String tabName) {
        wait.until(ExpectedConditions.elementToBeClickable(page.getTab(tabName))).click();
        return this;
    }

    @Step("Проверить плейсхолдеры для варианта 'Услуги связи'")
    public PaySectionSteps verifyConnectionPlaceholders(String phoneHolder, String sumHolder) {
        Assertions.assertEquals(phoneHolder, page.getConnectionPhoneInput().getAttribute("placeholder"));
        Assertions.assertEquals(sumHolder, page.getConnectionSumInput().getAttribute("placeholder"));
        return this;
    }

    @Step("Проверить плейсхолдеры для варианта 'Домашний интернет'")
    public PaySectionSteps verifyInternetPlaceholders(String phoneHolder, String sumHolder) {
        Assertions.assertEquals(phoneHolder, page.getInternetPhoneInput().getAttribute("placeholder"));
        Assertions.assertEquals(sumHolder, page.getInternetSumInput().getAttribute("placeholder"));
        return this;
    }

    @Step("Проверить плейсхолдеры для варианта 'Рассрочка'")
    public PaySectionSteps verifyInstallmentPlaceholders(String scoreHolder, String sumHolder) {
        Assertions.assertEquals(scoreHolder, page.getInstallmentScoreInput().getAttribute("placeholder"));
        Assertions.assertEquals(sumHolder, page.getInstallmentSumInput().getAttribute("placeholder"));
        return this;
    }

    @Step("Проверить плейсхолдеры для варианта 'Задолженность'")
    public PaySectionSteps verifyArrearsPlaceholders(String scoreHolder, String sumHolder) {
        Assertions.assertEquals(scoreHolder, page.getArrearsScoreInput().getAttribute("placeholder"));
        Assertions.assertEquals(sumHolder, page.getArrearsSumInput().getAttribute("placeholder"));
        return this;
    }

    @Step("Заполнить поля 'Услуги связи' номером {phone} и суммой {sum}")
    public PaySectionSteps fillConnectionData(String phone, String sum) {
        page.getConnectionPhoneInput().sendKeys(phone);
        page.getConnectionSumInput().sendKeys(sum);
        return this;
    }

    @Step("Нажать кнопку 'Продолжить'")
    public PaySectionSteps clickContinue() {
        page.getContinueButton().click();
        return this;
    }

    @Step("Переключиться во фрейм оплаты")
    public PaySectionSteps switchToPaymentFrame() {
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(page.getPaymentIframe()));
        return this;
    }

    @Step("Проверить корректность суммы ({sum}) и номера ({phone}) в окне оплаты")
    public PaySectionSteps verifyWidgetPaymentDetails(String sum, String phone) {
        wait.until(ExpectedConditions.visibilityOf(page.getWidgetSumText()));
        Assertions.assertTrue(page.getWidgetSumText().getText().contains(sum));
        Assertions.assertTrue(page.getWidgetSubmitButton().getText().contains(sum));
        Assertions.assertTrue(page.getWidgetPhoneText().getText().contains(phone));
        return this;
    }

    @Step("Проверить надписи в незаполненных полях ввода реквизитов карты")
    public PaySectionSteps verifyWidgetCardPlaceholders() {
        Assertions.assertEquals("Номер карты", page.getCardNumberInput().getAttribute("placeholder"));
        Assertions.assertEquals("ММ/ГГ", page.getCardExpiryInput().getAttribute("placeholder"));
        Assertions.assertEquals("CVC", page.getCardCvvInput().getAttribute("placeholder"));
        Assertions.assertEquals("Имя держателя", page.getCardHolderInput().getAttribute("placeholder"));
        return this;
    }

    @Step("Проверить наличие иконок платежных систем в окне оплаты")
    public PaySectionSteps verifyWidgetLogosAreVisible() {
        Assertions.assertFalse(page.getWidgetPaymentLogos().isEmpty(), "Иконки платёжных систем в виджете отсутствуют");
        return this;
    }
}