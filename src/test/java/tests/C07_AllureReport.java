package tests;

import com.aventstack.extentreports.Status;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.SkipException;
import org.testng.annotations.Test;
import utilities.Driver;
import utilities.ExtentReportManager;

//@Listeners(MyTestListener.class)
public class C07_AllureReport {

    @Test
    @Description("This test is success")
    @Severity(SeverityLevel.BLOCKER)
    void test01() {
        System.out.println("PASS");
        Driver.getDriver().get("https://google.com");
        Driver.closeDriver();
    }

    @Test
    @Description("This test is fail")
    @Severity(SeverityLevel.CRITICAL)
    void test02() {
        System.out.println("FAIL");
        Driver.getDriver().get("https://instagram.com");
        assert false;
    }

    @Test
    @Description("This test is skip")
    @Severity(SeverityLevel.TRIVIAL)
    void test03() {
        System.out.println("SKIP");
        throw new SkipException("");
    }

}
