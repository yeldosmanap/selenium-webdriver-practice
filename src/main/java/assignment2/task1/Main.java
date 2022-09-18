package assignment2.task1;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Main {
    public static void main(String[] args) {
        // Setting a driver for our Browser
        System.setProperty(
                "webdriver.chrome.driver",
                "C:\\webdriver_selenium\\chromedriver_win32\\chromedriver.exe");

        //initializing our driver, getting url and maximize the window size
        WebDriver driver = new ChromeDriver();
        String baseUrl = "https://google.com/";

        driver.get(baseUrl);
        driver.manage().window().maximize();

        // finding an input element and change the content
        driver.findElement(
                        By.xpath("/html/body/div[1]/div[3]/form/div[1]/div[1]/div[1]/div/div[2]/input"))
                .sendKeys("Software Quality");

        // Find "Google search" button and click using click() method of driver
        driver.findElement(By.xpath("/html/body/div[1]/div[3]/form/div[1]/div[1]/div[3]/center/input[1]"))
                .click();

        // Some scroll to down script
        ((JavascriptExecutor)driver).executeScript("window.scrollBy(0, 200)", "");
    }
}
