package test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import steps.PaySectionSteps;

public class MtsOnlinePaymentTest extends BaseTest {
    private PaySectionSteps steps;

    @BeforeEach
    public void initSteps() {
        steps = new PaySectionSteps(getDriver());
        steps.openPageAndAcceptCookies();
    }

    @Test
    @DisplayName("1. Проверка названия блока и наличия логотипов")
    public void testSectionTitleAndLogos() {
        steps.verifySectionTitle("Онлайн пополнение\nбез комиссии")
             .verifyPaymentLogosAreDisplayed();
    }

    @Test
    @DisplayName("2. Проверка работы ссылки 'Подробнее о сервисе'")
    public void testMoreDetailsLink() {
        steps.verifyMoreDetailsLink("/help/poryadok-oplaty-i-bezopasnost/");
    }

    @Test
    @DisplayName("3. Проверка надписей в незаполненных полях (плейсхолдеров) для всех вариантов")
    public void testPlaceholdersInAllTabs() {
        steps.checkPlaceholdersForConnectionServices("Номер телефона", "Сумма", "E-mail для отправки чека")
             .checkPlaceholdersForHomeInternet("Номер абонента", "Сумма")
             .checkPlaceholdersForInstallment("Номер счета на 44", "Сумма")
             .checkPlaceholdersForArrears("Номер счета на 207", "Сумма");
    }

    @Test
    @DisplayName("4. Проверка ввода данных, открытия модального окна и валидация его содержимого")
    public void testConnectionServicesPaymentFlowInModal() {
        String testPhone = "297777777";
        String testSum = "10.00";

        steps.fillAndSubmitConnectionServices(testPhone, testSum)
             .verifyModalPaymentWindow(testSum, testPhone);
    }
}
