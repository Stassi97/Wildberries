package wildberries.pageObject;

import framework.BasePage;
import framework.Browser;
import framework.elements.Button;
import framework.elements.Label;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class NewPoint extends BasePage {

    private static final String PAGE_LOCATOR = "//div[@class='pvz-tab__content tab-item__content']";
    private static final Button search= new Button (By.xpath("//input[@class='form-control form-control--address tab-item__input']"));
    private static final Label newPoint= new Label(By.xpath("//ul[@class='input-autocomplete']//li[1]"));
    private static final Button addressnew = new Button(By.xpath("//div[@class='pvz-list__body']//div[@class='pvz-item-delivery'][1]"));
    private static final Button puthere = new Button(By.xpath("//button[@class='btn delivery-footer__btn--confirm ']"));

    public NewPoint() {
        super(By.xpath(PAGE_LOCATOR), "Map");

    }

    @Step("Chose new point")
    public void setNewPoint (String point) {
        search.click();
        search.sendKeys(point);
        Browser.waitForPageLoad();
        newPoint.clickJS();
        Browser.waitForPageLoad();
        addressnew.clickJS();
        puthere.clickJS();
    }
}