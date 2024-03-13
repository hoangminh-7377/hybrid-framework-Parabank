package commons;

import browserFactory.LocalFactory;
import org.openqa.selenium.WebDriver;

import java.io.IOException;
import java.time.Duration;


public class BaseTest {
    private WebDriver driverBaseTest;

    protected BaseTest() {
    }

    public WebDriver getDriverFromBaseTest() {
        return this.driverBaseTest;
    }

    protected WebDriver getBrowserDriverFactory(String environmentName, String browserName){
        switch (environmentName) {
            case "local":
                driverBaseTest = new LocalFactory(browserName).createWebDriver();
                break;

                default:
                driverBaseTest= new LocalFactory(browserName).createWebDriver();
                break;
        }

        driverBaseTest.manage().timeouts().implicitlyWait(Duration.ofSeconds(GlobalConstants.LONG_TIMEOUT));
        driverBaseTest.get(GlobalConstants.USER_PAGE_URL);
        return driverBaseTest;
    }

    protected void closeBrowserDriver() {
        String cmd = null;
        try {
            String osName = System.getProperty("os.name").toLowerCase();
            String driverInstanceName = driverBaseTest.toString().toLowerCase();

            String browserDriverName = null;
            if (driverInstanceName.contains("chrome")) {
                browserDriverName = "chromedriver";
            }
            else if (driverInstanceName.contains("firefox")) {
                browserDriverName = "geckodriver";
            }
            else if (driverInstanceName.contains("edge")) {
                browserDriverName = "msedgedriver";
            }
            else {
                browserDriverName = "safaridriver";
            }
            if (osName.contains("window")) {
                cmd = "taskkill /F /FI \"IMAGENAME eq " + browserDriverName + "*\"";
            } else {
                cmd = "pkill " + browserDriverName;
            }
        } catch (Exception e) {
            e.getMessage();
        } finally {
            driverBaseTest.quit();
            try {
                Process process = Runtime.getRuntime().exec(cmd);
                process.waitFor();
                driverBaseTest.quit();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
