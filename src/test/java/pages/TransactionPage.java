package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class TransactionPage {

    public TransactionPage(){
        PageFactory.initElements(Driver.getDriver(),this);

    }


    @FindBy(xpath = "//button[@ng-click='deposit()']")
    public WebElement deposit;

    @FindBy(xpath = "//input[@ng-model='amount']")
    public WebElement amount;

    @FindBy(xpath = "//button[text()='Deposit']")
    public WebElement depositClick;

    @FindBy(xpath = "//button[@ng-click='withdrawl()']")
    public WebElement withdraw;

    @FindBy(xpath = "//button[text()='Withdraw']")
    public WebElement withdrawClick;

    @FindBy(xpath = "//span[@ng-show='message']")
    public WebElement successMessage;

    @FindBy(xpath = "//button[text()='Logout']")
    public WebElement logout;

}
