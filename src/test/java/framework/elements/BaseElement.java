package framework.elements;

import framework.PropertyReader;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import static framework.Browser.*;
import static framework.PropertyReader.getIntProperty;
import static framework.PropertyReader.getProperty;

public abstract class BaseElement {
    private By by;
    private WebElement element;

    public BaseElement(By by) {
        this.by = by;
    }

    public static String getLoc(final String key) {
        return getProperty(key);
    }

    public WebElement getElement() { //класс для взаимодействия с элементами
        isElementPresent();
        return element;
    }

    public String getText() {
        isElementPresent();
        return element.getText();
    }

    public String getAttribute(String attribute) {
        isElementPresent();
        return element.getAttribute(attribute); //в лог вынести значение атрибута
    }

    protected abstract String getElementType();
    public boolean isElementPresent() {
        try {
            getDriver().manage().timeouts().implicitlyWait(new PropertyReader("config.properties").
                    getIntProperty("timeout"), TimeUnit.SECONDS);
            element = getDriver().findElement(by);
            return element.isDisplayed();
        } catch (Exception e) {
            System.out.println(getElementType() + ": " + by + " - is not present. Exception - " + e.getMessage());
            e.printStackTrace();
        }
        return false;
    }

    public boolean isSelected() {
        isElementPresent();
        System.out.println((getProperty("log.select") + element.getText()));
        return element.isSelected();
    }

    public boolean isDisplayed() {
        isElementPresent();
        if(element.isDisplayed()) {
            System.out.println(getElementType() + ": " + by + " is displayed");
            return true;
        }
        else {
            System.out.println(getElementType() + ": " + by + " is not displayed");
            return false;
        }
    }

    public boolean isElementClickable() {
        try{
            new WebDriverWait(getDriver(), Duration.ofSeconds(getIntProperty("element.timeout"))).
                    until(ExpectedConditions.elementToBeClickable(by));
            return true;
        }
        catch (TimeoutException e) {
            System.out.println("Element isn't clickable:" + getElement() + ": " + by);
            return false;
        }
    }

    public void sendKeys(String sendKeys) {
        isElementPresent();
        getElement().sendKeys(sendKeys);
    }

    public boolean select(String value) {
        Select select = new Select(element);
        select.deselectAll();
        return true;
    }

    public void click() {
        isElementPresent();
        if (getDriver() instanceof JavascriptExecutor) {
            ((JavascriptExecutor) getDriver()).executeScript("arguments[0].style.border='3px solid orange'", element);
            isElementClickable();
            getElement().click();
        }
        System.out.println(getProperty("log.click") + " : " + getElementType() + " : " + by);
    }

    public void clickAndWait() {
        isElementPresent();
        if (getDriver() instanceof JavascriptExecutor) {
            ((JavascriptExecutor) getDriver()).executeScript("arguments[0].style.border='3px solid green'", element);
            isElementClickable();
            getElement().click();
        }
        waitForPageLoad();
        System.out.println(getProperty("log.click") + " : " + getElementType() + " : " + by);
    }

    public void clickJS() {
        isElementPresent();
        if(getDriver() instanceof JavascriptExecutor) {
            ((JavascriptExecutor) getDriver()).executeScript("arguments[0].style.border='3px solid pink'", element);
        }
        ((JavascriptExecutor) getDriver()).executeScript("arguments[0].click();", element);
    }

    public void moveAndClickByAction() {
        isElementPresent();
        Actions actions = new Actions(getDriver());
        actions.moveToElement(element).click().perform();
        if(getDriver() instanceof JavascriptExecutor) {
            ((JavascriptExecutor) getDriver()).executeScript("arguments[0].style.border='3px solid brown'", element);
            isElementClickable();
            actions.click().perform();
        }
        System.out.println(getProperty("log.click") + " : " + getElementType() + " : " + by);
    }

    public void clickByAction() { //moveToElement
        isElementPresent();
        Actions actions = new Actions(getDriver());
        actions.moveToElement(element).perform();
        if(getDriver() instanceof JavascriptExecutor) {
            ((JavascriptExecutor) getDriver()).executeScript("arguments[0].style.border='3px solid brown'", element);
            isElementClickable();
            actions.moveToElement(element).click();
        }
        System.out.println(getProperty("log.click") + " : " + getElementType() + " : " + by);
    }

    public void moveToElement() {
        isElementPresent();
        Actions actions = new Actions(getDriver());
        actions.moveToElement(element).perform();
        System.out.println(getLoc("log.moveTo") + ":" + getElementType() + "=" + by);
        if(getDriver() instanceof JavascriptExecutor) {
            ((JavascriptExecutor) getDriver()).executeScript("arguments[0].style.border='3px solid red'", element);
        }
    }

    public void scrollIntoView() {
        isElementPresent();
        Actions actions = new Actions(getDriver());
        actions.moveToElement(element).perform();
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
    }
}