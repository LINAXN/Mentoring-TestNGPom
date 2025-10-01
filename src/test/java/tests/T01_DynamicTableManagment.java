package tests;

import org.testng.annotations.Test;
import pages.AddRecordPage;
import utilities.DataProviderUtilities;
import utilities.Driver;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class T01_DynamicTableManagment {
    /*
 Go to https://claruswaysda.github.io/addRecordWebTable.html
 Add records to the table using DataProvider
 */

    @Test(dataProvider = "recordData", dataProviderClass = DataProviderUtilities.class)
    void dynamicTableTest(String name, String age, String country) {
        Driver.getDriver().get("https://claruswaysda.github.io/addRecordWebTable.html");
        AddRecordPage page = new AddRecordPage();


        page.enterName(name)
                .enterAge(age)
                .selectCountry(country)
                .clickOnAddRecord()
                .assertTableContainsText(name);


    }
}