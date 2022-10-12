package assignment4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FlightsLoginPage {
    WebDriver driver;
    // Paths which it'll get from application.properties file
    By usernamePath = By.name(PropertiesReader.getParam("username-login-path"));
    By passwordPath = By.name(PropertiesReader.getParam("password-login-path"));
    By loginButtonPath = By.name(PropertiesReader.getParam("submit-button-login-path"));

    public FlightsLoginPage(WebDriver driver) {
        this.driver = driver;
    }

    // setters with sending keys
    public void setUserName(String strUserName) {
        driver.findElement(usernamePath).sendKeys(strUserName);
    }

    public void setPassword(String strPassword) {
        driver.findElement(passwordPath).sendKeys(strPassword);
    }

    // Click login button
    public void clickLogin() {
        driver.findElement(loginButtonPath).click();
    }

    // Base method of our page, which will process the login operation
    public void login(String username, String password) {
        if (driver.findElements(By.className("btn")).size() > 0) {
            System.out.println("Button exists");
            driver.findElement(By.className("btn")).click();
        }

        this.setUserName(username);
        this.setPassword(password);

        this.clickLogin();
    }
}
