package pages;

import base.BasePage;
import org.openqa.selenium.By;
import utils.DriverManager;

public class JavaScriptAlertPage extends BasePage {

    private final By jsAlertButton = By.xpath("//button[contains(text(), 'Click for JS Alert')]");
    private final By textResult = By.cssSelector("[id='result']");

    public JavaScriptAlertPage() {
        DriverManager.getDriver();
    }

    public void goToJSAlertPage() {
        goToUrl("https://the-internet.herokuapp.com/javascript_alerts");
    }

    public void closeJSAlert() {
        clickElement(jsAlertButton);
        acceptAlert();
        System.out.println("Text result: " + getText(textResult));
    }
}