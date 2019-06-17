package site.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

import static helpers.ElementHelper.*;

public class AdminCatalogPage extends BasePage {

    /* Locators */
    public static final String ADD_NEW_PRODUCT_BTN_CSS = "a[href$='doc=edit_product']";
    public static final String CATALOG_TABLE_CSS = "table.dataTable";

    public static final String NAME_HEADER_TEXT = "Name";

    public AdminCatalogPage() {
        url = "/admin/?app=catalog&doc=catalog";
        title = "Catalog";
    }

    public void clickAddNewProductBtn(){
        getElementWhenPresent(driverWait, By.cssSelector(ADD_NEW_PRODUCT_BTN_CSS)).click();
    }

    public WebElement getCatalogTable(){
        return getElementWhenPresent(driverWait, By.cssSelector(CATALOG_TABLE_CSS));
    }

    public WebElement getProductByName(String productName){
        List<WebElement> nameColumn = getTableColumnWithHeader(getCatalogTable(), NAME_HEADER_TEXT);
        for (WebElement name : nameColumn ){
            if (name.getText().equals(productName))
                return name;
        }
        throw new RuntimeException("[AUT-ERROR] Name " + productName + " not found in Catalog dataTable.");
    }
}