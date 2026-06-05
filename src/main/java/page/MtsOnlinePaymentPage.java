package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MtsOnlinePaymentPage {
    private final WebDriver driver;
    private final WebDriverWait wait;
    private final By cookieAgreeBtn = By.id("cookie-agree");
    private final By sectionTitle = By.xpath("//div[@class='pay__wrapper']/h2");
    private final By paymentLogos = By.cssSelector(".pay__partners ul li img");
    private final By detailsLink = By.linkText("Подробнее о сервисе");
    private final By serviceSelectHeader = By.cssSelector(".pay__form .select__header");
    private final By connectionPhoneInput = By.id("connection-phone");
    private final By connectionSumInput = By.id("connection-sum");
    private final By continueButton = By.xpath("//form[@id='pay-connection']//button[contains(text(), 'Продолжить')]");

    public MtsOnlinePaymentPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void open() {
        driver.get("https://www.mts.by/");
    }

    public void acceptCookies() {
        try {
            WebElement acceptCookiesBtn = wait.until(ExpectedConditions.elementToBeClickable(By.id("cookie-agree")));
            acceptCookiesBtn.click();
        } catch (Exception e) {
        }
    }

    public String getSectionTitleText() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(sectionTitle)).getText().trim();
    }

    public List<WebElement> getPaymentLogos() {
        return driver.findElements(paymentLogos);
    }

    public void clickMoreDetails() {
        WebElement link = wait.until(ExpectedConditions.elementToBeClickable(detailsLink));
        link.click();
    }

    public void selectConnectionServices() {
        WebElement selectDrop = wait.until(ExpectedConditions.elementToBeClickable(serviceSelectHeader));
        selectDrop.click();

        WebElement connectionServiceOption = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//li[@class='select__item']/p[contains(text(), 'Услуги связи')]")));
        connectionServiceOption.click();
    }

    public void fillPhoneNumber(String phone) {
        driver.findElement(connectionPhoneInput).sendKeys(phone);
    }

    public void fillSum(String sum) {
        driver.findElement(connectionSumInput).sendKeys(sum);
    }

    public void clickContinue() {
        driver.findElement(continueButton).click();
    }
}