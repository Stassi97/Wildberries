package wildberries.pageObject;

import framework.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import static framework.Browser.getDriver;
import org.testng.asserts.SoftAssert;

public class ComparePage extends BasePage {
    SoftAssert softAssert = new SoftAssert();
    private static final String PAGE_LOCATOR = "//div[@class='catalog__in container']";
    private static final String ITEM_NAME = "//div[@class='product-card__title']";
    private static final String FILTER_ITEM_NAME = "//span[@class='chip__name' and text()='Наушники']";
    public ComparePage() {
        super(By.xpath(PAGE_LOCATOR),"'Check Product name' Page");
    }

    @Step("Check product name")
    public void compareProductItem() {
        String itemName = getDriver().findElement(By.xpath(ITEM_NAME)).getText();
        String filterName = getDriver().findElement(By.xpath(FILTER_ITEM_NAME)).getText();
        System.out.println(itemName);
        System.out.println(filterName);
        softAssert.assertTrue(itemName.contains(filterName), "Wrong name");
        softAssert.assertAll();
    }
}