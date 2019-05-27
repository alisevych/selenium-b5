package tests;

import helpers.InputHelper;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class WebInit {

    public static WebDriver driver;
    public static WebDriverWait driverWait;
    public static final int timeout = 10;

    public static final String CHROME_NAME = "chrome";
    public static final String IE_NAME = "IE";
    public static final String FIREFOX_NAME = "firefox";

    @Before
    public void start() {
        String browserName = new InputHelper().getPropertyValue("driver");
        if (browserName.equals(CHROME_NAME))
            driver = new ChromeDriver();
        if (browserName.equals(IE_NAME))
            driver = new InternetExplorerDriver();
        if (browserName.equals(FIREFOX_NAME))
            driver = new FirefoxDriver();

        driver.manage().timeouts().implicitlyWait(timeout, TimeUnit.SECONDS);
        driverWait = new WebDriverWait(driver, timeout);
    }

    @After
    public void close() {
        driver.quit();
        driver = null;
    }

}
