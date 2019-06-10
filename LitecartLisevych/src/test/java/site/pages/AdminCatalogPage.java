package site.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

import static helpers.ElementHelper.getElementWhenPresent;
import static helpers.ElementHelper.getTableColumnWithHeader;

public class AdminCatalogPage extends BasePage {

    /* Locators */
    public static final String ADD_NEW_PRODUCT_BTN_CSS = "a[href$='category_id=0&amp;app=catalog&amp;doc=edit_product']";

    public AdminCatalogPage() {
        url = "/admin/?app=catalog&doc=catalog";
        title = "Catalog";
    }

    public void clickAddNewProductBtn(){
        getElementWhenPresent(driverWait, By.cssSelector(ADD_NEW_PRODUCT_BTN_CSS)).click();
    }

}