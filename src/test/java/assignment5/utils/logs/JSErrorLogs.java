package assignment5.utils.logs;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogType;

public class JSErrorLogs {
    // check if error is existed
    public static Boolean isLoginErrorLog(WebDriver driver) {
        // get logs of a driver
        LogEntries logEntries = driver
                .manage()
                .logs()
                .get(LogType.BROWSER);

        // convert to stream and check for specified message
        return logEntries
                .getAll()
                .stream()
                .anyMatch(logEntry -> logEntry.getMessage().contains("An invalid email address was specified"));
    }
}



