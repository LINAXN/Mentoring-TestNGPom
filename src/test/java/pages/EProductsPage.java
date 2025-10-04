package pages;

import org.openqa.selenium.By;
import utilities.Driver;

public class EProductsPage {
    private By ProductLink = By.xpath("//a[@href='products']");
    private By productAddBtn = By.xpath("(//a[text()='Add to cart'])");
    private By continueBtn = By.xpath("//button[text()='Continue Shopping']");

    // Navigate to Products page
    public void goToProducts() {
        Driver.getDriver().findElement(this.ProductLink).click();
    }

    // Add a product to cart by index (1-based)
    public void addProductToCart(int index) {
        By specificProductBtn = By.xpath("(//a[text()='Add to cart'])[" + index + "]");
        Driver.getDriver().findElement(this.productAddBtn).click();
        // Close popup if it appears
        if (Driver.getDriver().findElements(continueBtn).size() > 0) {
            Driver.getDriver().findElement(continueBtn).click();
        }
    }
}
