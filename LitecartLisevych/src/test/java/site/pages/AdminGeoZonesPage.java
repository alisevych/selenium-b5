package site.pages;

import helpers.ElementHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

import static helpers.ElementHelper.getElementFromListAndCheckItIsUnique;

public class AdminGeoZonesPage extends BasePage {

    public AdminGeoZonesPage() {
        url = "http://localhost/litecart/admin/?app=geo_zones&doc=geo_zones";
        title = "Geo Zones | Lisevych Software";
    }

}