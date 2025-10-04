package utilities;

import com.github.javafaker.Faker;
import org.testng.annotations.DataProvider;

public class DataProviderUtilities {

    @DataProvider
    public Object[][] getRecords() {
        return new Object[][]{
                {"johndoe", "123", "Comments from John", "Drop Down Item 6"},
                {"marystar", "767", "Comments from Mary", "Drop Down Item 2"},
                {"tomhawk", "889", "Comments from Tom", "Drop Down Item 1"},
                {"timlee", "098", "Comments from Tim", "Drop Down Item 5"},
                {"kenjoe", "567", "Comments from Ken", "Drop Down Item 4"},
        };
    }
    @DataProvider(name = "recordData")
    public Object[][] recordData() {
        return new Object[][]{
                {"Alice", "25", "USA"},
                {"Bob", "30", "Germany"},
                {"Charlie", "40", "Canada"}
        };
    }
//    @DataProvider(name = "searchTerms", parallel = true)  // enable parallel execution
//    public static Object[][] getSearchTerms() {
//        return new Object[][]{
//                {"Selenium"},
//                {"Java"},
//                {"TestNG"},
//                {"Automation"},
//                {"WebDriver"}
//        };
//    }

    @DataProvider(name = "searchTerms", parallel = true)
    public Object[][] getSearchTerms() {
        return new Object[][] {
                { "dress" },
                { "top" },
                { "jeans" },
                { "tshirt" },
                { "saree" }
        };
    }

    @DataProvider(name = "faker")
    public Object[][] getFakeRecords() {
        Faker faker = new Faker();
        return new Object[][]{
                {faker.name().username(), faker.internet().password(), faker.lorem().paragraph(3), "Drop Down Item " + faker.number().numberBetween(1, 7)},
                {faker.name().username(), faker.internet().password(), faker.lorem().paragraph(3), "Drop Down Item " + faker.number().numberBetween(1, 7)},
                {faker.name().username(), faker.internet().password(), faker.lorem().paragraph(3), "Drop Down Item " + faker.number().numberBetween(1, 7)},
                {faker.name().username(), faker.internet().password(), faker.lorem().paragraph(3), "Drop Down Item " + faker.number().numberBetween(1, 7)},
                {faker.name().username(), faker.internet().password(), faker.lorem().paragraph(3), "Drop Down Item " + faker.number().numberBetween(1, 7)},
                {faker.name().username(), faker.internet().password(), faker.lorem().paragraph(3), "Drop Down Item " + faker.number().numberBetween(1, 7)},
                {faker.name().username(), faker.internet().password(), faker.lorem().paragraph(3), "Drop Down Item " + faker.number().numberBetween(1, 7)},
                {faker.name().username(), faker.internet().password(), faker.lorem().paragraph(3), "Drop Down Item " + faker.number().numberBetween(1, 7)},
                {faker.name().username(), faker.internet().password(), faker.lorem().paragraph(3), "Drop Down Item " + faker.number().numberBetween(1, 7)},
                {faker.name().username(), faker.internet().password(), faker.lorem().paragraph(3), "Drop Down Item " + faker.number().numberBetween(1, 7)},
                {faker.name().username(), faker.internet().password(), faker.lorem().paragraph(3), "Drop Down Item " + faker.number().numberBetween(1, 7)},
                {faker.name().username(), faker.internet().password(), faker.lorem().paragraph(3), "Drop Down Item " + faker.number().numberBetween(1, 7)}
        };
    }


//    @DataProvider(name = "excelDP")
//    public Object[][] getUserDataFromExcel() {
//        ExcelUtilities eu = new ExcelUtilities("Users.xlsx", "UserData");
//        return eu.getExcelDataAsArray();
//    }
//
//    @DataProvider
//    public Object[][] getEmployeeDataFromExcel() {
//        ExcelUtilities eu = new ExcelUtilities("Users.xlsx", "Employees");
//        return eu.getExcelDataAsArray();
//    }




}