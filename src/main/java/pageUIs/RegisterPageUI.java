package pageUIs;

public class RegisterPageUI {
    public static final String TEXTBOX_DYNAMIC = "xpath=//form[@id='customerForm']//td//b[contains(text(), '%s')]//parent::td//following-sibling::td//input";
    public static final String REGISTER_BUTTON = "xpath=//input[@value='Register']";
    public static final String WELCOME_HEADER = "xpath=//h1[@class='title'][contains(text(),'Welcome')]";
    public static final String ACCOUNT_CREATED_MESSAGE = "xpath=//p[text()='Your account was created successfully. You are now logged in.']";
    public static final String DYNAMIC_REQUIRED_FIELD_MESSAGE = "xpath=//span[@class='error'][contains(text(),'%s is required.')]";
    public static final String REGISTER_PAGE_TITLE = "xpath=//h1[text()='Signing up is easy!']";
    public static final String LOGOUT_HYPERLINK = "xpath=//a[text()='Log Out']";
    public static final String DUPLICATED_USER_MESSAGE = "xpath=//span[@id='customer.username.errors'][text()='This username already exists.']";
}
