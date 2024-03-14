package wildberries.tests;

import framework.BaseTest;
import framework.Browser;
import io.qameta.allure.Description;
import org.testng.annotations.Test;

public class CookieTest extends BaseTest {
    @Description("Get cookie Test")

    @Test
    public void getCookies() {
        Browser browser = new Browser();
        browser.getSpecificCookies(true);
    }
}