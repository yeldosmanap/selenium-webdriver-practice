package assignment4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class TC111BookTicketTest {
    WebDriver driver;
    // Object of login page
    FlightsLoginPage loginObject;
    // Object of book flight page
    BookFlightPage bookFlightPage;
    // Get the driver name and path from application.properties file
    String driverName = PropertiesReader.getParam("driver-name");
    String driverPath = PropertiesReader.getParam("driver-path");


    // Using @BeforeTest annotation, written setup method which will launch our driver
    @BeforeTest
    public void setup() {
        System.setProperty(driverName, driverPath);

        driver = new ChromeDriver();

        driver
                .manage()
                .window()
                .maximize();

        driver
                .manage()
                .timeouts()
                .scriptTimeout(Duration.ofSeconds(10));

        driver.get("https://demo.guru99.com/test/newtours/login.php");
    }

    // Annotated a method with @Test annotation and priority 1, which means this test will be called first

    @Test(priority = 1)
    public void test_login() {
        // Get parameters from application.properties file
        String username = PropertiesReader.getParam("username");
        String password = PropertiesReader.getParam("password");

        // Create Login Page object
        loginObject = new FlightsLoginPage(driver);

        if (driver.findElements(By.className("btn")).size() > 0) {
            System.out.println("Button exists");
            driver.findElement(By.className("btn")).click();
        }

        // Login to the application
        loginObject.login(username, password);

        // Move to the next page
        bookFlightPage = new BookFlightPage(driver);
    }

    @Test(priority = 2)
    public void test_book_flight() {
        // Call the method for booking a ticket
        bookFlightPage.bookTicket();
    }
}
