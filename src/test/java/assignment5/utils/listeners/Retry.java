package assignment5.utils.listeners;

import assignment5.tests.BaseTest;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

import static assignment5.utils.extent_reports.ExtentManagerTest.getTest;

public class Retry implements IRetryAnalyzer {
    // Amount of attempts
    private        int count  = 0;
    // Run the failed test 2 times
    private static int maxTry = 1;

    @Override
    public boolean retry(ITestResult iTestResult) {
        // Check test is passed or not
        if (!iTestResult.isSuccess()) {
            // Check if amount of tries more than max tries
            if (count < maxTry) {
                count++;
                // set a status of the test as failed (FAILURE)
                iTestResult.setStatus(ITestResult.FAILURE);
                // ExtendReports fail operations
                extendReportsFailOperations(iTestResult);

                // Tels that we should retry the test
                return true;
            }
        } else {
            // set a status of the test as passed (SUCCESS)
            iTestResult.setStatus(ITestResult.SUCCESS);
        }
        return false;
    }
    public void extendReportsFailOperations(ITestResult iTestResult) {
        Object testClass = iTestResult.getInstance();

        WebDriver webDriver = ((BaseTest) testClass).getDriver();

        String base64Screenshot = "data:image/png;base64," + ((TakesScreenshot) webDriver).getScreenshotAs(OutputType.BASE64);
        getTest().log(Status.FAIL, "Test Failed",
                getTest().addScreenCaptureFromBase64String(base64Screenshot).getModel().getMedia().get(0));
    }
}



