package wildberries.tests;

import framework.BaseTest;
import framework.Browser;
import io.qameta.allure.Description;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import wildberries.pageObject.*;
import static java.util.Currency.getInstance;

public class E2ETest extends BaseTest {

    @Test
    @Description("Wildberries E2ETest")
    @Parameters({"headphones"})

    public void e2eWildberries(String headphones) {
         WbPage wbPage = new WbPage();
         wbPage.search(headphones);

         ItemChoicePage choice = new ItemChoicePage();
         choice.chooseFilter();
         choice.productSelection();
         choice.clickOnProductItem();

        ItemPage item = new ItemPage();
        item.addToFavorites();
        item.addToBascket();
        item.goToBascket();

        BascketPage basket = new BascketPage();
        basket.addMoreItem();
    }
}