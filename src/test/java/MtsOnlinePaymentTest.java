import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import steps.PaySectionSteps;

@Feature("Тестирование блока онлайн пополнения")
public class MtsOnlinePaymentTest extends BaseTest {
    private PaySectionSteps steps;

    @BeforeEach
    public void initSteps() {
        steps = new PaySectionSteps(driver);
    }

    @Test
    @Story("Проверка UI элементов")
    @DisplayName("Проверка названия блока, логотипов и ссылки 'Подробнее о сервисе'")
    public void testBlockMainElements() {
        steps.verifyBlockTitle("Онлайн пополнение без комиссии")
             .verifyPaymentLogosAreVisible();
        
        steps.clickMoreDetailsLink();
    }

    @Test
    @Story("Проверка плейсхолдеров")
    @DisplayName("Проверка надписей в незаполненных полях всех вариантов оплаты")
    public void testTabsPlaceholders() {
        steps.selectPaymentTab("Услуги связи")
             .verifyConnectionPlaceholders("Номер телефона", "Сумма");

        steps.selectPaymentTab("Домашний интернет")
             .verifyInternetPlaceholders("Номер договора", "Сумма");

        steps.selectPaymentTab("Рассрочка")
             .verifyInstallmentPlaceholders("Номер счета", "Сумма");

        steps.selectPaymentTab("Задолженность")
             .verifyArrearsPlaceholders("Номер счета", "Сумма");
    }

    @Test
    @Story("Проверка платежного виджета")
    @DisplayName("Заполнение полей 'Услуги связи' и валидация данных в открывшемся окне")
    public void testPaymentWidgetFlow() {
        String phoneNumber = "297777777";
        String paymentAmount = "10.00";

        steps.selectPaymentTab("Услуги связи")
             .fillConnectionData(phoneNumber, paymentAmount)
             .clickContinue()
             .switchToPaymentFrame()
             .verifyWidgetPaymentDetails(paymentAmount, phoneNumber)
             .verifyWidgetCardPlaceholders()
             .verifyWidgetLogosAreVisible();
    }
}