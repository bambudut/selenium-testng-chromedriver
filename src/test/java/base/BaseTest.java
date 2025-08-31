package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import utils.DriverManager;

import java.time.Duration;

public class BaseTest {

    @BeforeMethod
    protected void setUp() {
        String driverPath = "/src/test/java/drivers/chromedriver-web";
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + driverPath);

        ChromeOptions options = new ChromeOptions();
        options.setImplicitWaitTimeout(Duration.ofSeconds(5));

        WebDriver driver = new ChromeDriver(options);
        DriverManager.setDriver(driver);
        DriverManager.getDriver().manage().window().maximize();
    }

    @AfterMethod
    protected void quit() {
        DriverManager.quitDriver();
    }
}