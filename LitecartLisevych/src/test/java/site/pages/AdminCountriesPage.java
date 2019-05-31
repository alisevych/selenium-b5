package site.pages;

import static helpers.ElementHelper.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class AdminCountriesPage extends BasePage {

    /* Locators */
    public static final String COUNTRIES_TABLE_CSS = "table.dataTable";
    public static final String HEADERS_CSS = "tr.header > th";
    public static final String NAME_TEXT = "Name";
    public static final int NAMES_INDEX = 5;
    public static final String COUNTRIES_NAMES_CSS = "tr.row > td:nth-child(" + NAMES_INDEX + ")";

    public AdminCountriesPage() {
        url = "http://localhost/litecart/admin/?app=countries&doc=countries";
        title = "Countries | Lisevych Software";
    }

    public WebElement getCountriesTable(){
        List<WebElement> elements = driver.findElements(By.cssSelector(COUNTRIES_TABLE_CSS));
        return getElementFromListAndCheckItIsUnique(elements);
    }

    public List<WebElement> getTableHeaders(WebElement table){
        return table.findElements(By.cssSelector(HEADERS_CSS));
    }

    public List<WebElement> getCountries(){
        WebElement countriesTable = getCountriesTable();
        List<WebElement> headers = getTableHeaders(countriesTable);
        verifyElementInListText(headers, NAMES_INDEX - 1 , NAME_TEXT); // index in list -1
        return countriesTable.findElements(By.cssSelector(COUNTRIES_NAMES_CSS));
    }

}