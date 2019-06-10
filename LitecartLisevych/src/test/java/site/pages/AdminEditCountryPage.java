package site.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

import static helpers.ElementHelper.getElementWhenPresent;
import static helpers.ElementHelper.getTableColumnWithHeader;

public class AdminEditCountryPage extends BasePage {

    /* Locators */
    public static final String ZONES_TABLE_CSS = "table#table-zones";
    public static final String NAME_HEADER_TEXT = "Name";

    WebElement zonesTable;

    public AdminEditCountryPage() {
        url = "/admin/?app=countries&doc=edit_country";
        title = "Edit Country";
    }

    public WebElement getZonesTable(){
        return getElementWhenPresent(driverWait, By.cssSelector(ZONES_TABLE_CSS));
    }

    public List<WebElement> getZoneNames(){
        zonesTable = getZonesTable();
        return getTableColumnWithHeader(zonesTable, NAME_HEADER_TEXT);
    }

}