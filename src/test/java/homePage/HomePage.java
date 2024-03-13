package homePage;

import com.aventstack.extentreports.Status;
import commons.BaseTest;
import commons.PageGeneratorManager;
import extentReportV5.ExtentTestManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import pageObjects.HomePageObject;
import pageObjects.LoginPageObject;
import pageObjects.RegisterPageObject;
import testData.UserData;

import java.lang.reflect.Method;

public class HomePage extends BaseTest {
    private WebDriver driver;
    LoginPageObject loginPage;
    RegisterPageObject registerPage;
    HomePageObject homePage;

    @Parameters({"environmentName", "browser"})
    @BeforeClass
    public void beforeClass(@Optional("local") String environmentName, @Optional("firefox") String browserName) {
        driver = getBrowserDriverFactory(environmentName, browserName);
        loginPage = PageGeneratorManager.getLoginPage(driver);

        loginPage.inputUserName(UserData.Register.USERNAME);
        loginPage.inputPassword(UserData.Register.PASSWORD);
        homePage = loginPage.clickLoginButton();
        homePage.isHomePageDisplayed();
    }

    @AfterClass(alwaysRun = true)
    public void afterClass(){
        closeBrowserDriver();
    }

    @Test
    public void TC_01_Register_New_Account_Successfully (Method method){
        ExtentTestManager.startTest(method.getName(), "Verify Account Services items");
        ExtentTestManager.getTest().log(Status.INFO, "Step 01: Click all hyperlinks in menu items");
        homePage.clickMenuItemByName(driver, "Open New Account");
        homePage.isPageDisplayedByName(driver,"Open New Account");

        homePage.clickMenuItemByName(driver, "Accounts Overview");
        homePage.isPageDisplayedByName(driver,"Accounts Overview");

        homePage.clickMenuItemByName(driver, "Transfer Funds");
        homePage.isPageDisplayedByName(driver,"Transfer Funds");

        homePage.clickMenuItemByName(driver, "Bill Pay");
        homePage.isPageDisplayedByName(driver,"Bill Payment Service");

        homePage.clickMenuItemByName(driver, "Find Transactions");
        homePage.isPageDisplayedByName(driver,"Find Transactions");

        homePage.clickMenuItemByName(driver, "Update Contact Info");
        homePage.isPageDisplayedByName(driver,"Update Profile");

        homePage.clickMenuItemByName(driver, "Request Loan");
        homePage.isPageDisplayedByName(driver,"Apply for a Loan");
    }
}
