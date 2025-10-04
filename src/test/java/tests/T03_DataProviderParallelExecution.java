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

        WebDriver driver = Driver.getDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        //
        driver.get("https://automationexercise.com/products");

        // Wait
        WebElement searchBox = wait.until(ExpectedConditions.elementToBeClickable(By.id("search_product")));
        searchBox.clear();
        searchBox.sendKeys(searchTerm);

        // Wait for btn
        WebElement submitBtn = wait.until(ExpectedConditions.elementToBeClickable(By.id("submit_search")));
        submitBtn.click();

        // Wait for results
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".features_items")));
// list of products
        List<WebElement> products = driver.findElements(By.cssSelector(".product-image-wrapper"));
        Assert.assertTrue(products.size() > 0, "No products");

        System.out.println("Search done for: " + searchTerm + " | Products found: " + products.size());

            }

        }


