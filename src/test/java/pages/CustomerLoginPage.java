package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import utilities.Driver;

public class CustomerLoginPage {

    public CustomerLoginPage(){
        PageFactory.initElements(Driver.getDriver(),this);

    }
@FindBy(xpath = "//button[text()='Customer Login']")
    public WebElement customerLogin;

    @FindBy(id = "userSelect")
    public WebElement userSelect;

    @FindBy(xpath = "//button[text()='Login']")
    public WebElement login;

    public void selectCustomer(String name) {
        new Select(userSelect).selectByVisibleText(name);
    }
}
