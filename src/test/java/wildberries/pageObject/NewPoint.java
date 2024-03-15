package wildberries.pageObject;

import framework.BasePage;
import framework.elements.Label;
import org.openqa.selenium.By;

public class NewPoint extends BasePage {

    private static final String PAGE_LOCATOR = "//div[@data-tag='pvzListRoot']";

    private static final Label newPoint= new Label(By.xpath("//div[@class='pvz-item-delivery__address' and text()='Минск Улица Павлины Медёлки 3']"));

    public NewPoint() {
        super(By.xpath(PAGE_LOCATOR), "Map");

    }

    public void setNewPoint () {
        newPoint.clickJS();
    }
}