package browserFactory;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class ChromeDriverManager implements BrowserFactory {

    @Override
    public WebDriver getBrowserDriver() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();

        chromeOptions.addArguments("start-maximized");
        chromeOptions.setExperimentalOption("useAutomationExtension", false);
        chromeOptions.setExperimentalOption("excludeSwitches", Collections.singletonList("enable-automation"));

        Map<String, Object> chromePreferences = new HashMap<String, Object>();
        chromePreferences.put("credentials_enable_service", false);
        chromePreferences.put("profile.password_manager_enabled", false);

        chromePreferences.put("profile.default_content_settings.popups", 0);
        chromeOptions.setExperimentalOption("prefs", chromePreferences);

        return new ChromeDriver(chromeOptions);
    }
}
