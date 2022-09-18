package assignment2.task3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

import java.time.LocalDateTime;
import java.util.List;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        // Setting a driver for our Browser
        System.setProperty(
                "webdriver.chrome.driver",
                "C:\\webdriver_selenium\\chromedriver_win32\\chromedriver.exe");

        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("excludeSwitches", List.of("disable-popup-blocking"));

        //initializing our driver, getting url and maximize the window size
        WebDriver driver = new ChromeDriver();
        String baseUrl = "https://demo.guru99.com/test/newtours/index.php";

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
                                "Flights"))
                .click();

        Thread.sleep(2000);

        if (driver.findElements(By.className("btn")).size() > 0) {
            System.out.println("Button exists");
            driver.findElement(By.className("btn")).click();
        }

        // Setting departing from country
        Select departingFromCity = new Select(driver.findElement(By.name("fromMonth")));
        departingFromCity.selectByIndex(3);

        // Setting arriving in country
        Select arrivingInCity = new Select(driver.findElement(By.name("toPort")));
        arrivingInCity.selectByIndex(6);

        // Click to "CONTINUE" button in flight finder
        driver.findElement(By.name("findFlights")).click();
    }
}
