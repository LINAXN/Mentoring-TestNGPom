package tests;

import com.aventstack.extentreports.Status;
import com.github.javafaker.Faker;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.CLAddContactPage;
import pages.CLAddUserPage;
import pages.CLContactListPage;
import pages.CLhomePage;
import pages.CLhomePage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ExtentReportManager;

import java.time.Duration;
import java.time.LocalTime;

public class C08_ContactListReport {

    CLhomePage homePage;
    CLAddUserPage addUserPage;
    CLAddContactPage addContactPage;
    CLContactListPage contactListPage;
    Faker faker;
    WebDriverWait wait;

    @BeforeMethod
    public void setUp() {
        // Create Extent test
        ExtentReportManager.createTest(this.getClass().getSimpleName());
        ExtentReportManager.log(Status.INFO, "Test started at: " + LocalTime.now());

        // Navigate to app
        Driver.getDriver().get(ConfigReader.getProperty("cl_url"));
        ExtentReportManager.log(Status.INFO, "Navigated to Contact List app");

        wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));
        faker = new Faker();

        // Initialize Page Objects
        homePage = new CLhomePage();
        addUserPage = new CLAddUserPage();
        addContactPage = new CLAddContactPage();
        contactListPage = new CLContactListPage();
    }

    @AfterMethod
    public void tearDown(ITestResult result) {
        ExtentReportManager.log(Status.INFO, "Test finished at: " + LocalTime.now());
        ExtentReportManager.logResult(result);
        ExtentReportManager.flushReport();
        Driver.closeDriver();
    }

    @Test(description = "Register a user, add 5 contacts, and verify all contacts")
    public void addFiveContactsTest() {

        // 1️⃣ Register new user
        wait.until(ExpectedConditions.elementToBeClickable(homePage.signup)).click();
        addUserPage.firstname.sendKeys(faker.name().firstName());
        addUserPage.lastname.sendKeys(faker.name().lastName());
        addUserPage.email.sendKeys(faker.internet().emailAddress());
        addUserPage.password.sendKeys(faker.internet().password());
        addUserPage.submit.click();
        ExtentReportManager.log(Status.PASS, "User registered successfully");

        // 2️⃣ Add 5 contacts
        for (int i = 1; i <= 5; i++) {
            wait.until(ExpectedConditions.elementToBeClickable(contactListPage.addContact)).click();
            wait.until(ExpectedConditions.visibilityOf(addContactPage.firstName));

            addContactPage.firstName.sendKeys(faker.name().firstName());
            addContactPage.lastName.sendKeys(faker.name().lastName());
            addContactPage.birthdate.sendKeys("1990-05-15");
            addContactPage.phone.sendKeys("050700743");
            addContactPage.email.sendKeys(faker.internet().emailAddress());
            addContactPage.street1.sendKeys(faker.address().streetAddress());
            addContactPage.city.sendKeys(faker.address().city());
            addContactPage.stateProvince.sendKeys(faker.address().state());
            addContactPage.postalCode.sendKeys(faker.address().zipCode());
            addContactPage.country.sendKeys(faker.address().country());

            addContactPage.submit.click();

            try { Driver.getDriver().switchTo().alert().dismiss(); } catch (Exception e) {}

            Driver.getDriver().navigate().refresh();
            ExtentReportManager.log(Status.PASS, "Contact " + i + " added successfully");
        }

        // 3️⃣ Verify total contacts
        wait.until(ExpectedConditions.visibilityOfAllElements(contactListPage.contactListRow));
        int totalContacts = contactListPage.contactListRow.size();
        ExtentReportManager.log(Status.INFO, "Total contacts added: " + totalContacts);
        Assert.assertEquals(totalContacts, 5, "Expected 5 contacts to be added");
        ExtentReportManager.log(Status.PASS, "All 5 contacts verified successfully");
    }
}
