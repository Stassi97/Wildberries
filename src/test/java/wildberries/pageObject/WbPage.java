package wildberries.pageObject;

import framework.BasePage;
import framework.elements.Button;
import framework.elements.TextBox;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class WbPage extends BasePage {

    private static final String PAGE_LOCATOR = "//div[@class='page main-page']";
    private static final Button catalog= new Button(By.xpath("//button[@data-tag='catalogBtn']"));
    private static final Button search= new Button(By.xpath("//input[@class='search-component-input']"));
    private static final Button searchLabel = new Button(By.xpath("//button[@class='search-component-button search-component-icon-search search-component-icon-search--enabled']"));
    private static final Button item= new Button(By.xpath("//div[@class='card-img swiper-slide is-loaded swiper-slide-active']"));
    private static final Button work= new Button(By.xpath("//a[@data-tag='employment']"));
    private static final Button banner = new Button(By.xpath("//div[@class='skeleton-animation skeleton-banner']"));
    private static final Button basket = new Button(By.xpath("//li[@class='user-menu__item user-menu__item--cart-thin']"));

    public WbPage() {
        super(By.xpath(PAGE_LOCATOR), "Home Page");
    }

    public void catalogClick () {
        catalog.click(); //кликнуть по каталогу
    }

    @Step("Chose item")
    public void search () {
        search.click(); //кликнуть по поиску
        search.sendKeys("беспроводные наушники");
        searchLabel.click();
    }

    public void chooseItem () {
        item.click();
    }

    public void workWB () {
        work.click();
    }

    public void banner () {
        banner.click();
    }

    public void bascket () {
        basket.click();
    }
}