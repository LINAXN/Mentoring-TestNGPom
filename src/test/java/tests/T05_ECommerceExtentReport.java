import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.github.javafaker.Faker;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.*;
import utilities.CaptureScreenshot;
import utilities.Driver;

public class T05_ECommerceExtentReport {
ExtentReports extent;
ExtentSparkReporter spark;
ExtentTest test;
Faker faker = new Faker();

@BeforeTest
public void setUpReport() {
    extent = new ExtentReports();
    spark = new ExtentSparkReporter("test-output/EcommerceExtentReport.html");
    extent.attachReporter(spark);
    extent.setSystemInfo("Project", "Automation Exercise");
    extent.setSystemInfo("Tester", "Lina");
}

@Test
void eCommerceTest() {
    test = extent.createTest("E-Commerce Full Flow Test")
            .assignCategory("Functional Test")
            .assignAuthor("Lina");

    try {
        test.info("Navigating to the application...");
        Driver.getDriver().get("https://automationexercise.com/");
        EHomePage homePage = new EHomePage();

        test.info("Starting signup process...");
        homePage.clickSignup()
                .enterName(faker.name().firstName())
                .enterEmail(faker.internet().emailAddress())
                .clickSignupbtn();

        test.info("Filling out signup form...");
        ESignupPage signupPage = new ESignupPage();
        signupPage.selectTitle("Mr")
                .enterPassword("12345")
                .selectDateOfBirth("10", "May", "1990")
                .checkNewsletter()
                .checkOffers()
                .enterFirstName(faker.name().firstName())
                .enterLastName(faker.name().lastName())
                .enterCompany(faker.company().name())
                .enterAddress1(faker.address().streetAddress())
                .enterAddress2(faker.address().secondaryAddress())
                .selectCountry("Canada")
                .enterState(faker.address().state())
                .enterCity(faker.address().city())
                .enterZipcode(faker.address().zipCode())
                .enterMobileNumber(faker.phoneNumber().cellPhone())
                .clickCreateAccountButton()
                .clickContinueButton();

        test.pass("Account successfully created and logged in.");

        test.info("Navigating to products page...");
        EProductsPage productsPage = new EProductsPage();
        productsPage.clickProductsButton();

        test.info("Adding products to cart...");
        productsPage.addProductToCart(1);
        String firstProductScreenshot = CaptureScreenshot.takeScreenshot(Driver.getDriver(), "AddFirstProduct");
        test.pass("First product added to cart").addScreenCaptureFromPath(firstProductScreenshot);

        productsPage.continueShopping();

        productsPage.addProductToCart(2);
        String secondProductScreenshot = CaptureScreenshot.takeScreenshot(Driver.getDriver(), "AddSecondProduct");
        test.pass("Second product added to cart").addScreenCaptureFromPath(secondProductScreenshot);
        productsPage.continueShopping();

        productsPage.addProductToCart(3);
        String thirdProductScreenshot = CaptureScreenshot.takeScreenshot(Driver.getDriver(), "AddThirdProduct");
        test.pass("Third product added to cart").addScreenCaptureFromPath(thirdProductScreenshot);

        // --- Cart ---
        ECartPage cartPage = productsPage.viewCart();
        String cartScreenshot = CaptureScreenshot.takeScreenshot(Driver.getDriver(), "CartPage");
        cartPage.assertTotalProductsInCart(3);
        test.pass("Viewed cart with 3 products").addScreenCaptureFromPath(cartScreenshot);
//
        ECheckoutPage checkout = cartPage.proceedToCheckout();
        checkout
                .placeOrder()
        .enterCardDetails("Lina", "4111111111111111", "123", "12", "2025")

                .confirmPayment()
                .takeScreenshot("Checkout Complete")
                .assertOrderSuccess("Congratulations! Your order has been confirmed!");

        test.pass("E-commerce flow completed successfully");

    } catch (Exception e) {
        String screenshotPath = CaptureScreenshot.takeScreenshot(Driver.getDriver(), "problem occurred");
        test.fail("Test failed: " + e.getMessage())
                .addScreenCaptureFromPath(screenshotPath);
    }
}

@AfterTest
public void tearDown() {
    extent.flush();
    Driver.closeDriver();
}
}