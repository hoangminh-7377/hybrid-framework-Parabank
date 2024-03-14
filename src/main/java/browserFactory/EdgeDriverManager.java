package browserFactory;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

public class EdgeDriverManager implements BrowserFactory{

    @Override
    public WebDriver getBrowserDriver() {
        WebDriverManager.edgedriver().setup();
        EdgeOptions edgeOptions = new EdgeOptions();

        edgeOptions.setExperimentalOption("useAutomationExtension", false);
        edgeOptions.setExperimentalOption("excludeSwitches", Collections.singletonList("enable-automation"));

        Map<String, Object> prefs = new LinkedHashMap<>();
        prefs.put("user_experience_metrics.personalization_data_consent_enabled", Boolean.valueOf(true));
        edgeOptions.setExperimentalOption("prefs", prefs);

        edgeOptions.addArguments("--guest");

        return new EdgeDriver(edgeOptions);
    }
}