package tests;

import helpers.InputHelper;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.util.concurrent.TimeUnit;

public class WebInit {

    protected static WebDriver driver;
    protected static WebDriverWait driverWait;
    protected static final int timeout = 10;

    private static final String CHROME_NAME = "chrome";
    private static final String IE_NAME = "IExplorer";
    private static final String FIREFOX_NAME = "firefox";
    private static final String FIREFOX_OLD_NAME = "firefoxOld";
    private static final String FIREFOX_NIGHTLY_NAME = "firefoxNightly";

    @Before
    public void start() {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("unexpectedAlertBehaviour", "dismiss");
        String browserName = new InputHelper().getPropertyValue("driver");
        if (browserName.equals(CHROME_NAME)) {
            ChromeOptions chromeOptions = new ChromeOptions();
            chromeOptions.addArguments("start-maximized");
            capabilities.setCapability(ChromeOptions.CAPABILITY, chromeOptions);
            driver = new ChromeDriver(capabilities);
        }
        if (browserName.equals(IE_NAME)) {
            driver = new InternetExplorerDriver(capabilities);
        }
        if (browserName.equals(FIREFOX_NAME)) {
            driver = new FirefoxDriver();
        }
        if (browserName.equals(FIREFOX_OLD_NAME)) {
            FirefoxOptions ffOptions = new FirefoxOptions();
            ffOptions.setBinary(new FirefoxBinary(new File("c:\\Program Files\\Mozilla Firefox\\45.ESR\\firefox.exe")));
            capabilities.setCapability(FirefoxOptions.FIREFOX_OPTIONS, ffOptions);
            driver = new FirefoxDriver(capabilities);
        }
        if (browserName.equals(FIREFOX_NIGHTLY_NAME)) {
            FirefoxOptions ffOptions = new FirefoxOptions();
            ffOptions.setBinary(new FirefoxBinary(new File("c:\\Program Files\\Mozilla Firefox\\Nightly\\firefox.exe")));
            driver = new FirefoxDriver(ffOptions);
        }
        //System.out.println("[AL] Capabilities::\n" + ((HasCapabilities) driver).getCapabilities());
        driver.manage().timeouts().implicitlyWait(timeout, TimeUnit.SECONDS);
        driverWait = new WebDriverWait(driver, timeout);
    }

    @After
    public void close() {
        driver.quit();
        driver = null;
    }

}
