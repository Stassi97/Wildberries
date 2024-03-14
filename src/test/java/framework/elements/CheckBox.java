package framework.elements;

import org.openqa.selenium.By;
public class CheckBox extends BaseElement {
    public CheckBox (By by) {
        super(by);
    }

    protected String getElementType() {
        return getLoc("log.check.box");
    }
}