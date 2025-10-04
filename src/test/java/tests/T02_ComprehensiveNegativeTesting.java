package tests;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.ComprehensiveNegativePage;
import utilities.Driver;

public class T02_ComprehensiveNegativeTesting {
    /*
Go to https://claruswaysda.github.io/signIn.html
Do negative test with all scenarios
*/


    @Test
    public void negativeTests() {
        Driver.getDriver().get("https://claruswaysda.github.io/signIn.html");
        SoftAssert softAssert = new SoftAssert();
        ComprehensiveNegativePage signInPage = new ComprehensiveNegativePage(softAssert);

        // Empty username/password
        signInPage.enterUsername("")
                .enterPassword("")
                .clickSignIn();
        String msg = Driver.getDriver().findElement(By.id("username"))
                .getAttribute("validationMessage");
        softAssert.assertEquals(msg, "Please fill out this field.", " Empty username validation failed");
        softAssert.assertAll();
    }
    @Test
    public void moreNegativeTests() {
        Driver.getDriver().get("https://claruswaysda.github.io/signIn.html");
        SoftAssert softAssert = new SoftAssert();
        ComprehensiveNegativePage signInPage = new ComprehensiveNegativePage(softAssert);
        // Invalid username
        signInPage.enterUsername("notAdmin")
                .enterPassword("123")
                .clickSignIn()
                .assertAlertText("Incorrect username or password");
        softAssert.assertAll();
    }
    @Test
    public void finalNegativeTests() {
        Driver.getDriver().get("https://claruswaysda.github.io/signIn.html");
        SoftAssert softAssert = new SoftAssert();
        ComprehensiveNegativePage signInPage = new ComprehensiveNegativePage(softAssert);
        //  Wrong password
        signInPage.enterUsername("admin")
                .enterPassword("wrongPass")
                .clickSignIn()
                .assertAlertText("Incorrect username or password");
        softAssert.assertAll();
    }
    @Test
    public void xssNegativeTest() {
        Driver.getDriver().get("https://claruswaysda.github.io/signIn.html");
        SoftAssert softAssert = new SoftAssert();
        ComprehensiveNegativePage signInPage = new ComprehensiveNegativePage(softAssert);
        //  XSS attempt
        signInPage.enterUsername("<script>alert('XSS')</script>")
                .enterPassword("hack123")
                .clickSignIn()
                .assertAlertText("Incorrect username or password");
        softAssert.assertAll();
    }
    @Test
    public void sqlInjectionNegativeTest() {
        Driver.getDriver().get("https://claruswaysda.github.io/signIn.html");
        SoftAssert softAssert = new SoftAssert();
        ComprehensiveNegativePage signInPage = new ComprehensiveNegativePage(softAssert);
        softAssert.assertAll();
    }
    @Test
            public void tearDown() {
        Driver.closeDriver();
    }

}
