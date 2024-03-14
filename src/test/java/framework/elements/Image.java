package framework.elements;

import org.openqa.selenium.By;
public class Image extends BaseElement {
    public Image (By by) {
        super(by);
    }

    protected String getElementType() {
        return getLoc("log.image");
    }
}