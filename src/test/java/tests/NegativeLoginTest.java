package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import utilities.Driver;

public class NegativeLoginTest {
    @Test(timeOut = 30000)
    public void invalidLoginTest() {
        Driver.getDriver().get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

        new LoginPage()
                .enterUsername("uu")
                .enterPassword("mm")
                .clickLogin();
//
//        Assert.assertTrue(new LoginPage().isErrorMessageDisplayed(),
//                "Invalid login should display error message");
    }
}
