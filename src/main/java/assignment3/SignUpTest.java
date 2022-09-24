package assignment3;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.LocalDateTime;
import java.util.List;

public class SignUpTest {
    public static void main(String[] args) {
        System.setProperty(
                "webdriver.chrome.driver",
                "C:\\webdriver_selenium\\chromedriver_win32\\chromedriver.exe");

        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("excludeSwitches", List.of("disable-popup-blocking"));

        //initializing our driver, getting url and maximize the window size
        WebDriver driver = new ChromeDriver();
        String baseUrl = "https://mailchimp.com/pricing/marketing/";

        driver.get(baseUrl);
        driver.manage().window().maximize();

        driver.findElement(By.xpath(
                        "//*[@id=\"content\"]/section[2]/div/div/div[1]/div[5]" +
                                "/table/tbody/tr[1]/td[4]/div[4]/a/span[1]"))
                .click();

        // finding elements for registration and filling the following data
        driver.findElement(By.name("email")).sendKeys("yeldos.manap@gmail.com");
        driver.findElement(By.name("username")).sendKeys("yeldosmanap");
        driver.findElement(By.name("password")).sendKeys("KlinGer1974*");
        driver.findElement(By.name("marketing_newsletter")).click();

        WebElement submitButton = driver.findElement(By.id("create-account-enabled"));

        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("arguments[0].click()", submitButton);

        System.out.println("Signed up successfully at: " + LocalDateTime.now());
    }
}

