package site.pages;

import org.junit.Assert;
import tests.WebInit;

public class BasePage extends WebInit {

    public String url = "";
    public String title = "";

    BasePage(){
        start();
    }

    public void open(){
        driver.navigate().to(url);
    }

    public void checkOpened(){
        Assert.assertEquals(driver.getTitle(), title);
        Assert.assertTrue(driver.getCurrentUrl().contains(url));
    }

}
