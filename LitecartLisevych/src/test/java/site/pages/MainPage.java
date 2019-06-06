package site.pages;

import helpers.ElementHelper.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

import static helpers.ElementHelper.getElementFromListAndCheckItIsUnique;

public class MainPage extends BasePage {

    /* Products */
    public static final String ALL_PRODUCTS_CSS = "li.product";
    public static final String ALL_STICKERS_CSS = ".sticker";

    /* Login form */
    public static final String LOGIN_FORM_CSS = " #box-account-login";
    public static final String EMAIL_INPUT_CSS = " [name=email]";
    public static final String PASSWORD_INPUT_CSS = " [name=password]";
    public static final String LOGIN_BTN_CSS = " [name=login]";
    public static final String LOST_PASSWORD_BTN_CSS = " [name=lost_password]";
    public static final String NEW_CUSTOMERS_LINK_CSS = " a[href$='create_account']";

    public MainPage() {
        url = "http://litecart.stqa.ru/en/";
        title = "Online Store | Lisevych Software";
    }

    public List<WebElement> getAllProductsList() {
        return driver.findElements(By.cssSelector(ALL_PRODUCTS_CSS));
    }

    public List<WebElement> getStickersFromProduct(WebElement product) {
        return product.findElements(By.cssSelector(ALL_STICKERS_CSS));
    }

    public void clickNewCustomersLink(){
        driver.findElement(By.cssSelector(LOGIN_FORM_CSS + NEW_CUSTOMERS_LINK_CSS)).click();
    }

}