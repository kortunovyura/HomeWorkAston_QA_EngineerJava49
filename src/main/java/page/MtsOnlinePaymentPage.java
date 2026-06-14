package page;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.List;

@Getter
@RequiredArgsConstructor
public class MtsOnlinePaymentPage {
    private final WebDriver driver;
    
    private WebDriverWait getWait() {
        return new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    private final By cookieAcceptBtn = By.id("cookie-agree");
    private final By sectionTitle = By.xpath("//div[@class='pay__wrapper']/h2");
    private final By paymentLogos = By.xpath("//div[@class='pay__partners']//img");
    private final By moreDetailsLink = By.xpath("//a[contains(text(), 'Подробнее о сервисе')]");
    private final By continueBtn = By.xpath("//button[contains(text(), 'Продолжить')]");

    private final By tabConnection = By.xpath("//button[contains(text(), 'Услуги связи')]");
    private final By tabHomeInternet = By.xpath("//button[contains(text(), 'Домашний интернет')]");
    private final By tabInstallment = By.xpath("//button[contains(text(), 'Рассрочка')]");
    private final By tabArrears = By.xpath("//button[contains(text(), 'Задолженность')]");

    private final By phoneInput = By.id("connection-phone");
    private final By sumInput = By.id("connection-sum");
    private final By emailInput = By.id("connection-email");
    
    private final By internetPhoneInput = By.id("internet-phone");
    private final By internetSumInput = By.id("internet-sum");
    
    private final By scoreInstalmentInput = By.id("score-instalment");
    private final By instalmentSumInput = By.id("instalment-sum");
    
    private final By scoreArrearsInput = By.id("score-arrears");
    private final By arrearsSumInput = By.id("arrears-sum");

    private final By paymentModalFrame = By.xpath("//iframe[contains(@class, 'bepaid-iframe') or contains(@src, 'bepaid') or contains(@src, 'asb.by')]");
    private final By iframeTotalSum = By.xpath("//span[contains(@class, 'pay-description__cost')]");
    private final By iframeSubmitBtn = By.xpath("//button[@type='submit' and contains(text(), 'Оплатить')]");
    private final By iframePhoneInfo = By.xpath("//span[contains(@class, 'pay-description__text')]");
    
    private final By cardNumberInput = By.id("cc-number");
    private final By cardExpiryInput = By.id("cc-exp");
    private final By cardCvcInput = By.id("cc-csc");
    private final By cardHolderInput = By.id("cc-holder");
    private final By iframeCardLogos = By.xpath("//div[contains(@class, 'cards-brands')]//img");

    public void open() {
        driver.get("https://www.mts.by");
    }

    public void acceptCookies() {
        try {
            getWait().until(ExpectedConditions.elementToBeClickable(cookieAcceptBtn)).click();
        } catch (Exception ignored) {}
    }

    public String getSectionTitleText() {
        return getWait().until(ExpectedConditions.visibilityOfElementLocated(sectionTitle)).getText();
    }

    public List<WebElement> getPaymentLogos() {
        return driver.findElements(paymentLogos);
    }

    public void clickMoreDetails() {
        driver.findElement(moreDetailsLink).click();
    }

    public void selectConnectionServices() { driver.findElement(tabConnection).click(); }
    public void selectHomeInternet() { driver.findElement(tabHomeInternet).click(); }
    public void selectInstallment() { driver.findElement(tabInstallment).click(); }
    public void selectArrears() { driver.findElement(tabArrears).click(); }

    public void fillPhoneNumber(String phone) { driver.findElement(phoneInput).sendKeys(phone); }
    public void fillSum(String sum) { driver.findElement(sumInput).sendKeys(sum); }

    public String getPlaceholder(By locator) {
        return driver.findElement(locator).getAttribute("placeholder");
    }

    public void clickContinue() {
        driver.findElement(continueBtn).click();
    }

    public void switchToPaymentModal() {
        getWait().until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(paymentModalFrame));
    }

    public void switchToDefaultContent() {
        driver.switchTo().defaultContent();
    }

    public String getIframeTotalSumText() {
        return getWait().until(ExpectedConditions.visibilityOfElementLocated(iframeTotalSum)).getText();
    }

    public String getIframeSubmitBtnText() {
        return driver.findElement(iframeSubmitBtn).getText();
    }

    public String getIframePhoneInfoText() {
        return driver.findElement(iframePhoneInfo).getText();
    }

    public String getIframeCardPlaceholder(By locator) {
        return driver.findElement(locator).getAttribute("placeholder");
    }

    public List<WebElement> getIframeCardLogos() {
        return driver.findElements(iframeCardLogos);
    }
}
