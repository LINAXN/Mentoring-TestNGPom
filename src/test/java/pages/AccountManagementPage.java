package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import utilities.Driver;

import java.util.List;

public class AccountManagementPage {

    public AccountManagementPage(){
        PageFactory.initElements(Driver.getDriver(),this);

    }

    @FindBy(xpath = "//button[@ng-click='openAccount()']")
    public WebElement openAccount;

    @FindBy(id = "userSelect")
    public WebElement customerSelect;

    @FindBy(id = "currency")
    public WebElement currency;

    @FindBy(xpath = "//button[text()='Process']")
    public WebElement process;


    public void selectCustomer(String customerName) {
        new Select(customerSelect).selectByVisibleText(customerName);
    }

    public void selectCurrency(String currency1) {
        new Select(currency).selectByVisibleText(currency1);
    }
}
