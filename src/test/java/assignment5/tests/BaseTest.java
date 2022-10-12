package assignment5.tests;

import assignment4.PropertiesReader;
import assignment5.pages.HomePage;
import assignment5.utils.logs.Log;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

public class BaseTest {
    // Driver of browser
    public WebDriver driver;
    // Field for home page
    public HomePage homePage;

    // Elements of our driver and getting them from application.properties
    String driverName = PropertiesReader.getParam("driver-name");
    String driverPath = PropertiesReader.getParam("driver-path");
    public WebDriver getDriver() {
        return driver;
    }

    @BeforeClass
    public void classLevelSetup() {
        Log.info("Tests is starting!");

        // Setting driver properties
        System.setProperty(driverName, driverPath);

        // Initializing our chrome driver

        driver = new ChromeDriver();

        driver
                .manage()
                .window()
                .maximize();

        driver
                .manage()
                .timeouts()
                .scriptTimeout(Duration.ofSeconds(3));
    }

    @BeforeMethod
    public void methodLevelSetup() {
        homePage = new HomePage(driver);
    }

    @AfterClass
    public void teardown() {
        Log.info("Tests are ending!");

        driver.quit();
    }
}














