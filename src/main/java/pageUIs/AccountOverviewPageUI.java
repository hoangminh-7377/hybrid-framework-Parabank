package pageUIs;

public class AccountOverviewPageUI {
    public static final String AVAILABLE_BALANCE = "xpath=//th[text()='Available Amount']/ancestor::thead/following-sibling::tbody//tr[@ng-repeat='account in accounts']/td[3]";
    public static final String TOTAL_BALANCE = "xpath=//b[text()='Total']/parent::td//following-sibling::td//b";
}