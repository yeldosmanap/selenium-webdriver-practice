package assignment2.task2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) {
        // Setting a driver for our Browser
        System.setProperty(
                "webdriver.chrome.driver",
                "C:\\webdriver_selenium\\chromedriver_win32\\chromedriver.exe");

        //initializing our driver, getting url and maximize the window size
        WebDriver driver = new ChromeDriver();
        String baseUrl = "https://demo.guru99.com/test/newtours/login.php";

        driver.get(baseUrl);
        driver.manage().window().maximize();

        // Finding elements for sign in and submit the data
        driver.findElement(By.name("userName")).sendKeys("yeldosmanap");
        driver.findElement(By.name("password")).sendKeys("1245emer");
        driver.findElement(By.name("submit")).click();

        System.out.println("Signed in successfully at: " + LocalDateTime.now());

        // Logging of
        driver.findElement(
                        By.linkText(
                                "SIGN-OFF"))
                .click();

        System.out.println("Signed off successfully at: " + LocalDateTime.now());

    }
}
