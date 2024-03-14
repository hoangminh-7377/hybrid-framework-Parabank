package userPage;

import com.aventstack.extentreports.Status;
import commons.BaseTest;
import commons.PageGeneratorManager;
import extentReportV5.ExtentTestManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import pageObjects.HomePageObject;
import pageObjects.LoginPageObject;
import pageObjects.OpenNewAccountPageObject;
import testData.UserData;

import java.lang.reflect.Method;

public class OpenNewAccountPage extends BaseTest {
    private WebDriver driver;
    LoginPageObject loginPage;
    HomePageObject homePage;
    OpenNewAccountPageObject openNewAccountPage;

    @Parameters({"environmentName", "browser"})
    @BeforeClass
    public void beforeClass(@Optional("local") String environmentName, @Optional("firefox") String browserName) {
        driver = getBrowserDriverFactory(environmentName, browserName);
        loginPage = PageGeneratorManager.getLoginPage(driver);
        openNewAccountPage = PageGeneratorManager.getOpenNewAccountPage(driver);

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
    public void TC_01_Open_Checking_Account (Method method) {
        ExtentTestManager.startTest(method.getName(), "Verify Account Services items");
        ExtentTestManager.getTest().log(Status.INFO, "Step 01: Open Open New Account page");
        homePage.clickMenuItemByName(driver, "Open New Account");
        homePage.isPageDisplayedByName(driver, "Open New Account");

        ExtentTestManager.getTest().log(Status.INFO, "Step 02: Select CHECKING account");
        openNewAccountPage.selectAccountTypeByText(driver, "CHECKING");

        ExtentTestManager.getTest().log(Status.INFO, "Step 03: Click Open New Account button");
        openNewAccountPage.clickOpenNewAccount();

        ExtentTestManager.getTest().log(Status.INFO, "Step 04: Verify open new account successfully");
        openNewAccountPage.isNewAccountOpenDisplayed();
    }

    @Test
    public void TC_02_Open_Saving_Account (Method method) {
        ExtentTestManager.startTest(method.getName(), "Verify Account Services items");
        ExtentTestManager.getTest().log(Status.INFO, "Step 01: Open Open New Account page");
        homePage.clickMenuItemByName(driver, "Open New Account");
        homePage.isPageDisplayedByName(driver, "Open New Account");

        ExtentTestManager.getTest().log(Status.INFO, "Step 02: Select CHECKING account");
        openNewAccountPage.selectAccountTypeByText(driver, "SAVINGS");

        ExtentTestManager.getTest().log(Status.INFO, "Step 03: Click Open New Account button");
        openNewAccountPage.clickOpenNewAccount();

        ExtentTestManager.getTest().log(Status.INFO, "Step 04: Verify open new account successfully");
        openNewAccountPage.isNewAccountOpenDisplayed();
    }
}
