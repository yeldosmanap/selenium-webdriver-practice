import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class BookFlightPage {
    WebDriver driver;
    // Selection fields from departing from and arriving in cities
    private Select departingFromCity;
    private Select arrivingInCity;

    public BookFlightPage(WebDriver driver) {
        this.driver = driver;
    }

    public void bookTicket() {
        // Here, we finds link text with content "Flights" and click it
        driver.findElement(By.linkText("Flights"))
                .click();

        // Using it for popup ads
        if (driver.findElements(By.className("btn")).size() > 0) {
            System.out.println("Button exists");
            driver.findElement(By.className("btn")).click();
        }

        // We sleep for 2 seconds

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        if (driver.findElements(By.className("btn")).size() > 0) {
            System.out.println("Button exists");
            driver.findElement(By.className("btn")).click();
        }

        // initialize our city selections, and select cities by their indexes
        departingFromCity = new Select(driver.findElement(By.name("fromMonth")));
        departingFromCity.selectByIndex(3);

        arrivingInCity = new Select(driver.findElement(By.name("toPort")));
        arrivingInCity.selectByIndex(6);

        // click button for finding flights
        driver.findElement(By.name("findFlights")).click();
    }
}
