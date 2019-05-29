package tests;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.Keys;
import java.util.Set;

import static org.openqa.selenium.support.ui.ExpectedConditions.titleIs;

public class FirstSimpleTest extends WebInit {

    @Test
    public void myFirstTest() {
        driver.navigate().to("http://www.google.com");
        driver.findElement(By.name("q")).sendKeys("webdriver" + Keys.ENTER);
        driverWait.until(titleIs("webdriver - Поиск в Google"));
    }

    @Test
    public void googleSimpleClicksTest() {
        driver.navigate().to("http://www.google.com");
        String word = "webdriver";
        driver.findElement(By.name("q")).sendKeys(word + Keys.ENTER);
        driver.findElement(By.className("MiYK0e")).click();
        driver.findElement(By.name("q")).sendKeys(Keys.END);
        driver.findElement(By.id("K32")).click();
        driver.findElement(By.className("MiYK0e")).click();
        driver.findElement(By.name("q")).sendKeys(word + Keys.ENTER);
        driverWait.until(titleIs(word + " " + word + " - Поиск в Google"));
    }

    @Test
    public void addCookieTest(){
        String COOKIE_NAME = "test";
        int ZERO_ARRAY_SIZE = 0;
        driver.navigate().to("http://www.google.com");
        driver.manage().addCookie(new Cookie(COOKIE_NAME, COOKIE_NAME));
        Cookie testCookie = driver.manage().getCookieNamed(COOKIE_NAME);
        Set<Cookie> cookies = driver.manage().getCookies();
        Assert.assertTrue(driver.manage().getCookies().toString().contains(COOKIE_NAME));
        driver.manage().deleteCookieNamed(COOKIE_NAME);
        Assert.assertFalse(driver.manage().getCookies().toString().contains(COOKIE_NAME));
        driver.manage().deleteAllCookies();
        Assert.assertEquals(driver.manage().getCookies().size(), ZERO_ARRAY_SIZE);
    }

}
