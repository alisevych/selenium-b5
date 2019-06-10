package site.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

import static helpers.ElementHelper.*;
import static site.LitecartSite.*;

public class AdminEditGeoZonePage extends BasePage {

    /* Locators */
    public static final String ZONES_TABLE_CSS = "table#table-zones";
    public static final String ZONE_HEADER_TEXT = "Zone";
    public static final String SELECTED_OPTION_CSS = "option[selected]";

    WebElement zonesTable;

    public AdminEditGeoZonePage() {
        url = "/admin/?app=geo_zones&doc=edit_geo_zone";
        title = "Edit Geo Zone";
    }

    public WebElement getZonesTable(){
        return adminEditCountryPage.getZonesTable();
    }

    public List<WebElement> getZones(){
        zonesTable = getZonesTable();
        List<WebElement> zoneDropdowns = getTableColumnWithHeader(zonesTable, ZONE_HEADER_TEXT);
        // get List of elements option[selected] from all zoneDropdowns
        List<WebElement> zoneSelected = zoneDropdowns.get(FIRST_ELEMENT_IN_LIST).findElements(By.cssSelector(SELECTED_OPTION_CSS));
        for (int index = FIRST_ELEMENT_IN_LIST + 1; index < zoneDropdowns.size(); index++){
            WebElement dropdown = zoneDropdowns.get(index);
            List<WebElement> option = dropdown.findElements(By.cssSelector(SELECTED_OPTION_CSS));
            WebElement optionSelected = option.get(FIRST_ELEMENT_IN_LIST);
            zoneSelected.add(optionSelected);
        }
        return zoneSelected;
    }

}