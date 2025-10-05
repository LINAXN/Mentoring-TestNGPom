package tests;

import io.qameta.allure.*;
import org.testng.annotations.Test;
import pages.*;
import utilities.Driver;
import com.github.javafaker.Faker;

@Epic("E-commerce Platform")
public class T06_ECommerceAllureTest {

    @Epic("E-commerce Platform")
    @Feature("User Management: Signup")
    @Feature("Shopping Cart")
    @Feature("Checkout Process")
    @Story("Complete e-commerce user flow")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Verify that a new user can sign up, add 3 products to cart, and complete checkout successfully.")
    @Test
    public void eCommerceAllureTest() {
        Faker faker = new Faker();
        Driver.getDriver().get("https://automationexercise.com/");

        // Signup
        EHomePage homePage = new EHomePage();
        homePage.clickSignup()
                .enterName(faker.name().firstName())
                .enterEmail(faker.internet().emailAddress())
                .clickSignupbtn();
        // Products
        ESignupPage signupPage = new ESignupPage();
        signupPage.selectTitle("Mr")
                .enterPassword("12345")
                .selectDateOfBirth("10", "May", "2001")
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
                .clickContinueButton()
        .takeScreenshotAllure("Signup Complete");

        EProductsPage productsPage = new EProductsPage();
        productsPage.clickProductsButton();
        productsPage.addProductToCart(1)
                .continueShopping()
                .addProductToCart(2)
                .continueShopping()
                .addProductToCart(3)
        .takeScreenshotAllure("3 Products Added to Cart");
        // Cart
        ECartPage cartPage = productsPage.viewCart();
        cartPage.assertTotalProductsInCart(3)
        .takeScreenshotAllure("Cart with 3 products");
        //checkout
        ECheckoutPage checkout = cartPage.proceedToCheckout();
        checkout
                .placeOrder()
                .enterCardDetails("Lina", "6111111311115111", "123", "12", "2001")
                .confirmPayment()
                .assertOrderSuccess("Congratulations! Your order has been confirmed!")
                .takeScreenshotAllure("Checkout Complete");
    }
}
