package pages;

import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import utilities.CaptureScreenshot;
import utilities.Driver;

import java.time.Duration;

public class ECheckoutPage {

    // Locators (based on AutomationExercise.com checkout page)
    private By nameOnCheckout = By.xpath("//h3[contains(text(),'Your delivery address')]");
    private By placeOrderBtn = By.xpath("//a[text()='Place Order']");
    private By nameField = By.name("name_on_card");
    private By cardNumberField = By.name("card_number");
    private By cvcField = By.name("cvc");
    private By expiryMonthField = By.name("expiry_month");
    private By expiryYearField = By.name("expiry_year");
    private By payAndConfirmBtn = By.id("submit"); // Adjust if needed

    WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));

    // --- Verify checkout page is loaded ---
    @Step("Assert checkout page loaded with expected")
    public ECheckoutPage assertCheckoutPageLoaded(String expected) {
        String text = Driver.getDriver().findElement(this.nameOnCheckout).getText();
        Assert.assertTrue(text.contains(expected), "Checkout page not loaded correctly!");
        return this;
    }

    // --- Fill payment info ---

    public ECheckoutPage enterCardDetails(String name, String number, String cvc, String month, String year) {
        Driver.getDriver().findElement(nameField).sendKeys(name);
        Driver.getDriver().findElement(cardNumberField).sendKeys(number);
        Driver.getDriver().findElement(cvcField).sendKeys(cvc);
        Driver.getDriver().findElement(expiryMonthField).sendKeys(month);
        Driver.getDriver().findElement(expiryYearField).sendKeys(year);
        return this;
    }

    @Step("Place order")
    // --- Place order ---
    public ECheckoutPage placeOrder() {
        wait.until(ExpectedConditions.elementToBeClickable(placeOrderBtn));
        Driver.getDriver().findElement(placeOrderBtn).click();
        return this;
    }
    @Step("Confirm payment")
    // --- Confirm payment ---
    public ECheckoutPage confirmPayment() {
        wait.until(ExpectedConditions.elementToBeClickable(payAndConfirmBtn));
        Driver.getDriver().findElement(payAndConfirmBtn).click();
        return this;
    }

    // --- Capture screenshot after checkout ---
    public ECheckoutPage takeScreenshot(String name) {
        CaptureScreenshot.takeScreenshot(Driver.getDriver(), name);
        return this;
    }
    @Attachment(value = "{name}", type = "image/png")
    public byte[] takeScreenshotAllure(String name) {
        return CaptureScreenshot.takeScreenshotBytes(Driver.getDriver(), name);
    }
    // --- Assert success message
    public ECheckoutPage assertOrderSuccess(String expectedText) {
        By successMsg = By.xpath("//p[contains(text(),'Congratulations! Your order has been confirmed!')]");
        wait.until(ExpectedConditions.visibilityOfElementLocated(successMsg));
        String text = Driver.getDriver().findElement(successMsg).getText();
        Assert.assertTrue(text.contains(expectedText), "Order success message not found!");
        return this;
    }
}
