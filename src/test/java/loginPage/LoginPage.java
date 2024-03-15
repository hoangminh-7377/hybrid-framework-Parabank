package loginPage;

import extentReportV5.ExtentTestManager;
import com.aventstack.extentreports.Status;
import commons.BaseTest;
import commons.PageGeneratorManager;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import pageObjects.HomePageObject;
import pageObjects.LoginPageObject;
import testData.UserData;

import java.lang.reflect.Method;

public class LoginPage extends BaseTest {
    private WebDriver driver;
    LoginPageObject loginPage;
    HomePageObject homePage;

    @Parameters({"environmentName", "browser"})
    @BeforeClass
    public void beforeClass(@Optional("local") String environmentName, @Optional("firefox") String browserName) {
        driver = getBrowserDriverFactory(environmentName, browserName);
        loginPage = PageGeneratorManager.getLoginPage(driver);
        homePage = PageGeneratorManager.getHomePage(driver);
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

    @Test
    public void TC_02_Verify_Login_Successfully (Method method) {
        ExtentTestManager.startTest(method.getName(), "Verify login successfully");
        ExtentTestManager.getTest().log(Status.INFO, "Step 01: Input account");
        loginPage.inputUserName(UserData.Register.USERNAME);
        loginPage.inputPassword(UserData.Register.PASSWORD);

        ExtentTestManager.getTest().log(Status.INFO, "Step 02: Click Login button");
        homePage = loginPage.clickLoginButton();

        ExtentTestManager.getTest().log(Status.INFO, "Step 02: Verify login successfully");
        Assert.assertTrue(homePage.isHomePageDisplayed());
    }

}
