package pages;

import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.testng.Assert;
import utilities.CaptureScreenshot;
import utilities.Driver;

public class ECartPage {
    private By cartItems = By.xpath("//table[@id='cart_info_table']//tr[contains(@id,'product')]");
    private By proceedToCheckoutBtn = By.xpath("//a[text()='Proceed To Checkout']");
    @Step("Assert total products in cart: {expectedCount}")
    public ECartPage assertTotalProductsInCart(int expectedCount) {
        int actualCount = Driver.getDriver().findElements(this.cartItems).size();
        takeScreenshotAllure("Cart Items Screenshot");
        Assert.assertEquals(actualCount, expectedCount, "Cart item count mismatch!");
        return this;
    }

    public ECheckoutPage proceedToCheckout() {
        Driver.getDriver().findElement(this.proceedToCheckoutBtn).click();
        return new ECheckoutPage();

    }
    @Attachment(value = "{name}", type = "image/png")
    public byte[] takeScreenshotAllure(String name) {
        return CaptureScreenshot.takeScreenshotBytes(Driver.getDriver(), name);
    }
}
