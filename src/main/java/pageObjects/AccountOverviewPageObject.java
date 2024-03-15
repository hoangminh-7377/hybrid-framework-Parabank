package pageObjects;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pageUIs.AccountOverviewPageUI;
import pageUIs.OpenNewAccountPageUI;

import java.util.List;

public class AccountOverviewPageObject extends BasePage {
    private WebDriver driver;

    public AccountOverviewPageObject(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isAvailableAmountEqualToTotalBalace() {
        waitForElementVisible(driver, AccountOverviewPageUI.AVAILABLE_BALANCE);
        waitForElementVisible(driver, AccountOverviewPageUI.TOTAL_BALANCE);

        List< WebElement> numberElement = getListWebElement(driver, AccountOverviewPageUI.AVAILABLE_BALANCE);
        Double totalAvailableBalance = 0.0;
        Double totalBalance = Double.parseDouble(getElementText(driver, AccountOverviewPageUI.TOTAL_BALANCE).replace("$",""));

        for (WebElement element : numberElement){
            Double number = Double.parseDouble(element.getText().replace("$", ""));
            totalAvailableBalance += number;
        }
        return totalAvailableBalance.equals(totalBalance);
    }
}
