package site.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

import static helpers.ElementHelper.getUniqueElement;
import static helpers.ElementHelper.getUniqueElementInBlock;

public class CartPage extends BasePage {

    public static final String ITEMS_LIST_CSS = " #box-checkout-cart .items li";
    public static final String REMOVE_BTN_CSS = " [name=remove_cart_item]";

    public CartPage() {
        url = "/checkout";
        title = "";
    }

    public WebElement getFirstItem(){
        List<WebElement> items =  driver.findElements(By.cssSelector(ITEMS_LIST_CSS));
        if (items == null)
            return null;
        else
            return items.get(0);
    }

    public void removeItem(WebElement item){
        getUniqueElementInBlock(item, By.cssSelector(REMOVE_BTN_CSS)).click();
    }
}