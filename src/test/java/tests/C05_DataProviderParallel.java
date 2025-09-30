package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import utilities.DataProviderUtilities;
import utilities.Driver;


public class C05_DataProviderParallel {
    /*
    Go to https://testpages.eviltester.com/styled/basic-html-form-test.html
    Enter username using data provider utilities
    Enter password using data provider utilities
    Enter comment using data provider utilities
    Enter dropdown using data provider utilities
     */

  /*
    Go to https://testpages.eviltester.com/styled/basic-html-form-test.html
    Enter username using data provider utilities
    Enter password using data provider utilities
    Enter comment using data provider utilities
    Enter dropdown using data provider utilities
     */

    @Test(dataProvider = "faker", dataProviderClass = utilities.DataProviderUtilities.class)
    void dataProviderUtilsTest(String username, String password, String comment, String dropdown) {

//        Go to https://testpages.eviltester.com/styled/basic-html-form-test.html
        Driver.getDriver().get("https://testpages.eviltester.com/styled/basic-html-form-test.html");

//        Enter username using data provider utilities
        Driver.getDriver().findElement(By.name("username")).sendKeys(username);

//        Enter password using data provider utilities
        Driver.getDriver().findElement(By.name("password")).sendKeys(password);

//        Enter comment using data provider utilities
        WebElement textarea = Driver.getDriver().findElement(By.tagName("textarea"));
        textarea.clear();
        textarea.sendKeys(comment);

//        Enter dropdown using data provider utilities
        WebElement dd = Driver.getDriver().findElement(By.name("dropdown"));
        new Select(dd).selectByVisibleText(dropdown);

        Driver.closeDriver();
}}
