package wildberries.pageObject.baseComponents;

import framework.BasePage;
import framework.elements.Button;
import framework.elements.Label;
import org.openqa.selenium.By;

public class HeaderPage extends BasePage {

    private static final String PAGE_LOCATOR = "//header[@class='header']";
    private static final Button logo = new Button(By.xpath("//a[@class='header__logo']"));
    private static final Button currency= new Button(By.xpath("//button[@class='currency-box__btn']"));
    private static final Label newCurrency = new Label(By.xpath("//span[@class='currency-item__name' and text()='Российский рубль']"));
    private static final Button point= new Button(By.xpath("//div[@class='header__address']"));
    public HeaderPage() {
        super(By.xpath(PAGE_LOCATOR), "Header");
    }
    public void headerLogo () {
        logo.click();
    }

    public void currency () {
        currency.click();
    }

    public void setNewCurrency () {
        newCurrency.clickJS();
    }

    public void pickuppoint () {
        point.clickAndWait();
    }
}