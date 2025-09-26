package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class CustomerManagementPage {

    public CustomerManagementPage(){
        PageFactory.initElements(Driver.getDriver(),this);

    }

    @FindBy(xpath = "//button[@ng-click='addCust()']")
    public WebElement addCustomer;

    @FindBy(xpath = "//input[@placeholder='First Name']")
    public WebElement firstName;

    @FindBy(xpath = "//input[@placeholder='Last Name']")
    public WebElement lastName;

    @FindBy(xpath = "//input[@placeholder='Post Code']")
    public WebElement postCode;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement submitCustomer;

    @FindBy(xpath = "//button[@ng-click='showCust()']")
    public WebElement showCustomers;

    @FindBy(xpath = "//button[@ng-click='deleteCust(cust)']")
    public WebElement byebye;

}
