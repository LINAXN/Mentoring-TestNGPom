package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import utilities.DataProviderUtilities;
import utilities.Driver;

import java.time.Duration;
import java.util.List;

public class T03_DataProviderParallelExecution {

    @Test(dataProvider = "searchTerms", dataProviderClass = DataProviderUtilities.class)
    public void searchTest(String searchTerm) {

        // Open website
        Driver.getDriver().get("https://automationexercise.com/products");


        // Search for term

       Driver.getDriver().findElement(By.xpath("//input[@id='search_product']")).clear();
        Driver.getDriver().findElement(By.xpath("//input[@id='search_product']")).sendKeys(searchTerm);
        Driver.getDriver().findElement(By.xpath("//button[@id='submit_search']")).click();




//        // Validate heading contains search term
//        WebElement resultsHeading = Driver.getDriver().findElement(By.cssSelector(".features_items h2"));
//        String headingText = resultsHeading.getText().toLowerCase();
//        Assert.assertTrue(headingText.contains(searchTerm.toLowerCase()),
//                "Results heading does not contain: " + searchTerm);
//
//        // Optional: validate at least one product appears
//        List<WebElement> products = Driver.getDriver().findElements(By.cssSelector(".product-image-wrapper"));
//        Assert.assertTrue(products.size() > 0, "No products found for: " + searchTerm);

            }

        }


