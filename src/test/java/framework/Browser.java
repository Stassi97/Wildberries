package framework;

import framework.elements.Button;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.Cookie;
import java.time.Duration;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import static java.util.Currency.getInstance;

public class Browser {
    public static Browser instance;
    public static WebDriver driver;

    public static String cookieButton = "//button[@class='btn btn--primary-gradient modal-body__confirm']";

    public static Browser getInstance() {
        if (instance == null) {
            driver = DriverFactory.getDriver();
            driver.manage().timeouts().implicitlyWait(PropertyReader.getIntProperty("timeout"), TimeUnit.SECONDS); //неявное ожидание драйвера 10сек
        } else {
            System.err.println("Driver doesn't instance!");
        }
        return instance = new Browser(); //
    }

    public static void windowMaximize() {
        driver.manage().window().maximize();
    }

    public static void navigateTo(String url) { //метод перехода по сслыке
        driver.get(url);
    }

    public static void close() { //метод закрытия браузера
        driver.quit();
        instance = null;
        System.out.println("Driver has been closed.");
    }

    public static void waitForPageLoad() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(PropertyReader.getIntProperty("page.load.timeout"))); //на протяжении 20сек обращается к документу и проверяет статус
        wait.until(driver -> executor.executeScript("return document.readyState").equals("complete")); //wait until явное ожидание

    }

    public static WebDriver getDriver() {
        return driver;
    }

    public void getSpecificCookies(boolean vari) {
        if (vari == true) {
            Button cookieBTN = new Button(By.xpath(cookieButton));
            cookieBTN.clickAndWait();
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        Set<Cookie> cookies = driver.manage().getCookies();
        if (cookies.size() > 0) {
            System.out.println("Applied");
            for (Cookie cookie : cookies) {
                System.out.println("Name: " + cookie.getName());
                System.out.println("Value: " + cookie.getValue());
            }
        } else {
            System.out.println("Cookies are denied");
        }
    }
}