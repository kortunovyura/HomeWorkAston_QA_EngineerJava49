package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class MtsOnlinePaymentPage {
    private final WebDriver driver;

    public MtsOnlinePaymentPage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getBlockTitle() {
        return driver.findElement(By.cssSelector(".pay__wrapper h2, .section__title h2"));
    }

    public List<WebElement> getPaymentLogos() {
        return driver.findElements(By.cssSelector(".pay__logos img"));
    }

    public WebElement getDetailsLink() {
        return driver.findElement(By.xpath("//a[contains(text(),'Подробнее о сервисе')]"));
    }

    public WebElement getTab(String tabName) {
        return driver.findElement(By.xpath("//span[contains(text(),'" + tabName + "')] | //a[contains(text(),'" + tabName + "')]"));
    }

    public WebElement getConnectionPhoneInput() {
        return driver.findElement(By.id("connection-phone"));
    }

    public WebElement getConnectionSumInput() {
        return driver.findElement(By.id("connection-sum"));
    }

    public WebElement getInternetPhoneInput() {
        return driver.findElement(By.id("internet-phone"));
    }

    public WebElement getInternetSumInput() {
        return driver.findElement(By.id("internet-sum"));
    }

    public WebElement getInstallmentScoreInput() {
        return driver.findElement(By.id("score-instalment"));
    }

    public WebElement getInstallmentSumInput() {
        return driver.findElement(By.id("instalment-sum"));
    }

    public WebElement getArrearsScoreInput() {
        return driver.findElement(By.id("score-arrears"));
    }

    public WebElement getArrearsSumInput() {
        return driver.findElement(By.id("arrears-sum"));
    }

    public WebElement getContinueButton() {
        return driver.findElement(By.cssSelector(".pay__form button[type='submit'], #connection-form button"));
    }

    public WebElement getPaymentIframe() {
        return driver.findElement(By.cssSelector("iframe.payment-frame, iframe[src*='bpc']"));
    }

    public WebElement getWidgetSumText() {
        return driver.findElement(By.cssSelector(".amount-display, .pay-description__cost"));
    }

    public WebElement getWidgetPhoneText() {
        return driver.findElement(By.cssSelector(".phone-display, .pay-description__text"));
    }

    public WebElement getWidgetSubmitButton() {
        return driver.findElement(By.cssSelector(".pay-btn, button[type='submit']"));
    }

    public WebElement getCardNumberInput() {
        return driver.findElement(By.id("cc-number"));
    }

    public WebElement getCardExpiryInput() {
        return driver.findElement(By.id("cc-expire"));
    }

    public WebElement getCardCvvInput() {
        return driver.findElement(By.id("cc-cvv"));
    }

    public WebElement getCardHolderInput() {
        return driver.findElement(By.id("cc-name"));
    }

    public List<WebElement> getWidgetPaymentLogos() {
        return driver.findElements(By.cssSelector(".widget-pay__logos img, .cards-types img"));
    }
}