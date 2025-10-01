package pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.Assertion;
import org.testng.asserts.SoftAssert;
import utilities.Driver;

import java.time.Duration;

import static org.testng.AssertJUnit.assertEquals;

public class ComprehensiveNegativePage {
    // Locators
    private By usernameInput = By.xpath("//input[@type='text' and @placeholder='Username']");
    private By passwordInput = By.xpath("//input[@type='password' and @placeholder='Password']");
    private By signInButton = By.xpath("//input[@type='submit']");


    private SoftAssert softAssert;

    public ComprehensiveNegativePage(SoftAssert softAssert) {
        this.softAssert = softAssert;
    }

    public ComprehensiveNegativePage enterUsername(String username) {
        WebElement input = Driver.getDriver().findElement(usernameInput);

        input.sendKeys(username);
        return this;
    }

    public ComprehensiveNegativePage enterPassword(String password) {
        WebElement input = Driver.getDriver().findElement(passwordInput);
        input.sendKeys(password);
        return this;
    }

    public ComprehensiveNegativePage clickSignIn() {
        Driver.getDriver().findElement(signInButton).click();
        return this;
    }

    public ComprehensiveNegativePage assertAlertText(String expectedText) {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(5));
        wait.until(ExpectedConditions.alertIsPresent()); // wait for alert

        Alert alert = Driver.getDriver().switchTo().alert();
        String actualText = alert.getText();
        softAssert.assertEquals(actualText, expectedText, " Alert text mismatch!");
        alert.accept();
        return this;
    }


    public void assertAll() {
        softAssert.assertAll();
    }
    // --- Soft assertion for JS alert
    public ComprehensiveNegativePage assertAlertTextSoft(String expectedText, SoftAssert softAssert) {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(5));
        wait.until(ExpectedConditions.alertIsPresent());  // wait for alert

        Alert alert = Driver.getDriver().switchTo().alert();
        String actualText = alert.getText();

        softAssert.assertEquals(actualText, expectedText, "❌ Alert text mismatch!");
        alert.accept(); // close alert

        return this;
    }
}
