package site.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

import static helpers.ElementHelper.getUniqueElement;
import static helpers.ElementHelper.getUniqueElementInBlock;
import static org.openqa.selenium.support.ui.ExpectedConditions.*;

public class CartPage extends BasePage {

    public static final String ITEMS_LIST_CSS = " #box-checkout-cart .items li";
    /*Item block */
    public static final String REMOVE_BTN_CSS = " [name=remove_cart_item]";
    /* Order Table */
    public static final String ORDER_TABLE_CSS = " #order_confirmation-wrapper table";

    public CartPage() {
        url = "/checkout";
        title = "";
    }

    public WebElement getFirstItem(){
        List<WebElement> items =  driver.findElements(By.cssSelector(ITEMS_LIST_CSS));
        if (items.isEmpty())
            return null;
        else
            return items.get(0);
    }

    public void removeItem(WebElement item){
        WebElement orderTable = getOrderTable();
        WebElement removeButton = getUniqueElementInBlock(item, By.cssSelector(REMOVE_BTN_CSS));
        driverWait.until(visibilityOf(removeButton));
        removeButton.click();
        driverWait.until(stalenessOf(orderTable));
    }

    public WebElement getOrderTable(){
        return getUniqueElement(driver, By.cssSelector(ORDER_TABLE_CSS));
    }
}