package site.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.math.BigDecimal;

import static helpers.AmountHelper.convertStringToBigDecimal;
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
        title = "| Lisevych Software";
    }

    @Override
    public void checkOpened(){
        getUniqueElement(driver, By.cssSelector(PRODUCT_BLOCK + " " +PRODUCT_NAME_CSS));
    }

    public String getProductName(){
        WebElement name = driver.findElement(By.cssSelector(PRODUCT_BLOCK + PRODUCT_NAME_CSS));
        return name.getText();
    }

    public BigDecimal getProductRegularPrice(){
        WebElement price = driver.findElement(By.cssSelector(PRODUCT_BLOCK + PRODUCT_REGULAR_PRICE_CSS));
        return convertStringToBigDecimal(price.getText());
    }

    public BigDecimal getProductCampaignPrice(){
        WebElement price = driver.findElement(By.cssSelector(PRODUCT_BLOCK + PRODUCT_CAMPAIGN_PRICE_CSS));
        return convertStringToBigDecimal(price.getText());
    }

}