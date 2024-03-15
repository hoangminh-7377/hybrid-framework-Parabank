package userPage;

import com.aventstack.extentreports.Status;
import commons.BaseTest;
import commons.PageGeneratorManager;
import extentReportV5.ExtentTestManager;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import pageObjects.AccountOverviewPageObject;
import pageObjects.HomePageObject;
import pageObjects.LoginPageObject;
import testData.UserData;

import java.lang.reflect.Method;

public class AccountOverviewPage extends BaseTest {
    private WebDriver driver;
    LoginPageObject loginPage;
    HomePageObject homePage;
    AccountOverviewPageObject accountOverviewPage;

    @Parameters({"environmentName", "browser"})
    @BeforeClass
    public void beforeClass(@Optional("local") String environmentName, @Optional("firefox") String browserName) {
        driver = getBrowserDriverFactory(environmentName, browserName);
        loginPage = PageGeneratorManager.getLoginPage(driver);
        accountOverviewPage = PageGeneratorManager.getAccountOverviewPage(driver);

        loginPage.inputUserName(UserData.Register.USERNAME);
        loginPage.inputPassword(UserData.Register.PASSWORD);
        homePage = loginPage.clickLoginButton();
        Assert.assertTrue(homePage.isHomePageDisplayed());
    }

    @AfterClass(alwaysRun = true)
    public void afterClass(){
        closeBrowserDriver();
    }

    @Test
    public void TC_01_View_Account_Overview(Method method) {
        ExtentTestManager.startTest(method.getName(), "Verify Account Services items");
        ExtentTestManager.getTest().log(Status.INFO, "Step 01: Open Open New Account page");
        homePage.clickMenuItemByName(driver, "Accounts Overview");
        Assert.assertTrue(homePage.isPageDisplayedByName(driver,"Accounts Overview"));

        ExtentTestManager.getTest().log(Status.INFO, "Step 02: Verify account balance and total balance");
        Assert.assertTrue(accountOverviewPage.isAvailableAmountEqualToTotalBalace());
    }
}
