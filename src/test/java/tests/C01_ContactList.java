package tests;

import com.github.javafaker.Faker;
import org.testng.annotations.Test;
import pages.CLAddContactPage;
import pages.CLAddUserPage;
import pages.CLContactListPage;
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
    void ContactListTest() throws InterruptedException {
        CLhomePage cLhomePage = new CLhomePage();
        CLAddUserPage cLAddUserPage = new CLAddUserPage();
        CLContactListPage clContactListPage=new CLContactListPage();
        CLAddContactPage clAddContactPage = new CLAddContactPage();

        Driver.getDriver().get(ConfigReader.getProperty("cl_url"));

        cLhomePage.signup.click();

        cLAddUserPage.firstname.sendKeys(Faker.instance().name().firstName());
        cLAddUserPage.lastname.sendKeys(Faker.instance().name().lastName());
        cLAddUserPage.email.sendKeys(Faker.instance().internet().emailAddress());
        cLAddUserPage.password.sendKeys(Faker.instance().internet().password());
        cLAddUserPage.submit.click();
        clContactListPage.addContact.click();

        clAddContactPage.firstName.sendKeys(Faker.instance().name().firstName());
        clAddContactPage.lastName.sendKeys(Faker.instance().name().lastName());
        Thread.sleep(3000); // add expilt wait
        clAddContactPage.birthdate.sendKeys(Faker.instance().date().birthday().toString());
        Thread.sleep(3000);
        clAddContactPage.submit.click();

        Driver.closeDriver();


    }
}
