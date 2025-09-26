package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class ManagerLoginPage {

    public ManagerLoginPage(){
        PageFactory.initElements(Driver.getDriver(),this);

    }

    @FindBy(xpath = "//button[text()='Bank Manager Login']")
    public WebElement managerLogin;

    @FindBy(xpath = "//button[text()='Home']")
    public WebElement Home;

}
