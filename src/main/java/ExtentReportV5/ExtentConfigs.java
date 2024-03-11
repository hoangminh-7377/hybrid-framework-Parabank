package ExtentReportV5;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import commons.GlobalConstants;

import java.io.File;

public class ExtentConfigs {
    public static final ExtentReports extentReports = new ExtentReports();

    public synchronized static ExtentReports createExtentReports() {
        ExtentSparkReporter reporter = new ExtentSparkReporter(GlobalConstants.PROJECT_PATH + File.separator +"ExtentReportV5" + File.separator + "ExtentReport.html");
        extentReports.attachReporter(reporter);
        reporter.config().setReportName("SauceLab Report");
        reporter.config().setDocumentTitle("SauceLab Report");
        //reporter.config().setTimelineEnabled(true);
        //reporter.config().setEncoding("utf-8");
        reporter.config().setTheme(Theme.STANDARD);

        extentReports.attachReporter(reporter);
        extentReports.setSystemInfo("Company", "Comany name");
        extentReports.setSystemInfo("Project", "SauceLab");
        extentReports.setSystemInfo("JDK version", GlobalConstants.JAVA_VERSION);
        return extentReports;
    }
}
