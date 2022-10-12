package assignment5.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {
    // Driver of browser
    public WebDriver driver;
    // Field for using waits on web
    public WebDriverWait wait;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void click(By by) {
        // Wait for visibility by "By" class object, then click it
        waitVisibility(by).click();
    }

    public void writeText(By by, String text) {
        // Wait for visibility by "By" class object, then send a text
        waitVisibility(by).sendKeys(text);
    }

    public String readText(By by) {
        // Wait for visibility by "By" class object, then read the text
        return waitVisibility(by).getText();
    }

    public WebElement waitVisibility(By by) {
        // Wait for visibility by "By" class object, wait for visibility using following classes
        return wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }
}





