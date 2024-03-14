package wildberries.tests;

import framework.BaseTest;
import io.qameta.allure.Description;
import org.testng.annotations.Test;
import wildberries.pageObject.HeaderPage;
import wildberries.pageObject.NewPoint;

public class NewLocationTest extends BaseTest {

    @Description("New location Test")
    @Test
    public void location(){
        HeaderPage headerPage = new HeaderPage();
        headerPage.pickuppoint();

        NewPoint newPoint = new NewPoint();
        newPoint.setNewPoint();
    }
}