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

    public void clickRegisterButton() {
        waitForElementClickable(driver, RegisterPageUI.REGISTER_BUTTON);
        clickToElement(driver, RegisterPageUI.REGISTER_BUTTON);
    }

    public boolean isAccountRegisterSuccessfully() {
        waitForElementVisible(driver, RegisterPageUI.WELCOME_HEADER);
        waitForElementVisible(driver, RegisterPageUI.ACCOUNT_CREATED_MESSAGE);
        boolean headerDisplayed = isElementDisplayed(driver, RegisterPageUI.WELCOME_HEADER);
        boolean messageDisplayed = isElementDisplayed(driver, RegisterPageUI.ACCOUNT_CREATED_MESSAGE);
        if (headerDisplayed == true && messageDisplayed == true){
            return true;
        }
        return false;
    }

    public boolean isRequiredMessageDisplayedByText(WebDriver driver, String textboxName) {
        waitForElementVisible(driver, RegisterPageUI.DYNAMIC_REQUIRED_FIELD_MESSAGE, textboxName);
        return isElementDisplayed(driver, RegisterPageUI.DYNAMIC_REQUIRED_FIELD_MESSAGE, textboxName);
    }

    public boolean isRegisterPageDisplayed() {
        waitForElementVisible(driver, RegisterPageUI.REGISTER_PAGE_TITLE);
        return isElementDisplayed(driver, RegisterPageUI.REGISTER_PAGE_TITLE);
    }

    public void clickLogoutLink() {
        waitForElementClickable(driver, RegisterPageUI.LOGOUT_HYPERLINK);
        clickToElement(driver, RegisterPageUI.LOGOUT_HYPERLINK);
    }

    public boolean isUsernameDuplicated() {
        waitForElementVisible(driver, RegisterPageUI.DUPLICATED_USER_MESSAGE);
        return isElementDisplayed(driver, RegisterPageUI.DUPLICATED_USER_MESSAGE);
    }
}
