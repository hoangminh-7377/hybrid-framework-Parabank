package RegisterPage;

import ExtentReportV5.ExtentTestManager;
import com.aventstack.extentreports.Status;
import commons.BasePage;
import commons.BaseTest;
import commons.GlobalConstants;
import commons.PageGeneratorManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import pageObjects.HomePageObject;
import pageObjects.RegisterPageObject;

import java.lang.reflect.Method;

public class RegisterPage extends BaseTest {
    private WebDriver driver;
    HomePageObject homePage;
    RegisterPageObject registerPage;

    @Parameters({"environmentName", "browser"})
    @BeforeClass
    public void beforeClass(@Optional("local") String environmentName, @Optional("chrome") String browserName) {
        driver = getBrowserDriverFactory(environmentName, browserName);
        homePage = PageGeneratorManager.getHomePage(driver);
        registerPage = PageGeneratorManager.getRegisterPage(driver);
    }

    @AfterClass(alwaysRun = true)
    public void afterClass(){
        closeBrowserDriver();
    }

    @Test
    public void TC_01_Register_New_Account_Successfully (Method method){
        ExtentTestManager.startTest(method.getName(), "Verify register account successfully");
        ExtentTestManager.getTest().log(Status.INFO, "Step 01: Click register hyperlink");
        registerPage = homePage.clickRegisterLink();
        registerPage.isRegisterPageDisplayed();

        ExtentTestManager.getTest().log(Status.INFO, "Step 02: Input information to register form");
        registerPage.inputToTextboxByTextboxName(driver, "First Name",GlobalConstants.firstName);
        registerPage.inputToTextboxByTextboxName(driver, "Last Name", GlobalConstants.lastName);
        registerPage.inputToTextboxByTextboxName(driver, "Address", GlobalConstants.Address);
        registerPage.inputToTextboxByTextboxName(driver, "City", GlobalConstants.City);
        registerPage.inputToTextboxByTextboxName(driver, "State", GlobalConstants.State);
        registerPage.inputToTextboxByTextboxName(driver, "Zip Code", GlobalConstants.Zipcode);
        registerPage.inputToTextboxByTextboxName(driver, "Phone ", GlobalConstants.Phone);
        registerPage.inputToTextboxByTextboxName(driver, "SSN", GlobalConstants.SSN);
        registerPage.inputToTextboxByTextboxName(driver, "Username", GlobalConstants.Username);
        registerPage.inputToTextboxByTextboxName(driver, "Password", GlobalConstants.Password);
        registerPage.inputToTextboxByTextboxName(driver, "Confirm", GlobalConstants.confirmPassword);

        ExtentTestManager.getTest().log(Status.INFO, "Register - Step 03: Click Register button");
        registerPage.clickRegisterButton();

        ExtentTestManager.getTest().log(Status.INFO, "Register - Step 04: Verify account registration successfully");
        registerPage.isAccountRegisterSuccessfully();
    }

    @Test
    public void TC_02_Verify_Required_Field_Message (Method method) {
        ExtentTestManager.startTest(method.getName(), "Verify register account successfully");
        ExtentTestManager.getTest().log(Status.INFO, "Step 01: Click register hyperlink");
        homePage.openHomePage();
        registerPage = homePage.clickRegisterLink();
        registerPage.isRegisterPageDisplayed();

        ExtentTestManager.getTest().log(Status.INFO, "Step 02: Click register hyperlink when there's no data in textboxes");
        registerPage.clickRegisterButton();

        ExtentTestManager.getTest().log(Status.INFO, "Step 03: Verify required message");
        registerPage.isRequiredMessageDisplayedByText(driver, "First name");
        registerPage.isRequiredMessageDisplayedByText(driver, "Last name");
        registerPage.isRequiredMessageDisplayedByText(driver, "Address");
        registerPage.isRequiredMessageDisplayedByText(driver, "City");
        registerPage.isRequiredMessageDisplayedByText(driver, "State");
        registerPage.isRequiredMessageDisplayedByText(driver, "Zip Code");
        registerPage.isRequiredMessageDisplayedByText(driver, "Social Security Number");
        registerPage.isRequiredMessageDisplayedByText(driver, "Username");
        registerPage.isRequiredMessageDisplayedByText(driver, "Password");
        registerPage.isRequiredMessageDisplayedByText(driver, "Password confirmation");
    }
}
