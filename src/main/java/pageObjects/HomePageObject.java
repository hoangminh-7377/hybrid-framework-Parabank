package pageObjects;

import commons.BasePage;
import commons.GlobalConstants;
import commons.PageGeneratorManager;
import org.openqa.selenium.WebDriver;
import pageUIs.HomePageUI;

public class HomePageObject extends BasePage {
    private WebDriver driver;

    public HomePageObject(WebDriver driver) {
        this.driver = driver;
    }

    public void clickMenuByText(WebDriver driver, String textValue){
        waitForElementClickable(driver, HomePageUI.MENU_ITEM_DYNAMIC, textValue);
        clickToElement(driver, HomePageUI.MENU_ITEM_DYNAMIC, textValue);
    }

    public RegisterPageObject clickRegisterLink() {
        waitForElementClickable(driver, HomePageUI.REGISTER_LINK);
        clickToElement(driver, HomePageUI.REGISTER_LINK);
        return PageGeneratorManager.getRegisterPage(driver);
    }

    public HomePageObject openHomePage(){
        openPageURL(driver, GlobalConstants.USER_PAGE_URL);
        return PageGeneratorManager.getHomePage(driver);
    }
}
