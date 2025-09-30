package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import utilities.Driver;

public class PositiveLoginTest {
    @Test(timeOut = 30000)
    public void validLoginTest() {
        Driver.getDriver().get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
//        LoginPage loginPage = new LoginPage();
        new LoginPage()
                .enterUsername("Admin")
                .enterPassword("admin123")
                .clickLogin();
        Assert.assertTrue(new LoginPage().isLoginSuccessful(),
                "Login should be successful with valid credentials");
    }
        @Test
        void oHRMNegativeLoginTest1() {
            LoginPage loginPage = new LoginPage();
            Driver.getDriver().get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
            loginPage
                    //.enterUsername("Admin")
                    .enterPassword("admin123")
                    .clickLogin();

            Driver.closeDriver();

        }

        @Test
        void oHRMNegativeLoginTest2() {
            LoginPage loginPage = new LoginPage();
            Driver.getDriver().get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
            loginPage
                    .enterUsername("Admin")
                    //.enterPassword("admin123")
                    .clickLogin();


            Assert.assertTrue(new LoginPage().isLoginSuccessful(),
                    "Login should be successful with valid credentials");
            Driver.closeDriver();
        }

        @Test
        void oHRMNegativeLoginTest3() {
            LoginPage loginPage = new LoginPage();
            Driver.getDriver().get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
            loginPage
//                .enterUsername("Admin")
//                .enterPassword("admin123")
                    .clickLogin();

            Driver.closeDriver();
            Assert.assertTrue(new LoginPage().isLoginSuccessful(),
                    "Login should be successful with valid credentials");
        }


    }

