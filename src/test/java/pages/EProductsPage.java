package pages;

import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.CaptureScreenshot;
import utilities.Driver;

import java.time.Duration;

public class EProductsPage {
    private By productLink = By.xpath("//a[@href='/products']");
    private By continueBtn = By.xpath("//button[text()='Continue Shopping']");
    private By viewCartBtn = By.xpath("//a[@href='/view_cart']");

    // Navigate to Products page
    public EProductsPage clickProductsButton() {
        Driver.getDriver().findElement(productLink).click();
        return this;
    }

    // Add a product to cart by index (1-based)
    @Step("Add product to cart")
    public EProductsPage addProductToCart(int productId) {
        By btn = By.cssSelector("a.btn.add-to-cart[data-product-id='" + productId + "']");
        takeScreenshotAllure("add to cart product id " + productId);
        Driver.getDriver().findElement(btn).click();

        // Wait for Continue Shopping button to appear
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(5));
        try {
            wait.until(ExpectedConditions.elementToBeClickable(continueBtn));
            Driver.getDriver().findElement(continueBtn).click();
        } catch (Exception e) {
            // If the popup doesn’t appear, continue silently
        }

        return this; // allows chaining
    }

    // Click Continue Shopping (optional explicit method)
    @Step("Continue shopping after adding a product")
    public EProductsPage continueShopping() {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(5));
        try {
            wait.until(ExpectedConditions.elementToBeClickable(continueBtn));
            takeScreenshotAllure("continue after add to cart ");
            Driver.getDriver().findElement(continueBtn).click();

        } catch (Exception e) { }
        return this;
    }
    @Attachment(value = "{name}", type = "image/png")
    public byte[] takeScreenshotAllure(String name) {
        return CaptureScreenshot.takeScreenshotBytes(Driver.getDriver(), name);
    }

//     Go to cart page
    public ECartPage viewCart() {
        Driver.getDriver().findElement(viewCartBtn).click();
        return new ECartPage(); // navigate to next page
    }
}
