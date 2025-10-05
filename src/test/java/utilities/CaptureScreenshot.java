package utilities;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CaptureScreenshot {

    public static String takeScreenshot(WebDriver driver, String testName) {
        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String fileName = testName + "_" + timeStamp + ".png";
        String directory = System.getProperty("user.dir") + "/test-output/screenshots/";

        // Create directory if it doesn't exist
        new File(directory).mkdirs();

        String filePath = directory + fileName;

        try {
            File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            Path path = Paths.get(filePath);
            Files.copy(screenshot.toPath(), path);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return filePath;
    }

    // 🔹 الدالة الثانية: ترجع الصورة كـ Bytes (مخصصة لـ Allure)
    public static byte[] takeScreenshotBytes(WebDriver driver, String testName) {
        try {
            File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            return Files.readAllBytes(screenshot.toPath());
        } catch (IOException e) {
            e.printStackTrace();
            return new byte[0];
        }
    }
}

