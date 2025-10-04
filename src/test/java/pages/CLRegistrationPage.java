package pages;

import org.openqa.selenium.By;
import utilities.Driver;

public class CLRegistrationPage {
    private By firstName = By.id("firstName");
    private By lastName = By.id("lastName");
    private By email = By.id("email");
    private By password = By.id("password");
    private By signup = By.id("submit");


    public CLRegistrationPage enterfirstName(String firstName) {
        Driver.getDriver().findElement(this.firstName).sendKeys(firstName);
        return this;
    }

    public CLRegistrationPage enterlastName(String lastName) {
        Driver.getDriver().findElement(this.lastName).sendKeys(lastName);
        return this;
    }

    public CLRegistrationPage enteremail(String email) {
        Driver.getDriver().findElement(this.email).sendKeys(email);
        return this;
    }

    public CLRegistrationPage enterlpassword(String password) {
        Driver.getDriver().findElement(this.password).sendKeys(password);
        return this;
    }
    public CLRegistrationPage entersingin() {
        Driver.getDriver().findElement(this.signup).click();
        return this;
    }
}


