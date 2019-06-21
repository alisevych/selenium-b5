package site.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

import static helpers.ElementHelper.*;

public class AdminCatalogPage extends BasePage {

    /* Locators */
    public static final String ADD_NEW_PRODUCT_BTN_CSS = " a[href$='doc=edit_product']";
    public static final String CATALOG_TABLE_CSS = " table.dataTable";
    public static final String LINKS_TO_EDIT_PRODUCT_CSS = " a[href*=edit_product][title=Edit]";
    public static final String CATEGORY_CLOSED_CSS = " .fa-folder + a";

    public static final String NAME_HEADER_TEXT = "Name";
    public static final int MAX_ITERATIONS_NUMBER = 100;

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

    public List<WebElement> getProductNames(){
        return getTableColumnWithHeader(getCatalogTable(), NAME_HEADER_TEXT);
    }

    public WebElement getProductByName(String productName){
        List<WebElement> nameColumn = getProductNames();
        for (WebElement name : nameColumn ){
            if (name.getText().equals(productName))
                return name;
        }
        throw new RuntimeException("[AUT-ERROR] Name " + productName + " not found in Catalog dataTable.");
    }

    public List<WebElement> getClosedCategories(){
        return driver.findElements(By.cssSelector(CATALOG_TABLE_CSS + CATEGORY_CLOSED_CSS));
    }

    public List<WebElement> getProducts(){
        return getListWhenPresent(driverWait, driver,
                By.cssSelector(CATALOG_TABLE_CSS + LINKS_TO_EDIT_PRODUCT_CSS));
    }

    public void openAllCategories(){
        int counter = 0;
        List<WebElement> closedCategories = getClosedCategories();
        while (closedCategories.size() > 0){
            for (WebElement category : closedCategories) {
                category.click();
            }
            closedCategories = getClosedCategories();
            counter++;
            if (counter > MAX_ITERATIONS_NUMBER)
                throw new RuntimeException("[AUT-ERROR] closedCategories = "
                        + closedCategories + "; counter = "
                        + counter);
        }
    }

}