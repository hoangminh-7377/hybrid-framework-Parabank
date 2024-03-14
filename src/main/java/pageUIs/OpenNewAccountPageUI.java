package pageUIs;

public class OpenNewAccountPageUI {
    public static final String ACCOUNT_TYPE_DROPDOWN = "xpath=//select[@id='type']";
    public static final String FROM_ACCOUNT_DROPDOWN = "XPATH=//select[@id='fromAccountId']";
    public static final String OPEN_NEW_ACCOUNT_BUTTON = "xpath=//input[@class='button'][@value='Open New Account']";
    public static final String ACCOUNT_OPENED_HEADER = "xpath=//h1[text()='Account Opened!']";
    public static final String ACCOUNT_OPENED_BODY = "xpath=//p[contains(text(),'Congratulations, your account is now open.')]";
}