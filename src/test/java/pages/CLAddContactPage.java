package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class CLAddContactPage {

    public CLAddContactPage(){
        PageFactory.initElements(Driver.getDriver(),this);

    }
    @FindBy(id = "firstName")
    public WebElement firstName;

    @FindBy(id = "lastName")
    public WebElement lastName;

    @FindBy(id = "submit")
    public WebElement submit;

    @FindBy(id="birthdate")
    public WebElement birthdate;

}
