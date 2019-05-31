package site.pages;

import helpers.ElementHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

import static helpers.ElementHelper.getElementFromListAndCheckItIsUnique;

public class MainPage extends BasePage {

    /* Products */
    public static final String ALL_PRODUCTS_CSS = "li.product";
    public static final String ALL_STICKERS_CSS = ".sticker";

    public MainPage() {
        url = "http://localhost/litecart/";
        title = "Online Store | Lisevych Software";
    }

    public List<WebElement> getAllProductsList() {
        return driver.findElements(By.cssSelector(ALL_PRODUCTS_CSS));
    }

    public List<WebElement> getStickersFromProduct(WebElement product) {
        return product.findElements(By.cssSelector(ALL_STICKERS_CSS));
    }

}