package site.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import site.elements.DropList;

import static helpers.ElementHelper.*;

public class ProductPage extends BasePage {

    /* Blocks */
    public static final String PRODUCT_BLOCK_CSS = " #box-product";
    public static final String PRODUCT_NAME_CSS = " [itemprop=name]";
    public static final String STICKERS_CSS = " .sticker";
    public static final String PRODUCT_REGULAR_PRICE_CSS = " .regular-price";
    public static final String PRODUCT_CAMPAIGN_PRICE_CSS = " .campaign-price";
    /* Buy now form*/
    public static final String BUY_NOW_FORM_CSS = " [name='buy_now_form']";
    /* Size DropList */
    public static final String PRODUCT_SIZE_SELECTED_CSS = " [name='options[Size]']";
    public static final String PRODUCT_SIZE_SUGGESTIONS_CSS = " option";
    public static DropList sizeDropList;
    public static final String ADD_TO_CART_BTN_CSS = " [name=add_cart_product]";

    public ProductPage() {
        url = "/";
        title = "";
        sizeDropList = new DropList( driver,
                By.cssSelector(BUY_NOW_FORM_CSS + PRODUCT_SIZE_SELECTED_CSS),
                By.cssSelector(BUY_NOW_FORM_CSS + PRODUCT_SIZE_SUGGESTIONS_CSS));
    }

    @FindBy( css = ADD_TO_CART_BTN_CSS)
    public WebElement addToCartBtn;

    @Override
    public void checkOpened(){
        driverWait.until(ExpectedConditions.
                presenceOfElementLocated(By.cssSelector(PRODUCT_BLOCK_CSS + " " +PRODUCT_NAME_CSS)));
    }

    public WebElement getProductName(){
        return driver.findElement(By.cssSelector(PRODUCT_BLOCK_CSS + PRODUCT_NAME_CSS));
    }

    public WebElement getProductRegularPrice(){
        return driver.findElement(By.cssSelector(PRODUCT_BLOCK_CSS + PRODUCT_REGULAR_PRICE_CSS));
    }

    public WebElement getProductCampaignPrice(){
        return driver.findElement(By.cssSelector(PRODUCT_BLOCK_CSS + PRODUCT_CAMPAIGN_PRICE_CSS));
    }

    public void selectProductSizeIfPresent(String size)
    {
        if (sizeDropList.isPresent()) {
            sizeDropList.select(size);
            System.out.println("[AUT] Size + " + size + " selected.");
        }
    }

    public void addProductToCart(){
        addToCartBtn.click();
    }
}