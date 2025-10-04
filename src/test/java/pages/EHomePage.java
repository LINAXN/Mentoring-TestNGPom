package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class EHomePage {
    private WebDriver driver;
    //button[text()='Signup']
    private By SignLog = By.xpath("//a[.=' Signup / Login']");
    private By nameInput = By.xpath("//input[@name='name']");
    private By EmailInput = By.xpath("//input[3][@name='email']");
    private By signupbtn = By.xpath("//button[.='Signup']");


    public EHomePage clickSignup() {
        driver.findElement(this.SignLog).click();
        return this ;
    }
    public EHomePage enterName(String name) {
        driver.findElement(this.nameInput).sendKeys(name);
        return this;
    }
    public EHomePage enterEmail(String email) {
        driver.findElement(this.EmailInput).sendKeys(email);
        return this;
    }
    public EHomePage clickSignupbtn() {
        driver.findElement(this.signupbtn).click();
        return this;
    }
}
