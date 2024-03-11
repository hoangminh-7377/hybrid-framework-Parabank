package commons;

import org.openqa.selenium.WebDriver;
import pageObjects.*;

public class PageGeneratorManager {

    public static PageGeneratorManager getPageGenerator() {
        return new PageGeneratorManager();
    }

    public static HomePageObject getHomePage(WebDriver driver){
        return new HomePageObject(driver);
    }

    public static RegisterPageObject getRegisterPage(WebDriver driver){
        return new RegisterPageObject(driver);
    }
}
