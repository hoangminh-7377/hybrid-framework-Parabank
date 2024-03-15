package commons;

import org.openqa.selenium.WebDriver;
import pageObjects.*;

public class PageGeneratorManager {

    public static PageGeneratorManager getPageGenerator() {
        return new PageGeneratorManager();
    }

    public static LoginPageObject getLoginPage(WebDriver driver){
        return new LoginPageObject(driver);
    }

    public static RegisterPageObject getRegisterPage(WebDriver driver){
        return new RegisterPageObject(driver);
    }

    public static HomePageObject getHomePage (WebDriver driver){
        return new HomePageObject(driver);
    }

    public static OpenNewAccountPageObject getOpenNewAccountPage (WebDriver driver){
        return new OpenNewAccountPageObject(driver);
    }
    public static AccountOverviewPageObject getAccountOverviewPage (WebDriver driver){
        return new AccountOverviewPageObject(driver);
    }
}
