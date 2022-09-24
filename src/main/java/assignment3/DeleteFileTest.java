package assignment3;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.LocalDateTime;
import java.util.List;

public class DeleteFileTest {
    public static void main(String[] args) {

        System.setProperty(
                "webdriver.chrome.driver",
                "C:\\webdriver_selenium\\chromedriver_win32\\chromedriver.exe");

        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("excludeSwitches", List.of("disable-popup-blocking"));

        //initializing our driver, getting url and maximize the window size
        WebDriver driver = new ChromeDriver();
        String baseUrl = "https://mailchimp.com/";

        driver.get(baseUrl);
        driver.manage().window().maximize();

        driver.findElement(By.xpath(
                        "/html/body/header/nav/ul/li[4]/a"))
                .click();

        // finding elements for registration and filling the following data
        driver.findElement(By.name("username")).sendKeys("yeldos.manap@gmail.comyeldosmanap");
        driver.findElement(By.name("password")).sendKeys("KlinGer1974*");

        // Check for Google captcha button
        if (driver.findElements(By.className("recaptcha-checkbox")).size() > 0) {
            System.out.println("Button exists");
            driver.findElement(By.className("recaptcha-checkbox")).click();
        }

        WebElement submitButton = driver.findElement(By.id("submit-btn"));

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click()", submitButton);

        System.out.println("Signed up successfully at: " + LocalDateTime.now());

        driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div/nav/ul/li[6]/button"))
                .click();
        driver.findElement(By.xpath("//*[@id=\"mc:272\"]/li[2]"))
                .click();

        driver.findElement(By.xpath("//*[@id=\"dijit__WidgetsInTemplateMixin_1\"]/label/div[2]/div[1]"))
                .click();

        driver.findElement(By.xpath("//*[@id=\"uniqName_3_1\"]/div[1]/button")).click();

        System.out.println("File was deleted at: " + LocalDateTime.now());
    }
}


