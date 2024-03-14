package wildberries.tests;

import framework.BaseTest;
import framework.Browser;
import io.qameta.allure.Description;
import org.testng.annotations.Test;
import wildberries.pageObject.*;

public class NewCurrencyTest extends BaseTest{

    @Description("New currency Test")

    @Test
    public void currency(){
        HeaderPage headerPage = new HeaderPage();
        headerPage.currency();
        headerPage.setNewCurrency();
    }
}