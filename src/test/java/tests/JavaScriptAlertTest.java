package tests;

import base.BaseTest;
import org.testng.annotations.Test;
import pages.JavaScriptAlertPage;

public class JavaScriptAlertTest extends BaseTest {

    @Test
    public void testJSAcceptAlert() {
        JavaScriptAlertPage scriptAlertPage = new JavaScriptAlertPage();
        scriptAlertPage.goToJSAlertPage();
        scriptAlertPage.closeJSAlert();
    }
}