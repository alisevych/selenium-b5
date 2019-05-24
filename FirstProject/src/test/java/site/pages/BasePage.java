package site.pages;

import tests.WebInit;

import static org.openqa.selenium.support.ui.ExpectedConditions.titleIs;

public class BasePage extends WebInit {

    public static String url = "";
    public static String title = "";

    public void open(){
        driver.navigate().to(url);
    }

}
