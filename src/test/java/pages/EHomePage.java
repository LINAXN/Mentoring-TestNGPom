package pages;

import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utilities.CaptureScreenshot;
import utilities.Driver;

public class EHomePage {
    private WebDriver driver;
    //button[text()='Signup']
    private By SignLog = By.xpath("//a[.=' Signup / Login']");
    private By nameInput = By.xpath("//input[@name='name']");
    private By EmailInput = By.xpath("//input[3][@name='email']");
    private By signupbtn = By.xpath("//button[.='Signup']");

    @Step("Click Signup/Login button on Home Page")
    public EHomePage clickSignup() {
        Driver.getDriver().findElement(this.SignLog).click();
        return this ;
    }
    @Step("Enter Name: {name}")
    public EHomePage enterName(String name) {
        Driver.getDriver().findElement(this.nameInput).sendKeys(name);
        return this;
    }
    @Step("Enter Email: {email}")
    public EHomePage enterEmail(String email) {
        Driver.getDriver().findElement(this.EmailInput).sendKeys(email);
        takeScreenshotAllure("Entered Email Screenshot");
        return this;
    }
    @Step("Click Signup Button")
    public ESignupPage clickSignupbtn() {
        Driver.getDriver().findElement(this.signupbtn).click();
        return new ESignupPage();
    }
    @Attachment(value = "{name}", type = "image/png")
    public byte[] takeScreenshotAllure(String name) {
        return CaptureScreenshot.takeScreenshotBytes(Driver.getDriver(), name);
    }

}
