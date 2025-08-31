package base;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.DriverManager;

import java.time.Duration;

public class BasePage extends BaseTest {

    public void goToUrl(String url) {
        DriverManager.getDriver().get(url);
    }

    public void inputField(By element, String value) {
        WebElement webElement = DriverManager.getDriver().findElement(element);
        webElement.clear();
        webElement.sendKeys(value);
    }

    public void clickElement(By element) {
        DriverManager.getDriver().findElement(element).click();
    }

    public String getText(By element) {
        return DriverManager.getDriver().findElement(element).getText();
    }

    public void acceptAlert() {
        Alert alert = DriverManager.getDriver().switchTo().alert();
        System.out.println(alert.getText());
        alert.accept();
    }

    public void elementIsDisplayed(By element) {
        waitUntil(ExpectedConditions.visibilityOfElementLocated(element));
    }

    private void waitUntil(ExpectedCondition<WebElement> condition) {
        WebDriverWait driverWait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(10));
        driverWait.until(condition);
    }
}