package pageObjects;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIs.HomePageUI;
import pageUIs.RegisterPageUI;

public class RegisterPageObject extends BasePage {
    private WebDriver driver;

    public RegisterPageObject(WebDriver driver) {
        this.driver = driver;
    }

    public void clickMenuByText(WebDriver driver, String textValue){
        waitForElementClickable(driver, HomePageUI.MENU_ITEM_DYNAMIC, textValue);
        clickToElement(driver, HomePageUI.MENU_ITEM_DYNAMIC, textValue);
    }

    public void inputToTextboxByTextboxName(WebDriver driver, String textboxName, String inputValue) {
        waitForElementVisible(driver, RegisterPageUI.TEXTBOX_DYNAMIC, textboxName);
        sendkeyToElement(driver, RegisterPageUI.TEXTBOX_DYNAMIC, inputValue, textboxName);
    }
}
