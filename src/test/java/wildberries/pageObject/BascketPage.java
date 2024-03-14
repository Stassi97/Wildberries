package wildberries.pageObject;

import framework.BasePage;
import framework.elements.Button;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class BascketPage extends BasePage {

    private static final String PAGE_LOCATOR = "//div[@class='b-item__content']";
    private static final Button addMoreItem = new Button(By.xpath("//button[@class='quantity__plus' and text()=' + ']"));
    private static final Button lessItem = new Button(By.xpath("//button[@data-tag='quantityMinus']"));

    public BascketPage() {
        super(By.xpath(PAGE_LOCATOR), "Bascket Page");
    }

    @Step("Add one more item")
    public void addMoreItem () {
        addMoreItem.clickJS();
    }

    public void lessItem () {
        lessItem.click();
    }
}