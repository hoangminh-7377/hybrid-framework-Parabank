package registerPage;

import commons.DataHelper;
import extentReportV5.ExtentTestManager;
import com.aventstack.extentreports.Status;
import commons.BaseTest;
import commons.PageGeneratorManager;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import pageObjects.LoginPageObject;
import pageObjects.RegisterPageObject;
import testData.UserData;

import java.lang.reflect.Method;

public class RegisterPage extends BaseTest {
    private WebDriver driver;
    LoginPageObject loginPage;
    RegisterPageObject registerPage;
    DataHelper dataHelper;
    String firstName, lastName, Address, City, State, Zipcode, Phone, SSN, Username, Password;

    @Parameters({"environmentName", "browser"})
    @BeforeClass
    public void beforeClass(@Optional("local") String environmentName, @Optional("chrome") String browserName) {
        driver = getBrowserDriverFactory(environmentName, browserName);
        loginPage = PageGeneratorManager.getLoginPage(driver);
        registerPage = PageGeneratorManager.getRegisterPage(driver);
        dataHelper = DataHelper.getDataHelper();

        firstName = dataHelper.getFirstName();
        lastName = dataHelper.getLastName();
        Address = dataHelper.getAddress();
        City = dataHelper.getCity();
        State = dataHelper.getState();
        Zipcode = dataHelper.getZipcode();
        Phone = dataHelper.getPhoneNumber();
        SSN = dataHelper.getSSN()+ firstName + "." + lastName;
        Username = dataHelper.getUserName();
        Password = dataHelper.getPassword();
    }

    @AfterClass(alwaysRun = true)
    public void afterClass(){
        closeBrowserDriver();
    }

    @Test
    public void TC_01_Verify_Required_Field_Message (Method method) {
        ExtentTestManager.startTest(method.getName(), "Verify register account successfully");
        ExtentTestManager.getTest().log(Status.INFO, "Step 01: Click register hyperlink");
        registerPage = loginPage.clickRegisterLink();
        Assert.assertTrue(registerPage.isRegisterPageDisplayed());

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

    @Test
    public void TC_02_Register_New_Account_Successfully (Method method){
        ExtentTestManager.startTest(method.getName(), "Verify register account successfully. Due to database clean mechanics after X hours, this test case may fail at step 04");
        ExtentTestManager.getTest().log(Status.INFO, "Step 01: Click register hyperlink");
        registerPage = loginPage.clickRegisterLink();
        Assert.assertTrue(registerPage.isRegisterPageDisplayed());

        ExtentTestManager.getTest().log(Status.INFO, "Step 02: Input information to register form");
        registerPage.inputToTextboxByTextboxName(driver, "First Name", UserData.Register.FIRSTNAME);
        registerPage.inputToTextboxByTextboxName(driver, "Last Name",  UserData.Register.LASTNAME);
        registerPage.inputToTextboxByTextboxName(driver, "Address",  UserData.Register.ADDRESS);
        registerPage.inputToTextboxByTextboxName(driver, "City",  UserData.Register.CITY);
        registerPage.inputToTextboxByTextboxName(driver, "State",  UserData.Register.STATE);
        registerPage.inputToTextboxByTextboxName(driver, "Zip Code",  UserData.Register.ZIPCODE);
        registerPage.inputToTextboxByTextboxName(driver, "Phone ",  UserData.Register.PHONE);
        registerPage.inputToTextboxByTextboxName(driver, "SSN",  UserData.Register.SSN);
        registerPage.inputToTextboxByTextboxName(driver, "Username",  UserData.Register.USERNAME);
        registerPage.inputToTextboxByTextboxName(driver, "Password",  UserData.Register.PASSWORD);
        registerPage.inputToTextboxByTextboxName(driver, "Confirm",  UserData.Register.PASSWORD);

        ExtentTestManager.getTest().log(Status.INFO, "Register - Step 03: Click Register button");
        registerPage.clickRegisterButton();

        ExtentTestManager.getTest().log(Status.INFO, "Register - Step 04: Verify account registration successfully");
        //registerPage.isUsernameDuplicated();
        Assert.assertTrue(registerPage.isAccountRegisterSuccessfully());
    }


    public void TC_03_Register_New_Random_Account_Successfully (Method method) {
        ExtentTestManager.startTest(method.getName(), "Verify register account with duplicate email");
        ExtentTestManager.getTest().log(Status.INFO, "Step 01: Open Home Page");
        loginPage.openHomePage();

        ExtentTestManager.getTest().log(Status.INFO, "Step 02: Click register hyperlink");
        registerPage = loginPage.clickRegisterLink();
        Assert.assertTrue(registerPage.isRegisterPageDisplayed());

        ExtentTestManager.getTest().log(Status.INFO, "Step 03: Input information to register form");
        registerPage.inputToTextboxByTextboxName(driver, "First Name", firstName);
        registerPage.inputToTextboxByTextboxName(driver, "Last Name", lastName);
        registerPage.inputToTextboxByTextboxName(driver, "Address", Address);
        registerPage.inputToTextboxByTextboxName(driver, "City", City);
        registerPage.inputToTextboxByTextboxName(driver, "State", State);
        registerPage.inputToTextboxByTextboxName(driver, "Zip Code", Zipcode);
        registerPage.inputToTextboxByTextboxName(driver, "Phone ", Phone);
        registerPage.inputToTextboxByTextboxName(driver, "SSN", SSN);
        registerPage.inputToTextboxByTextboxName(driver, "Username", Username);
        registerPage.inputToTextboxByTextboxName(driver, "Password", Password);
        registerPage.inputToTextboxByTextboxName(driver, "Confirm", Password);
        registerPage.clickRegisterButton();

        ExtentTestManager.getTest().log(Status.INFO, "Register - Step 04: Verify account registration successfully");
        Assert.assertTrue(registerPage.isAccountRegisterSuccessfully());
    }
}
