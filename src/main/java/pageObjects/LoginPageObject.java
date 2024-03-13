package pageObjects;

import commons.BasePage;
import commons.GlobalConstants;
import commons.PageGeneratorManager;
import org.openqa.selenium.WebDriver;
import pageUIs.LoginPageUI;

public class LoginPageObject extends BasePage {
    private WebDriver driver;

    public LoginPageObject(WebDriver driver) {
        this.driver = driver;
    }

    public void clickMenuByText(WebDriver driver, String textValue){
        waitForElementClickable(driver, LoginPageUI.MENU_ITEM_DYNAMIC, textValue);
        clickToElement(driver, LoginPageUI.MENU_ITEM_DYNAMIC, textValue);
    }

    public RegisterPageObject clickRegisterLink() {
        waitForElementClickable(driver, LoginPageUI.REGISTER_LINK);
        clickToElement(driver, LoginPageUI.REGISTER_LINK);
        return PageGeneratorManager.getRegisterPage(driver);
    }

    public LoginPageObject openHomePage(){
        openPageURL(driver, GlobalConstants.USER_PAGE_URL);
        return PageGeneratorManager.getLoginPage(driver);
    }

    public void inputUserName(String userName) {
        waitForElementVisible(driver, LoginPageUI.USERNAME_TEXTBOX);
        sendkeyToElement(driver, LoginPageUI.USERNAME_TEXTBOX, userName);
    }

    public void inputPassword(String password) {
        waitForElementVisible(driver, LoginPageUI.PASSWORD_TEXTBOX);
        sendkeyToElement(driver, LoginPageUI.PASSWORD_TEXTBOX, password);
    }

    public HomePageObject clickLoginButton() {
        waitForElementClickable(driver, LoginPageUI.LOGIN_BUTTON);
        clickToElement(driver, LoginPageUI.LOGIN_BUTTON);
        return PageGeneratorManager.getHomePage(driver);
    }
}
