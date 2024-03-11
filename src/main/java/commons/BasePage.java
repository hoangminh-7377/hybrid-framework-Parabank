package commons;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class BasePage {
    WebDriver driver;
    private long longTimeout = GlobalConstants.LONG_TIMEOUT;
    private long shortTimeout = GlobalConstants.SHORT_TIMEOUT;

    public static BasePage getBasePage() {
        return new BasePage();
    }

    public void openPageURL (WebDriver driver, String url){
        driver.get(url);
    }

    protected String getPageTitle(WebDriver driver){
        return driver.getTitle();
    }

    protected String getPageUrl(WebDriver driver) {
        return driver.getCurrentUrl();
    }

    public void backToPage(WebDriver driver) {
        driver.navigate().back();
    }

    protected void forwardToPage(WebDriver driver) {
        driver.navigate().forward();
    }

    public void refreshCurrentPage(WebDriver driver) {
        driver.navigate().refresh();
    }

    protected Alert waitForAlertPresence(WebDriver driver) {
        WebDriverWait explicitWait = new WebDriverWait(driver, Duration.ofSeconds(longTimeout));
        return explicitWait.until(ExpectedConditions.alertIsPresent());
    }

    private By getByLocator (String locatorType){
        By by = null;
        if (locatorType.startsWith("xpath=") || locatorType.startsWith("XPATH=") || locatorType.startsWith("Xpath=")) {
            by = By.xpath(locatorType.substring(6));
        }
        else if (locatorType.startsWith("class=") ||locatorType.startsWith("CLASS=")  || locatorType.startsWith("Class=")  ){
            by = By.className(locatorType.substring(6));
        }
        else if (locatorType.startsWith("name=") || locatorType.startsWith("NAME=") ||locatorType.startsWith("Name=")){
            by = By.name(locatorType.substring(5));
        }
        else if (locatorType.startsWith("css=") || locatorType.startsWith("CSS=") || locatorType.startsWith("Css=")){
            by = By.cssSelector(locatorType.substring(4));
            System.out.println(by);
        }
        else if (locatorType.startsWith("id=") || locatorType.startsWith("ID=") || locatorType.startsWith("Id=")){
            by = By.id(locatorType.substring(3));
        }
        else throw new RuntimeException("Locator is not supported");
        return by;
    }

    protected WebElement getWebElement(WebDriver driver, String locatorType) {
        return driver.findElement(getByLocator(locatorType));
    }

    public List<WebElement> getListWebElement(WebDriver driver, String locatorType) {
        return driver.findElements(getByLocator(locatorType));
    }

    protected void clickToElement(WebDriver driver, String locatorType) {
        getWebElement(driver, locatorType).click();
    }

    protected void sendkeyToElement(WebDriver driver, String locatorType, String textValue) {
        WebElement element = getWebElement(driver, locatorType);
        element.clear();
        element.sendKeys(textValue);
    }

    protected void sendkeyToElement(WebDriver driver, String locatorType, String textValue, String... dynamicValues) {
        WebElement element = getWebElement(driver,getDynamicXpath(locatorType, dynamicValues));
        element.clear();
        element.sendKeys(textValue);
    }

    protected String getElementText(WebDriver driver, String locatorType) {
        return getWebElement(driver, locatorType).getText();
    }

    protected void selectItemInDefaultDropDownByText(WebDriver driver, String locatorType, String textItem) {
        Select select = new Select(getWebElement(driver, locatorType));
        select.selectByVisibleText(textItem);
    }

    protected String getFirstSelectedItemDefaultDropdown(WebDriver driver, String locatorType) {
        Select select = new Select(getWebElement(driver, locatorType));
        return select.getFirstSelectedOption().getText();
    }

    protected boolean isDropdownMultiple(WebDriver driver, String locatorType) {
        Select select = new Select(getWebElement(driver, locatorType));
        return select.isMultiple();
    }

    public void sleepInSecond(long time) {
        try {
            Thread.sleep(time * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    protected void scrollToElement(WebDriver driver, String locator) {
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("arguments[0].scrollIntoView(true);", getWebElement(driver, locator));
    }

    protected void waitForElementVisible(WebDriver driver, String locatorType) {
        WebDriverWait explicitWait = new WebDriverWait(driver, Duration.ofSeconds(longTimeout));
        explicitWait.until(ExpectedConditions.visibilityOfElementLocated(getByLocator(locatorType)));
    }

    protected void waitForAllElementVisible(WebDriver driver, String locatorType) {
        WebDriverWait explicitWait = new WebDriverWait(driver, Duration.ofSeconds(longTimeout));
        explicitWait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(getByLocator(locatorType)));
    }

    protected void waitForElementClickable(WebDriver driver, String locatorType) {
        WebDriverWait explicitWait = new WebDriverWait(driver, Duration.ofSeconds(longTimeout));
        explicitWait.until(ExpectedConditions.elementToBeClickable(getByLocator(locatorType)));
    }
    protected void waitForElementClickable(WebDriver driver, String locatorType, String... dynamicValues) {
        WebDriverWait explicitWait = new WebDriverWait(driver, Duration.ofSeconds(longTimeout));
        explicitWait.until(ExpectedConditions.elementToBeClickable(getByLocator(getDynamicXpath(locatorType, dynamicValues))));
    }

    protected boolean isElementDisplayed(WebDriver driver, String locatorType) {
        return getWebElement(driver, locatorType).isDisplayed();
    }
    protected boolean isElementDisplayed(WebDriver driver, String locatorType, String ...dynamicValues) {
        return getWebElement(driver, getDynamicXpath(locatorType, dynamicValues)).isDisplayed();
    }

    protected boolean isImageLoaded(WebDriver driver, String locatorType) {
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        boolean status = (boolean) jsExecutor.executeScript("return arguments[0].complete && typeof arguments[0].naturalWidth != \"undefined\" && arguments[0].naturalWidth > 0", getWebElement(driver, locatorType));
        if (status) {
            return true;
        } else {
            return false;
        }
    }

    private String getDynamicXpath (String locatorType, String... dynamicValues){
        if (locatorType.startsWith("xpath=") || locatorType.startsWith("Xpath=")) {
            locatorType = String.format(locatorType, (Object[]) dynamicValues);
        }
        return locatorType;
    }

    protected void scrollToElement(WebDriver driver, String locatorType, String... dynamicValues) {
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("arguments[0].scrollIntoView(true);", getWebElement(driver, getDynamicXpath(locatorType, dynamicValues)));
    }

    protected void clickToElement(WebDriver driver, String locatorType, String... dynamicValues) {
        locatorType = getDynamicXpath(locatorType, dynamicValues);
        getWebElement(driver, locatorType).click();
    }

    protected void waitForElementVisible(WebDriver driver, String locatorType, String... dynamicValues) {
        WebDriverWait explicitWait = new WebDriverWait(driver, Duration.ofSeconds(longTimeout));
        explicitWait.until(ExpectedConditions.visibilityOfElementLocated(getByLocator(getDynamicXpath(locatorType, dynamicValues))));
    }
}
