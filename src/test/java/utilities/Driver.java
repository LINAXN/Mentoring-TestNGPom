package utilities;


import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Driver {

    private static WebDriver driver;//Without initialization this is null.

    private Driver() {//None can create an object from this class
    }

    //This creates a new WebDriver instance if it does not exist.
    public static WebDriver getDriver() {

        if (driver == null) {
            ChromeOptions options = new ChromeOptions();

            // Disable Chrome autofill and save address prompts
            options.addArguments("--incognito");
            options.addArguments("--disable-autofill-keyboard-accessory-view");
            options.addArguments("--disable-save-password-bubble");
            options.addArguments("--disable-popup-blocking");

            driver = new ChromeDriver(options);
        }

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        return driver;
    }

    public static void waitForAlertAndAccept() {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        alert.accept();
    }





    //Safely close the driver
    public static void closeDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }




}