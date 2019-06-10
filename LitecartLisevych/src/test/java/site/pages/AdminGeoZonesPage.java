package site.pages;

import org.openqa.selenium.WebElement;

import java.util.List;

import static site.LitecartSite.*;

public class AdminGeoZonesPage extends BasePage {

    public AdminGeoZonesPage() {
        url = "/admin/?app=geo_zones&doc=geo_zones";
        title = "Geo Zones | Lisevych Software";
    }

    public WebElement getGeoZonesTable(){
        return adminCountriesPage.getCountriesTable();
    }

    public List<WebElement> getCountryNames(){
        return adminCountriesPage.getCountryNames();
    }

}