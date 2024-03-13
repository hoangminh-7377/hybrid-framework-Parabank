package loginPage;

import extentReportV5.ExtentTestManager;
import com.aventstack.extentreports.Status;
import commons.BaseTest;
import commons.PageGeneratorManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import pageObjects.LoginPageObject;

import java.lang.reflect.Method;

public class LoginPage extends BaseTest {
    private WebDriver driver;
    LoginPageObject loginPage;

    @Parameters({"environmentName", "browser"})
    @BeforeClass
    public void beforeClass(@Optional("local") String environmentName, @Optional("firefox") String browserName) {
        driver = getBrowserDriverFactory(environmentName, browserName);
        loginPage = PageGeneratorManager.getLoginPage(driver);
    }

    @AfterClass(alwaysRun = true)
    public void afterClass(){
        closeBrowserDriver();
    }

    @Test
    public void TC_01_Verify_Menu_Items (Method method) {
        ExtentTestManager.startTest(method.getName(), "Verify menu items navigate successfully");
        ExtentTestManager.getTest().log(Status.INFO, "Step 01: Click all menu items");
        loginPage.clickMenuByText(driver, "About Us");
        loginPage.backToPage(driver);

        loginPage.clickMenuByText(driver, "Services");
        loginPage.backToPage(driver);

        loginPage.clickMenuByText(driver, "Products");
        loginPage.backToPage(driver);

        loginPage.clickMenuByText(driver, "Locations");
        loginPage.backToPage(driver);

        loginPage.clickMenuByText(driver, "Admin Page");
        loginPage.backToPage(driver);
    }
}
