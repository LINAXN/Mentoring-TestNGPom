package tests;

import org.openqa.selenium.By;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.CLRegistrationPage;
import utilities.Driver;
@Listeners (utilities.MyTestListener.class)
public class C08_CLRegistration {
@Test
    void  registrationTest01(){
    Driver.getDriver().get("https://thinking-tester-contact-list.herokuapp.com/addUser");
    CLRegistrationPage Register = new CLRegistrationPage();
    Register
            .enterfirstName("John")
            .enterlastName("Doe")
            .enteremail("admin@admin.com")
            .enterlpassword("Johndoes.1234")
            .entersingin();

    }

    @Test
    void  registrationTest03(){
        Driver.getDriver().get("https://thinking-tester-contact-list.herokuapp.com/addUser");
        CLRegistrationPage Register = new CLRegistrationPage();
        Register
                .enterfirstName("")
                .enterlastName("Doe")
                .enteremail("admin@admin.com")
                .enterlpassword("Johndoes.1234")
                .entersingin();

    }
    @Test
    void  registrationTest04(){
        Driver.getDriver().get("https://thinking-tester-contact-list.herokuapp.com/addUser");
        CLRegistrationPage Register = new CLRegistrationPage();
        Register
                .enterfirstName("j@ohn")
                .enterlastName("Doe")
                .enteremail("admin@admin.com")
                .enterlpassword("Johndoes.1234")
                .entersingin();

    }
    @Test
    void  registrationTest05(){
        Driver.getDriver().get("https://thinking-tester-contact-list.herokuapp.com/addUser");
        CLRegistrationPage Register = new CLRegistrationPage();
        Register
                .enterfirstName("John123")
                .enterlastName("Doe")
                .enteremail("admin@admin.com")
                .enterlpassword("Johndoes.1234")
                .entersingin();

    }
    @Test
    void  registrationTest06(){
        Driver.getDriver().get("https://thinking-tester-contact-list.herokuapp.com/addUser");
        CLRegistrationPage Register = new CLRegistrationPage();
        Register
                .enterfirstName("John")
                .enterlastName("")
                .enteremail("admin@admin.com")
                .enterlpassword("Johndoes.1234")
                .entersingin();

    }
    @Test
    void  registrationTest07(){
        Driver.getDriver().get("https://thinking-tester-contact-list.herokuapp.com/addUser");
        CLRegistrationPage Register = new CLRegistrationPage();
        Register
                .enterfirstName("John")
                .enterlastName("D@oe")
                .enteremail("admin@admin.com")
                .enterlpassword("Johndoes.1234")
                .entersingin();

    }
    @Test
    void  registrationTest08(){
        Driver.getDriver().get("https://thinking-tester-contact-list.herokuapp.com/addUser");
        CLRegistrationPage Register = new CLRegistrationPage();
        Register
                .enterfirstName("john")
                .enterlastName("Doe123")
                .enteremail("admin@admin.com")
                .enterlpassword("johndoes.1234")
                .entersingin();

    }
    @Test
    public void tearDown() {
        Driver.closeDriver();
    }
}
