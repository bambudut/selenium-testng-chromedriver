package pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.DriverManager;

public class TokopediaPage extends BasePage {

    private final By imagePopupAds = By.className("css-dfpqc0");
    private final By buttonClosePopup = By.xpath("/html/body/div[5]/div[2]/article/div/div[2]/button");
    private final By buttonLogin = By.cssSelector("[data-testid='btnHeaderLogin']");

    public TokopediaPage() {
        DriverManager.getDriver();
    }

    public void goToTokopediaPage() {
        goToUrl("https://tokopedia.com");
    }

    public void closePopupAds() {
        elementIsDisplayed(imagePopupAds);
        elementIsDisplayed(buttonClosePopup);
        clickElement(buttonClosePopup);
        System.out.println("Ads popup displayed and closed.");
    }

    public void clickLoginButton() {
        clickElement(buttonLogin);
        System.out.println("Button login is displayed and clicked.");
    }
}