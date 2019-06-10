package site.pages;

import static helpers.ElementHelper.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class AdminCountriesPage extends BasePage {

    /* Locators */
    public static final String COUNTRIES_TABLE_CSS = "table.dataTable";
    public static final String NAME_HEADER_TEXT = "Name";
    public static final String ZONES_HEADER_TEXT = "Zones";

    WebElement countriesTable;

    public AdminCountriesPage() {
        url = "/admin/?app=countries&doc=countries";
        title = "Countries | Lisevych Software";
    }

    public WebElement getCountriesTable(){
        return getElementWhenPresent(driverWait, By.cssSelector(COUNTRIES_TABLE_CSS));
    }

    public List<WebElement> getCountryNames(){
        countriesTable = getCountriesTable();
        return getTableColumnWithHeader(countriesTable, NAME_HEADER_TEXT);
    }

    public List<WebElement> getCountryZones(){
        countriesTable = getCountriesTable();
        return getTableColumnWithHeader(countriesTable, ZONES_HEADER_TEXT);
    }

}