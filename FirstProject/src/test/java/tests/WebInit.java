package tests;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class WebInit {

    public WebDriver driver;
    public WebDriverWait driverWait;
    public static final int timeout = 10;

    @Before
    public void start() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(timeout, TimeUnit.SECONDS);
        driverWait = new WebDriverWait(driver, timeout);
    }

    @After
    public void close() {
        driver.quit();
        driver = null;
    }

}
