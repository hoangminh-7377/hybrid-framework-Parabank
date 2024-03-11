package RegisterPage;

import commons.BaseTest;
import commons.PageGeneratorManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import pageObjects.HomePageObject;

public class Template extends BaseTest {
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
}
