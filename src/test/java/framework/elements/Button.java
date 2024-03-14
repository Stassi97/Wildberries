package framework.elements;

import org.openqa.selenium.By;

public class Button extends BaseElement {

   public Button (By by) {
       super (by);
   }

   protected String getElementType() {
       return getLoc("log.button");
   }
}