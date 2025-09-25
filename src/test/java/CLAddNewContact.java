import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class CLAddNewContact {

    public CLAddNewContact(){
        PageFactory.initElements(Driver.getDriver(),this);

    }
    @FindBy(id = "signup")
    public WebElement signup;
}
