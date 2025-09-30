package tests.smoke_test;

import org.testng.annotations.Test;
import pages.ActionsFormPage;
import utilities.Driver;

public class T03_ActionsForm {
    /*
        Go to https://claruswaysda.github.io/ActionsForm.html
        Fill form and submit
        Do all actions and assert
    */

    @Test
    void C03_ActionsFormTest() {
        ActionsFormPage formPage = new ActionsFormPage();

//        Go to https://claruswaysda.github.io/ActionsForm.html
        Driver.getDriver().get("https://claruswaysda.github.io/ActionsForm.html");

//        Fill form and submit
        formPage
                .enterName("John")
                .enterAge("30")
                .selectDepartment("IT Department")
                .clickCoding()
                .clickMale()
                .clickGenerate()
                .handleJSAlertPasscode()
                .clickSubmit();

//        Do all actions and assert


        Driver.closeDriver();

    }
}
