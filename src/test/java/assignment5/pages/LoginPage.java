package assignment5.pages;

import assignment5.utils.logs.JSErrorLogs;
import assignment5.utils.logs.Log;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.testng.AssertJUnit.*;

public class LoginPage extends BasePage {
    // elements for login form
    By userNameId                = By.id("email");
    By passwordId                = By.id("password");
    By loginButtonId             = By.id("loginButton");
    By errorMessageUsernameXpath = By.xpath("//*[@id=\"loginForm\"]/div[1]/div/div");
    By errorMessagePasswordXpath = By.xpath("//*[@id=\"loginForm\"]/div[2]/div/div ");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public LoginPage loginToN11(String username, String password) {
        Log.info("Trying to login the N11.");

        // Input the text in form (username and password)
        writeText(userNameId, username);
        writeText(passwordId, password);

        // Click to log-in button using its id
        click(loginButtonId);

        return this;
    }

    public LoginPage verifyLoginUserName(String expectedText) {
        Log.info("Verifying login username.");

        // Check that username error message exists
        waitVisibility(errorMessageUsernameXpath);
        assertEquals(readText(errorMessageUsernameXpath), expectedText);

        return this;
    }

    public LoginPage verifyLoginPassword(String expectedText) {
        Log.info("Verifying login password.");

        // Check that username error message exists
        waitVisibility(errorMessagePasswordXpath);
        assertEquals(readText(errorMessagePasswordXpath), expectedText);

        return this;
    }

    public LoginPage verifyLogError() {
        Log.info("Verifying javascript login errors.");

        // Verify that logging error exists
        assertTrue(JSErrorLogs.isLoginErrorLog(driver));

        return this;
    }
}














