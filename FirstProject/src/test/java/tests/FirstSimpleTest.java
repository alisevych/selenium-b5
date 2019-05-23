package tests;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import static org.openqa.selenium.support.ui.ExpectedConditions.titleIs;

public class FirstSimpleTest extends WebInit {

    @Test
    public void myFirstTest() {
        driver.navigate().to("http://www.google.com");
        driver.findElement(By.name("q")).sendKeys("webdriver" + Keys.ENTER);
        driverWait.until(titleIs("webdriver - Поиск в Google"));
    }

}
