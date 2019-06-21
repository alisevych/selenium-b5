package site.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static helpers.ElementHelper.FIRST_ELEMENT_IN_LIST;
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

    @FindBy(css = ITEMS_LIST_CSS)
    public List<WebElement> items;

    @FindBy(css = REMOVE_BTN_CSS)
    public List<WebElement> removeBtns;

    public WebElement getFirstItem(){
        if (items.isEmpty())
            return null;
        else
            return items.get(0);
    }

    public void removeFirstItem(){
        WebElement orderTable = getOrderTable();
        WebElement firstItemRemoveBtn = removeBtns.get(FIRST_ELEMENT_IN_LIST);
        driverWait.until(visibilityOf(firstItemRemoveBtn));
        firstItemRemoveBtn.click();
        driverWait.until(stalenessOf(orderTable));
    }

    public WebElement getOrderTable(){
        return getUniqueElement(driver, By.cssSelector(ORDER_TABLE_CSS));
    }
}