package tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.DataProviderUtilities;
import utilities.Driver;

public class T03_DataProviderParallelExecution {
    @Test(dataProvider = "searchTerms", dataProviderClass = DataProviderUtilities.class)
    public void searchTest(String searchTerm) {
        // Go to the search page
        Driver.getDriver().get("https://www.example.com"); // replace with actual URL

        // Locate search input and enter term
        Driver.getDriver().findElement(By.id("searchBox")).clear();
        Driver.getDriver().findElement(By.id("searchBox")).sendKeys(searchTerm);
        Driver.getDriver().findElement(By.id("searchBtn")).click();

        // Validate that results contain the search term
        String resultsText = Driver.getDriver().findElement(By.id("results")).getText();
        Assert.assertTrue(resultsText.contains(searchTerm), "Results do not contain: " + searchTerm);
    }
}

