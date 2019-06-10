package site.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static helpers.ElementHelper.*;

public class ProductPage extends BasePage {

    /* Blocks */
    public static final String PRODUCT_BLOCK = " #box-product";

    /* Product properties*/
    public static final String PRODUCT_NAME_CSS = " [itemprop=name]";
    public static final String STICKERS_CSS = " .sticker";
    public static final String PRODUCT_REGULAR_PRICE_CSS = " .regular-price";
    public static final String PRODUCT_CAMPAIGN_PRICE_CSS = " .campaign-price";

    public ProductPage() {
        url = "http://localhost/litecart/";
        title = "";
    }

    @Override
    public void checkOpened(){
        driverWait.until(ExpectedConditions.
                presenceOfElementLocated(By.cssSelector(PRODUCT_BLOCK + " " +PRODUCT_NAME_CSS)));
    }

    public WebElement getProductName(){
        return driver.findElement(By.cssSelector(PRODUCT_BLOCK + PRODUCT_NAME_CSS));
    }

    public WebElement getProductRegularPrice(){
        return driver.findElement(By.cssSelector(PRODUCT_BLOCK + PRODUCT_REGULAR_PRICE_CSS));
    }

    public WebElement getProductCampaignPrice(){
        return driver.findElement(By.cssSelector(PRODUCT_BLOCK + PRODUCT_CAMPAIGN_PRICE_CSS));
    }

}