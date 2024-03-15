package userPage;

import commons.BasePage;
import commons.BaseTest;
import commons.PageGeneratorManager;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import pageObjects.HomePageObject;
import pageObjects.LoginPageObject;
import testData.UserData;

import java.util.List;


public class a extends BaseTest {


    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();;
        driver.get("https://parabank.parasoft.com/parabank/index.htm?ConnType=JDBC");
        LoginPageObject loginPage = new LoginPageObject(driver);
        loginPage.inputUserName(UserData.Register.USERNAME);
        loginPage.inputPassword(UserData.Register.PASSWORD);
        HomePageObject homePage = PageGeneratorManager.getHomePage(driver);
        homePage.clickMenuItemByName(driver, "Accounts Overview");
        List< WebElement> list = driver.findElements(By.xpath("//th[text()='Available Amount']/ancestor::thead/following-sibling::tbody//tr[1]/td"));
        int a = list.size();
        System.out.println(a);
        driver.quit();
    }
}
