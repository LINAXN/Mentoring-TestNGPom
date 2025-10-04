package utilities;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ScreenshotListener implements ITestListener {

    private String getTimestamp() {
        return new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
    }

    private void captureScreenshot(String testName, WebDriver driver) {
        File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            // Create screenshots folder if it does not exist
            Files.createDirectories(Paths.get("screenshots"));

            // Save screenshot with test name and timestamp
            String filename = "screenshots/" + testName + "_" + getTimestamp() + ".png";
            Files.copy(srcFile.toPath(), Paths.get(filename));
            System.out.println("📸 Screenshot saved: " + filename);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onTestFailure(ITestResult result) {
        Object currentClass = result.getInstance();
        WebDriver driver = Driver.getDriver(); // Thread-safe WebDriver

        String testName = result.getName();
        captureScreenshot(testName, driver);
    }
}
