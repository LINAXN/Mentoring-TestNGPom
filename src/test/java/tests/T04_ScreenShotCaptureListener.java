package tests;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import utilities.CaptureScreenshot;
import utilities.Driver;
import utilities.ScreenshotListener;

@Listeners(ScreenshotListener.class)
public class T04_ScreenShotCaptureListener {
     @Test
        public void testThatFails() {
            Driver.getDriver().get("https://automationexercise.com/products");
            //  failure
            String wrongTitle = Driver.getDriver().getTitle();
            Assert.assertTrue(wrongTitle.contains("lololololoo"), "Intentional failure");
        }
    }

