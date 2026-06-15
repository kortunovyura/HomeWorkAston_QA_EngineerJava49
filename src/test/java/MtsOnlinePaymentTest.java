package test;

import io.qameta.allure.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import steps.PaySectionSteps;

@Epic("Веб-портал МТС")
@Feature("Онлайн пополнение без комиссии")
public class MtsOnlinePaymentTest extends test.BaseTest {
    private PaySectionSteps steps;

    @BeforeEach
    public void initSteps() {
        steps = new PaySectionSteps(getDriver());
        steps.openPageAndAcceptCookies();
    }

    @Test
    @Severity(SeverityLevel.BLOCKER)
    @Story("Визуальные элементы главной страницы")
    @DisplayName("1. Проверка названия блока и наличия логотипов")
    @Description("Тест проверяет корректность отображения названия секции оплаты и наличие картинок-логотипов платёжных систем.")
    public void testSectionTitleAndLogos() {
        steps.verifySectionTitle("Онлайн пополнение\nбез комиссии")
                .verifyPaymentLogosAreDisplayed();
    }

    @Test
    @Severity(SeverityLevel.CRITICAL)
    @Story("Ссылки и навигация")
    @DisplayName("2. Проверка работы ссылки 'Подробнее о сервисе'")
    @Description("Тест кликает по ссылке и проверяет, что в новой вкладке открывается страница с правилами безопасности.")
    public void testMoreDetailsLink() {
        steps.verifyMoreDetailsLink("/help/poryadok-oplaty-i-bezopasnost/");
    }

    @Test
    @Severity(SeverityLevel.NORMAL)
    @Story("Валидация форм")
    @DisplayName("3. Проверка надписей в незаполненных полях (плейсхолдеров) для всех вариантов")
    @Description("Тест переключает вкладки способов оплаты и сверяет тексты-плейсхолдеры в пустых полях.")
    public void testPlaceholdersInAllTabs() {
        steps.checkPlaceholdersForConnectionServices("Номер телефона", "Сумма", "E-mail для отправки чека")
                .checkPlaceholdersForHomeInternet("Номер абонента", "Сумма")
                .checkPlaceholdersForInstallment("Номер счета на 44", "Сумма")
                .checkPlaceholdersForArrears("Номер счета на 207", "Сумма");
    }

    @Test
    @Severity(SeverityLevel.BLOCKER)
    @Story("Процесс оплаты")
    @DisplayName("4. Проверка ввода данных, открытия модального окна и валидация его содержимого")
    @Description("Тест заполняет форму 'Услуги связи', нажимает 'Продолжить', переключается в появившийся iframe и валидирует переданные данные, иконки карт и плейсхолдеры.")
    public void testConnectionServicesPaymentFlowInModal() {
        String testPhone = "297777777";
        String testSum = "10.00";

        steps.fillAndSubmitConnectionServices(testPhone, testSum)
                .verifyModalPaymentWindow(testSum, testPhone);
    }
}
