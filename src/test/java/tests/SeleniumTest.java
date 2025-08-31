package tests;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import java.time.Duration;

public class SeleniumTest {

    WebDriver driver;
    WebDriverWait webDriverWait;

    @BeforeClass
    public void setUp() {
        String driverPath = "/src/test/java/drivers/chromedriver-web";
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + driverPath);

        ChromeOptions options = new ChromeOptions();
        options.setImplicitWaitTimeout(Duration.ofSeconds(5));

        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
    }

    public void testObjectModel() {
        // TODO: Change driver.get in setUp()
        // TODO: Please comment the steps that no need to test

        // Test steps for "https://the-internet.herokuapp.com/javascript_alerts"
        WebElement buttonTriggerAlert = driver.findElement(
                By.xpath("//button[contains(text(), 'Click for JS Alert')]"));
        buttonTriggerAlert.click();

        Alert alert = driver.switchTo().alert();
        System.out.println(alert.getText());
        alert.accept();
        String textResult = driver.findElement(By.cssSelector("[id='result']")).getText();
        System.out.println("Text result: " + textResult);

        // Test steps for "https://tokopedia.com" ads popup
        webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(5));
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(
                By.className("css-dfpqc0")));
        System.out.println("Ads popup already displayed.");

        WebElement closePopupAds = driver.findElement(
                By.cssSelector("body > div:nth-child(44) > div.css-kl3gjj.e1nc1fa20 > article > div > div.css-11hzwo5 > button"));
        closePopupAds.click();
        WebElement buttonLogin = driver.findElement(By.cssSelector("[data-testid=\"btnHeaderLogin\"]"));
        Assert.assertTrue(buttonLogin.isDisplayed());
        buttonLogin.click();
        System.out.println("Button login is displayed and clicked.");
    }

    @AfterClass
    public void quit() {
        if (driver != null) {
            driver.quit();
        }
    }
}