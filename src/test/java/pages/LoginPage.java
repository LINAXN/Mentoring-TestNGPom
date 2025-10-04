package pages;

import org.openqa.selenium.By;
import utilities.Driver;

public class LoginPage {

    private By usernameField = By.name("username");
    private By passwordField = By.name("password");
    private By loginButton = By.xpath("//button[@type='submit']");
    private By dashboardHeader = By.xpath("//h6[contains(text(),'Dashboard')]");
    private By invalidCredMsg = By.xpath("//p[contains(text(),'Invalid credentials')]");

    public LoginPage enterUsername(String username) {
        Driver.getDriver().findElement(this.usernameField).sendKeys(username);

        return this;
    }

    public LoginPage enterPassword(String password) {
        Driver.getDriver().findElement(this.passwordField).sendKeys(password);
        return this;

    }

    public LoginPage clickLogin() {
        Driver.getDriver().findElement(loginButton).click();
        return this;
    }

    public boolean isLoginSuccessful() {

        return   Driver.getDriver().findElements(dashboardHeader).size() > 0;
    }

    public boolean isErrorMessageDisplayed() {

        return   Driver.getDriver().findElements(invalidCredMsg).size() > 0;
    }
}
