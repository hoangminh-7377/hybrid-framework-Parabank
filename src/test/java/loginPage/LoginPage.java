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
    LoginPageObject loginPageObject;

    @Parameters({"environmentName", "browser"})
    @BeforeClass
    public void beforeClass(@Optional("local") String environmentName, @Optional("firefox") String browserName) {
        driver = getBrowserDriverFactory(environmentName, browserName);
        loginPageObject = PageGeneratorManager.getLoginPage(driver);
    }

    @AfterClass(alwaysRun = true)
    public void afterClass(){
        closeBrowserDriver();
    }

    @Test
    public void TC_01_Verify_Menu_Items (Method method) {
        ExtentTestManager.startTest(method.getName(), "Verify menu items navigate successfully");
        ExtentTestManager.getTest().log(Status.INFO, "Step 01: Click all menu items");
        loginPageObject.clickMenuByText(driver, "About Us");
        loginPageObject.backToPage(driver);

        loginPageObject.clickMenuByText(driver, "Services");
        loginPageObject.backToPage(driver);

        loginPageObject.clickMenuByText(driver, "Products");
        loginPageObject.backToPage(driver);

        loginPageObject.clickMenuByText(driver, "Locations");
        loginPageObject.backToPage(driver);

        loginPageObject.clickMenuByText(driver, "Admin Page");
        loginPageObject.backToPage(driver);
    }
}
