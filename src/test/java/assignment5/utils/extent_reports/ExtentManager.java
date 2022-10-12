package assignment5.utils.extent_reports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentManager {
    // Static field of ExtentReports class for report creating
    public static final ExtentReports extentReports = new ExtentReports();

    // creating ExtentReports instance, by specifying some properties
    public synchronized static ExtentReports createExtentReports() {
        // Specify the reporter of our tests by path
        ExtentSparkReporter reporter = new ExtentSparkReporter("./extent-reports/extent-report.html");

        // Set some properties of our report
        reporter.config().setReportName("Sample Extent Report");

        extentReports.attachReporter(reporter);
        extentReports.setSystemInfo("Testing", "Example website");
        extentReports.setSystemInfo("Author", "Yeldos Manap");

        // Return a report
        return extentReports;
    }
}



