package tests;

import base.BaseTest;
import org.testng.annotations.Test;
import pages.TokopediaPage;

public class TokopediaTest extends BaseTest {

    @Test
    public void testClosePopupAds() {
        TokopediaPage tokopediaPage = new TokopediaPage();
        tokopediaPage.goToTokopediaPage();
        tokopediaPage.closePopupAds();
        tokopediaPage.clickLoginButton();
    }
}