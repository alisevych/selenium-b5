package tests;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebInit {

    public WebDriver driver;
    public WebDriverWait driverWait;
    public static final int timeout = 20;

    @Before
    public void start() {
        driver = new ChromeDriver();
        driverWait = new WebDriverWait(driver, timeout);
    }

    @After
    public void close() {
        driver.quit();
        driver = null;
    }

}
