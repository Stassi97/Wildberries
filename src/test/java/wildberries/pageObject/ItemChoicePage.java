package wildberries.pageObject;

import framework.BasePage;
import framework.elements.Button;
import framework.elements.CheckBox;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import static framework.Browser.getDriver;

public class ItemChoicePage extends BasePage {

    private static final String PAGE_LOCATOR = "//div[@class='catalog']";
    private static final Button filters = new Button(By.xpath("//div[@class='filter-more']"));
    private static final CheckBox filtersChoice = new CheckBox(By.xpath("//span[@class='filter__item-in' and text()='Наушники']"));
    private static final Button closeFilters = new Button(By.xpath("//button[@class='filters-sidebar__close']"));
    private static final List<String> PRODUCTS_LIST = getDriver().findElements(By.xpath("//div[@class='product-snippet']"))
            .stream().map(e-> e.getText()).collect(Collectors.toList());
    private static final String ITEM = "//div[@class='swiper product-card__carousel swiper-initialized swiper-horizontal swiper-backface-hidden']";
    public static String productName;
    private WebElement productItem;

    public ItemChoicePage() {
        super(By.xpath(PAGE_LOCATOR), "Choose Item Page");
    }

    @Step("Chose filter")
    public void chooseFilter() {
        filters.click();
        filtersChoice.clickJS();
        closeFilters.click();
    }

    public  WebElement productSelection() {
        Random random = new Random();
        int i = random.nextInt(1, PRODUCTS_LIST.size()) - 1;
        productName = PRODUCTS_LIST.get(i);
        System.out.println("ProductName of Products"+productName);
        productItem = getDriver().findElement(By.xpath(String.format(ITEM, productName)));
        return productItem = getDriver().findElement(By.xpath(String.format(ITEM, productName)));
    }

    @Step("Click Item")
    public void clickOnProductItem() {
        productItem.click();
    }
}