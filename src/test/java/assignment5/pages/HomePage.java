package assignment5.pages;

import assignment5.utils.logs.Log;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {
    // URL of our website
    String baseURL = "https://www.n11.com/";

    // By class object for sign in button
    By signInButtonClass = By.className("btnSignIn");

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public HomePage goToMainPage() {
        Log.info("Opening N11 Website.");

        // Going to the main page of website
        driver.get(baseURL);

        return this;
    }

    public LoginPage goToLoginPage() {
        Log.info("Going to Login Page..");

        // Clicking to sign in button
        click(signInButtonClass);

        // Return LoginPage object
        return new LoginPage(driver);
    }
}




