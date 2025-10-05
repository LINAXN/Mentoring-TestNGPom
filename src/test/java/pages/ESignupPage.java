package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilities.Driver;
public class ESignupPage {


    // Locators for signup form
    private By titleMr = By.id("id_gender1");
    private By titleMrs = By.id("id_gender2");
    private By passwordField = By.id("password");
    private By dayDropdown = By.id("days");
    private By monthDropdown = By.id("months");
    private By yearDropdown = By.id("years");
    private By newsletterCheckbox = By.id("newsletter");
    private By offersCheckbox = By.id("optin");
    private By firstNameField = By.id("first_name");
    private By lastNameField = By.id("last_name");
    private By companyField = By.id("company");
    private By address1Field = By.id("address1");
    private By address2Field = By.id("address2");
    private By countryDropdown = By.id("country");
    private By stateField = By.id("state");
    private By cityField = By.id("city");
    private By zipcodeField = By.id("zipcode");
    private By mobileField = By.id("mobile_number");
    private By createAccountButton = By.xpath("//button[text()='Create Account']");
    private By continueButton = By.xpath("//a[text()='Continue']");
    private By loggedInText = By.xpath("//a[contains(text(),'Logged in as')]");
    private By productsButton = By.xpath("//a[@href='/products']");

    @Step("dill a form to signup")
    // --- Fluent Methods ---
    public ESignupPage selectTitle(String title) {
        if (title.equalsIgnoreCase("Mr")) {
            Driver.getDriver().findElement(titleMr).click();
        } else {
            Driver.getDriver().findElement(titleMrs).click();
        }
        return this;
    }

    public ESignupPage enterPassword(String password) {
        Driver.getDriver().findElement(passwordField).sendKeys(password);
        return this;
    }

    public ESignupPage selectDateOfBirth(String day, String month, String year) {
        new Select(Driver.getDriver().findElement(dayDropdown)).selectByVisibleText(day);
        new Select(Driver.getDriver().findElement(monthDropdown)).selectByVisibleText(month);
        new Select(Driver.getDriver().findElement(yearDropdown)).selectByVisibleText(year);
        return this;
    }

    public ESignupPage checkNewsletter() {
        WebElement checkbox = Driver.getDriver().findElement(newsletterCheckbox);
        if (!checkbox.isSelected()) checkbox.click();
        return this;
    }

    public ESignupPage checkOffers() {
        WebElement checkbox = Driver.getDriver().findElement(offersCheckbox);
        if (!checkbox.isSelected()) checkbox.click();
        return this;
    }

    public ESignupPage enterFirstName(String firstName) {
        Driver.getDriver().findElement(firstNameField).sendKeys(firstName);
        return this;
    }

    public ESignupPage enterLastName(String lastName) {
        Driver.getDriver().findElement(lastNameField).sendKeys(lastName);
        return this;
    }

    public ESignupPage enterCompany(String company) {
        Driver.getDriver().findElement(companyField).sendKeys(company);
        return this;
    }

    public ESignupPage enterAddress1(String address1) {
        Driver.getDriver().findElement(address1Field).sendKeys(address1);
        return this;
    }

    public ESignupPage enterAddress2(String address2) {
        Driver.getDriver().findElement(address2Field).sendKeys(address2);
        return this;
    }

    public ESignupPage selectCountry(String country) {
        new Select(Driver.getDriver().findElement(countryDropdown)).selectByVisibleText(country);
        return this;
    }

    public ESignupPage enterState(String state) {
        Driver.getDriver().findElement(stateField).sendKeys(state);
        return this;
    }

    public ESignupPage enterCity(String city) {
        Driver.getDriver().findElement(cityField).sendKeys(city);
        return this;
    }

    public ESignupPage enterZipcode(String zip) {
        Driver.getDriver().findElement(zipcodeField).sendKeys(zip);
        return this;
    }

    public ESignupPage enterMobileNumber(String mobile) {
        Driver.getDriver().findElement(mobileField).sendKeys(mobile);
        return this;
    }

    public ESignupPage clickCreateAccountButton() {
        Driver.getDriver().findElement(createAccountButton).click();
        return this;
    }

    public EHomePage clickContinueButton() {
        Driver.getDriver().findElement(continueButton).click();
        return new EHomePage();
    }

    public ESignupPage assertLoggedInAs(String name) {
        String text = Driver.getDriver().findElement(loggedInText).getText();
        if (!text.contains(name)) {
            throw new AssertionError("Expected logged in as " + name + " but found " + text);
        }
        return this;
    }

    public EProductsPage clickProductsButton() {
        Driver.getDriver().findElement(productsButton).click();
        return new EProductsPage();
    }
}
