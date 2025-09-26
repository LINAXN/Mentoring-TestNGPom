package tests;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import pages.CLAddContactPage;
import pages.CLAddUserPage;
import pages.CLContactListPage;
import pages.CLhomePage;
import utilities.ConfigReader;
import utilities.Driver;

import java.time.Duration;

public class C01_ContactList {

    @Test
    void ContactListTest() {


        CLhomePage cLhomePage = new CLhomePage();
        CLAddUserPage cLAddUserPage = new CLAddUserPage();
        CLContactListPage clContactListPage = new CLContactListPage();
        CLAddContactPage clAddContactPage = new CLAddContactPage();


        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-popup-blocking");
        options.addArguments("--disable-save-password-bubble");
        options.addArguments("--disable-autofill-keyboard-accessory-view");
        options.addArguments("--incognito");
        Driver.getDriver().get(ConfigReader.getProperty("cl_url"));

        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));

        Faker faker = new Faker();

        wait.until(ExpectedConditions.elementToBeClickable(cLhomePage.signup)).click();
        cLAddUserPage.firstname.sendKeys(faker.name().firstName());
        cLAddUserPage.lastname.sendKeys(faker.name().lastName());
        cLAddUserPage.email.sendKeys(faker.internet().emailAddress());
        cLAddUserPage.password.sendKeys(faker.internet().password());
        cLAddUserPage.submit.click();


        for (int i = 0; i < 5; i++) {
            wait.until(ExpectedConditions.elementToBeClickable(clContactListPage.addContact)).click();

            wait.until(ExpectedConditions.visibilityOf(clAddContactPage.firstName));

            clAddContactPage.firstName.sendKeys(faker.name().firstName());
            clAddContactPage.lastName.sendKeys(faker.name().lastName());
            clAddContactPage.birthdate.sendKeys("1990-05-15");
            clAddContactPage.phone.sendKeys("050700743");
            clAddContactPage.email.sendKeys(faker.internet().emailAddress());
            clAddContactPage.street1.sendKeys(faker.address().streetAddress());
            clAddContactPage.street2.sendKeys(faker.address().secondaryAddress());
            clAddContactPage.city.sendKeys(faker.address().city());
            clAddContactPage.stateProvince.sendKeys(faker.address().state());
            clAddContactPage.postalCode.sendKeys(faker.address().zipCode());
            clAddContactPage.country.sendKeys(faker.address().country());


            clAddContactPage.submit.click();

            try {
                Driver.getDriver().switchTo().alert().dismiss();
            } catch (Exception e) {
                System.out.println("No alert present");// bcs sometimes alert appears, sometimes not
            }

            Driver.getDriver().navigate().refresh();


            wait.until(ExpectedConditions.elementToBeClickable(clContactListPage.addContact));
        }

        wait.until(ExpectedConditions.visibilityOfAllElements(clContactListPage.contactListRow));

        System.out.println("Total contacts added: " + clContactListPage.contactListRow.size());

        Driver.closeDriver();
    }
}
