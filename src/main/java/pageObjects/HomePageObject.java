package pageObjects;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pageUIs.HomePageUI;

public class HomePageObject extends BasePage {
    private WebDriver driver;

    public HomePageObject(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isHomePageDisplayed() {
        waitForElementVisible(driver, HomePageUI.WELCOME_TEXT);
        return isElementDisplayed(driver, HomePageUI.WELCOME_TEXT);
    }

    public void clickMenuItemByName(WebDriver driver, String textValue) {
        waitForElementClickable(driver, HomePageUI.ACCOUNT_SERVICES_ITEM_DYNAMIC, textValue);
        clickToElement(driver, HomePageUI.ACCOUNT_SERVICES_ITEM_DYNAMIC, textValue);
        sleepInSecond(1);
    }

    public boolean isPageDisplayedByName(WebDriver driver, String textValue) {
        waitForElementVisible(driver, HomePageUI.PAGE_TITLE_DYNAMIC, textValue);
        return isElementDisplayed(driver, HomePageUI.PAGE_TITLE_DYNAMIC, textValue);
    }
}
