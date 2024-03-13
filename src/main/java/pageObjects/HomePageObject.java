package pageObjects;

import commons.BasePage;
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

}
