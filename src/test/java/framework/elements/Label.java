package framework.elements;

import org.openqa.selenium.By;
public class Label extends BaseElement {
    public Label (By by) {
        super(by);
    }

    protected String getElementType() {
        return getLoc("log.label");
    }
}