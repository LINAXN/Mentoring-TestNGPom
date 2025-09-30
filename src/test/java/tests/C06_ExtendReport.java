package tests;

import com.aventstack.extentreports.Status;
import org.testng.SkipException;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import utilities.Driver;
import utilities.ExtentReportManager;
//@Listeners(utilities.MyTestListener.class)
public class C06_ExtendReport {
    @Test //pass
    void test01() {
        System.out.println("Test passed");
        Driver.getDriver().get("https://google.com");
        ExtentReportManager.log(Status.INFO,"we are on google page");
        Driver.closeDriver();
    }
    @Test //fail
    void test02() {
        System.out.println("Test failed");
        Driver.getDriver().get("https://instagram.com");
        ExtentReportManager.log(Status.INFO,"we are on instagram page");
        assert false;
//        Driver.closeDriver(); -- we can close it with lesntner

    }
    @Test //skip
    void test03() {
        System.out.println("Test skipped");
        throw new SkipException("");
    }
}
