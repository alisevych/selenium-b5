package site.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

import static helpers.ElementHelper.*;

public class MainPage extends BasePage {

    /* Blocks */
    public static final String CAMPAIGNS_BLOCK_CSS = "#box-campaigns";

    /* Products */
    public static final String ALL_PRODUCTS_CSS = " li.product";
    public static final String ALL_STICKERS_CSS = " .sticker";
    public static final String PRODUCT_NAME_CSS = " .name";
    public static final String PRODUCT_REGULAR_PRICE_CSS = " .regular-price";
    public static final String PRODUCT_CAMPAIGN_PRICE_CSS = " .campaign-price";

    public MainPage() {
        url = "http://localhost/litecart/";
        title = "Online Store | Lisevych Software";
    }

    public List<WebElement> getAllProductsList() {
        return driver.findElements(By.cssSelector(ALL_PRODUCTS_CSS));
    }

    public List<WebElement> getProductsFromBlockCampaigns() {
        WebElement block = getUniqueElement(driver , By.cssSelector(CAMPAIGNS_BLOCK_CSS));
        return block.findElements(By.cssSelector(ALL_PRODUCTS_CSS));
    }

    public List<WebElement> getStickersFromProduct(WebElement product) {
        return product.findElements(By.cssSelector(ALL_STICKERS_CSS));
    }

    public WebElement getProductName(WebElement product){
        return getUniqueElementInBlock(product, By.cssSelector(PRODUCT_NAME_CSS));
    }

    public WebElement getProductRegularPrice(WebElement product){
        return getUniqueElementInBlock(product, By.cssSelector(PRODUCT_REGULAR_PRICE_CSS));
    }

    public WebElement getProductCampaignPrice(WebElement product){
        return getUniqueElementInBlock(product, By.cssSelector(PRODUCT_CAMPAIGN_PRICE_CSS));
    }

}