package pageObjects;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIs.OpenNewAccountPageUI;

public class OpenNewAccountPageObject extends BasePage {
    private WebDriver driver;

    public OpenNewAccountPageObject (WebDriver driver) {
        this.driver = driver;
    }

    public void selectAccountTypeByText(WebDriver driver, String text) {
        waitForElementVisible(driver, OpenNewAccountPageUI.ACCOUNT_TYPE_DROPDOWN);
        selectItemInDefaultDropDownByText(driver, OpenNewAccountPageUI.ACCOUNT_TYPE_DROPDOWN,text);
    }

    public void clickOpenNewAccount() {
        waitForElementClickable(driver, OpenNewAccountPageUI.OPEN_NEW_ACCOUNT_BUTTON);
        clickToElement(driver, OpenNewAccountPageUI.OPEN_NEW_ACCOUNT_BUTTON);
    }

    public boolean isNewAccountOpenDisplayed() {
        waitForElementVisible(driver, OpenNewAccountPageUI.ACCOUNT_OPENED_HEADER);
        boolean headerText = isElementDisplayed(driver, OpenNewAccountPageUI.ACCOUNT_OPENED_HEADER);
        waitForElementVisible(driver, OpenNewAccountPageUI.ACCOUNT_OPENED_BODY);
        boolean bodyText = isElementDisplayed(driver, OpenNewAccountPageUI.ACCOUNT_OPENED_BODY);
        if (headerText == true && bodyText == true)
            return true;
        return false;
    }
}
