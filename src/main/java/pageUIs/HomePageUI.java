package pageUIs;

public class HomePageUI {
    public static final String WELCOME_TEXT = "xpath=//p[@class='smallText']/b[contains(text(),'Welcome')]";
    public static final String ACCOUNT_SERVICES_ITEM_DYNAMIC = "xpath=//h2[text()='Account Services']/following-sibling::ul//a[text()='%s']";
    public static final String PAGE_TITLE_DYNAMIC = "xpath=//h1[@class='title'][text()='%s']";
}
