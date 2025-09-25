package tests;

import com.github.javafaker.Faker;
import org.testng.annotations.Test;
import pages.CLAddUserPage;
import pages.CLhomePage;
import utilities.ConfigReader;
import utilities.Driver;

public class C01_ContactList {

/*
    Target: https://thinking-tester-contact-list.herokuapp.com/
    Test Scenario:
    1. Navigate to the application
    2. Create a new user account
    3. Login with the created user
    4. Add 5 different contacts
    5. Assert that all contacts are properly added and displayed
     */



    @Test
    void ContactListTest() {
        CLhomePage cLhomePage = new CLhomePage();
        CLAddUserPage cLAddUserPage = new CLAddUserPage();
        Driver.getDriver().get(ConfigReader.getProperty("cl_url"));

        cLhomePage.signup.click();

        cLAddUserPage.firstname.sendKeys(Faker.instance().name().firstName());
        cLAddUserPage.lastname.sendKeys(Faker.instance().name().lastName());
        cLAddUserPage.email.sendKeys(Faker.instance().internet().emailAddress());
        cLAddUserPage.password.sendKeys(Faker.instance().internet().password());
        cLAddUserPage.submit.click();
        Driver.closeDriver();


    }
}
