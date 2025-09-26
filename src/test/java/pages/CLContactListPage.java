package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class CLContactListPage {

    public CLContactListPage(){
        PageFactory.initElements(Driver.getDriver(),this);

    }

    @FindBy(id = "add-contact")
    public WebElement addContact;

    @FindBy(xpath = "//table/tr")
    public List<WebElement> contactListRow;

}
