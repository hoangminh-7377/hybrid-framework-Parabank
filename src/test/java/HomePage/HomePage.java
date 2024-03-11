package HomePage;

import ExtentReportV5.ExtentTestManager;
import com.aventstack.extentreports.Status;
import commons.BaseTest;
import commons.PageGeneratorManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import pageObjects.HomePageObject;

import java.lang.reflect.Method;

public class HomePage extends BaseTest {
    private WebDriver driver;
    HomePageObject homePageObject;

    @Parameters({"environmentName", "browser"})
    @BeforeClass
    public void beforeClass(@Optional("local") String environmentName, @Optional("firefox") String browserName) {
        driver = getBrowserDriverFactory(environmentName, browserName);
        homePageObject = PageGeneratorManager.getHomePage(driver);
    }

    @AfterClass(alwaysRun = true)
    public void afterClass(){
        closeBrowserDriver();
    }

    @Test
    public void TC_01_Verify_Menu_Items (Method method) {
        ExtentTestManager.startTest(method.getName(), "Verify menu items navigate successfully");
        ExtentTestManager.getTest().log(Status.INFO, "Register - Step 01: Click all menu items");
        homePageObject.clickMenuByText(driver, "About Us");
        homePageObject.backToPage(driver);

        homePageObject.clickMenuByText(driver, "Services");
        homePageObject.backToPage(driver);

        homePageObject.clickMenuByText(driver, "Products");
        homePageObject.backToPage(driver);

        homePageObject.clickMenuByText(driver, "Locations");
        homePageObject.backToPage(driver);

        homePageObject.clickMenuByText(driver, "Admin Page");
        homePageObject.backToPage(driver);
    }
}
