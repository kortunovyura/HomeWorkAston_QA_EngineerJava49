package steps;

import io.qameta.allure.Step;
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

    public PaySectionSteps(WebDriver driver) {
        this.driver = driver;
        this.paymentPage = new MtsOnlinePaymentPage(driver);
    }

    private WebDriverWait getWait() {
        return new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    @Step("Открыть главную страницу и принять cookies")
    public PaySectionSteps openPageAndAcceptCookies() {
        paymentPage.open();
        paymentPage.acceptCookies();
        return this;
    }

    @Step("Проверить, что заголовок блока равен '{expectedTitle}'")
    public PaySectionSteps verifySectionTitle(String expectedTitle) {
        String actualTitle = paymentPage.getSectionTitleText();
        assertEquals(expectedTitle, actualTitle, "Название блока не соответствует ожидаемому");
        return this;
    }

    @Step("Проверить отображение логотипов платежных систем на главной странице")
    public PaySectionSteps verifyPaymentLogosAreDisplayed() {
        List<WebElement> logos = paymentPage.getPaymentLogos();
        assertFalse(logos.isEmpty(), "Логотипы платёжных систем не найдены");
        for (WebElement logo : logos) {
            assertTrue(logo.isDisplayed(), "Один из логотипов не отображается на главной");
        }
        return this;
    }

    @Step("Нажать на ссылку 'Подробнее о сервисе' и проверить переход на URL с '{expectedUrlPart}'")
    public PaySectionSteps verifyMoreDetailsLink(String expectedUrlPart) {
        String originalWindow = driver.getWindowHandle();
        paymentPage.clickMoreDetails();

        getWait().until(ExpectedConditions.numberOfWindowsToBe(2));
        Set<String> windowHandles = driver.getWindowHandles();

        for (String windowHandle : windowHandles) {
            if (!windowHandle.equals(originalWindow)) {
                driver.switchTo().window(windowHandle);
                break;
            }
        }
        assertTrue(driver.getCurrentUrl().contains(expectedUrlPart),
                "Ссылка ведет на некорректный URL: " + driver.getCurrentUrl());
        driver.close();
        driver.switchTo().window(originalWindow);
        return this;
    }

    @Step("Проверить плейсхолдеры для Услуг связи: '{phoneTxt}', '{sumTxt}', '{emailTxt}'")
    public PaySectionSteps checkPlaceholdersForConnectionServices(String phoneTxt, String sumTxt, String emailTxt) {
        paymentPage.selectConnectionServices();
        assertEquals(phoneTxt, paymentPage.getPlaceholder(paymentPage.getPhoneInput()));
        assertEquals(sumTxt, paymentPage.getPlaceholder(paymentPage.getSumInput()));
        assertEquals(emailTxt, paymentPage.getPlaceholder(paymentPage.getEmailInput()));
        return this;
    }

    @Step("Проверить плейсхолдеры для Домашнего интернета: '{phoneTxt}', '{sumTxt}'")
    public PaySectionSteps checkPlaceholdersForHomeInternet(String phoneTxt, String sumTxt) {
        paymentPage.selectHomeInternet();
        assertEquals(phoneTxt, paymentPage.getPlaceholder(paymentPage.getInternetPhoneInput()));
        assertEquals(sumTxt, paymentPage.getPlaceholder(paymentPage.getInternetSumInput()));
        return this;
    }

    @Step("Проверить плейсхолдеры для Рассрочки: '{accTxt}', '{sumTxt}'")
    public PaySectionSteps checkPlaceholdersForInstallment(String accTxt, String sumTxt) {
        paymentPage.selectInstallment();
        assertEquals(accTxt, paymentPage.getPlaceholder(paymentPage.getScoreInstalmentInput()));
        assertEquals(sumTxt, paymentPage.getPlaceholder(paymentPage.getInstalmentSumInput()));
        return this;
    }

    @Step("Проверить плейсхолдеры для Задолженности: '{accTxt}', '{sumTxt}'")
    public PaySectionSteps checkPlaceholdersForArrears(String accTxt, String sumTxt) {
        paymentPage.selectArrears();
        assertEquals(accTxt, paymentPage.getPlaceholder(paymentPage.getScoreArrearsInput()));
        assertEquals(sumTxt, paymentPage.getPlaceholder(paymentPage.getArrearsSumInput()));
        return this;
    }

    @Step("Заполнить форму Услуг связи номером {phone}, суммой {sum} и нажать 'Продолжить'")
    public PaySectionSteps fillAndSubmitConnectionServices(String phone, String sum) {
        paymentPage.selectConnectionServices();
        paymentPage.fillPhoneNumber(phone);
        paymentPage.fillSum(sum);
        paymentPage.clickContinue();
        return this;
    }

    @Step("Проверить корректность данных внутри открывшегося модального окна оплаты. Ожидаемая сумма: {expectedSum}, Телефон: {expectedPhone}")
    public PaySectionSteps verifyModalPaymentWindow(String expectedSum, String expectedPhone) {
        paymentPage.switchToPaymentModal();

        String totalSumText = paymentPage.getIframeTotalSumText();
        assertTrue(totalSumText.contains(expectedSum), "Сумма в описании модального окна не совпадает");

        String submitBtnText = paymentPage.getIframeSubmitBtnText();
        assertTrue(submitBtnText.contains(expectedSum), "Сумма на кнопке оплаты в модальном окне не совпадает");

        String phoneInfoText = paymentPage.getIframePhoneInfoText();
        assertTrue(phoneInfoText.contains(expectedPhone), "Номер телефона в модальном окне не совпадает");

        assertEquals("Номер карты", paymentPage.getIframeCardPlaceholder(paymentPage.getCardNumberInput()));
        assertEquals("Срок действия", paymentPage.getIframeCardPlaceholder(paymentPage.getCardExpiryInput()));
        assertEquals("CVC", paymentPage.getIframeCardPlaceholder(paymentPage.getCardCvcInput()));
        assertEquals("Имя держателя карты", paymentPage.getIframeCardPlaceholder(paymentPage.getCardHolderInput()));

        List<WebElement> cardLogos = paymentPage.getIframeCardLogos();
        assertFalse(cardLogos.isEmpty(), "Иконки платежных систем внутри модального окна не найдены");
        for (WebElement logo : cardLogos) {
            assertTrue(logo.isDisplayed(), "Одна из иконок платежных систем в модальном окне скрыта");
        }

        paymentPage.switchToDefaultContent();
        return this;
    }
}
