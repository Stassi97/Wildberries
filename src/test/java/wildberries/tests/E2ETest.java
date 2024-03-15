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

    public void e2eWildberries() {
         WbPage wbPage = new WbPage();
         wbPage.search("беспроводные наушники");

         ItemChoicePage choice = new ItemChoicePage();
         choice.chooseFilter();
         ComparePage compare = new ComparePage();
         compare.compareProductItem();
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