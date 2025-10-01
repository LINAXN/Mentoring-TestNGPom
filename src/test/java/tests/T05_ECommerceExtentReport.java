package tests;

import com.github.javafaker.Faker;
import org.testng.annotations.Test;
import utilities.Driver;

public class T05_ECommerceExtentReport{
 /*
 Target: https://automationexercise.com/
 Test Scenario:
 1. Navigate to the application
 2. Sign up a new user account
 3. Add 3 products to cart
 4. Complete the shopping process (checkout)
 Page Objects Needed:- HomePage (navigation elements)- SignupPage (registration form)- ProductsPage (product listing and add to cart)- CartPage (cart management)- CheckoutPage (checkout process)
 ExtentReports Requirements:- Create comprehensive HTML report- Log each major step with .info()- Add .pass() for successful operations- Add .fail() with screenshots for any failures- Include before/after screenshots for cart operations- Add test execution time tracking
 */



@Test
        void eCommerceTest() {
    Driver.getDriver().get("https://automationexercise.com/");
    Faker faker = new Faker();

        }






}
