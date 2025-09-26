package tests;

import com.github.javafaker.Faker;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;
import utilities.Driver;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class C02_BankingApp {

    @Test
    public void bankAppTest() throws InterruptedException {
        Driver.getDriver().get("https://www.globalsqa.com/angularJs-protractor/BankingProject/#/login");

        ManagerLoginPage managerLoginPage = new ManagerLoginPage();
        CustomerManagementPage customerPage = new CustomerManagementPage();
        AccountManagementPage accountPage = new AccountManagementPage();
        CustomerLoginPage customerLoginPage = new CustomerLoginPage();
        TransactionPage transactionPage = new TransactionPage();
        List<String> customerNames = new ArrayList<>();
        Faker faker = new Faker();


        managerLoginPage.managerLogin.click();
        customerPage.addCustomer.click();
        // Create 5 new customers
        for (int i = 0; i < 5; i++) {

            String first = faker.name().firstName();
            String last = faker.name().lastName();
            customerPage.firstName.sendKeys(first);
            customerPage.lastName.sendKeys(last);
            customerPage.postCode.sendKeys("12345");
            customerPage.submitCustomer.click();

            try {
                WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));
                wait.until(ExpectedConditions.alertIsPresent());
                Driver.getDriver().switchTo().alert().accept();
            } catch (Exception e) {
                System.out.println("Alert not found or already handled: on step 1" + e.getMessage());
            }
            customerNames.add(first + " " + last);
        }



        // Open accounts for customers
        accountPage.openAccount.click();
        for (String customer : customerNames) {
            accountPage.selectCustomer(customer);
            accountPage.selectCurrency("Dollar");
            accountPage.process.click();
            try {
                WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));
                wait.until(ExpectedConditions.alertIsPresent());
                Driver.getDriver().switchTo().alert().accept();
            } catch (Exception e) {
                System.out.println("Alert not found or already handled: on step 2 " + e.getMessage());
            }

        }



        // Deposit 100 USD to each account
        for (String customer : customerNames) {
            managerLoginPage.Home.click();
customerLoginPage.customerLogin.click();
            customerLoginPage.selectCustomer(customer);
            customerLoginPage.login.click();

            transactionPage.deposit.click();
            transactionPage.amount.sendKeys("100");
            transactionPage.depositClick.click();

            // Assert deposit message
            Assert.assertEquals(transactionPage.successMessage.getText().trim(), "Deposit Successful");
transactionPage.logout.click();


  }

     // Withdraw 100 USD from the first account
        customerLoginPage.selectCustomer(customerNames.getFirst());
        customerLoginPage.login.click();
        transactionPage.withdraw.click();
        transactionPage.amount.sendKeys("100");
        transactionPage.withdrawClick.click();
        Assert.assertEquals(transactionPage.successMessage.getText(), "Transaction successful");
//
//Delete all customers
        transactionPage.logout.click();
        managerLoginPage.Home.click();
        managerLoginPage.managerLogin.click();
        customerPage.showCustomers.click();
        for (String customer : customerNames) {
            customerPage.byebye.click();
        }

        Driver.closeDriver();
    }
}
