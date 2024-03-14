package framework;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;

import static framework.Browser.*;

@Listeners(TestListener.class)
public class BaseTest {
    public WebDriver driver;


    @BeforeMethod
    public void setUp() {
        Browser.getInstance();
        windowMaximize();
        navigateTo(PropertyReader.getProperty("base.URL"));

    }

    @AfterMethod(alwaysRun = true, description = "Closing browser")
    public void tearDown() {
        close();
    }
}