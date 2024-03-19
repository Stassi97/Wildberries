package wildberries.pageObject;

import framework.BasePage;
import framework.elements.Button;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import java.util.concurrent.TimeUnit;

public class ItemPage extends BasePage {

    private static final String PAGE_LOCATOR = "//div[@class='product-page']";
    private static final Button addToBascket = new Button(By.xpath("//div[@data-tag='productBasketButton']"));
    private static final Button addToFavorite = new Button(By.xpath("//button[@class='product__favourites']"));
    private static final Button goToBascket = new Button(By.xpath("//*[@id=\"productSummaryDesktop\"]/div[2]/div[1]/div/button"));

    public ItemPage() {
        super(By.xpath(PAGE_LOCATOR), "Item Page");
    }

    @Step("Add to Basket")
    public void addToBascket () {
        addToBascket.click();
    }

    @Step("Add to favorites")
    public void addToFavorites () {
        addToFavorite.click();
    }

    @Step("Go to basket")
    public void goToBascket() {
        goToBascket.click();
    }
}