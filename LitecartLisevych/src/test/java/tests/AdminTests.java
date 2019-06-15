package tests;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import site.data.Products;
import site.entities.Product;

import java.util.ArrayList;
import java.util.List;

import static site.LitecartSite.*;
import static site.pages.AdminHomePage.*;

public class AdminTests extends WebInit {

    public static final String ADMIN_USERNAME = "admin";
    public static final String ADMIN_PASSWORD = "admin";

    public static final String INDEX_TO_IGNORE = "0";
    public static final String LINK_TAG_NAME = "a";

    @Test
    public void checkAllLinksOfAppsMenu() {
        adminHomePage.open();
        adminHomePage.loginAsAdmin(ADMIN_USERNAME, ADMIN_PASSWORD);
        int START_INDEX = 0;
        int counter = START_INDEX;
        int iCore = START_INDEX;
        for (iCore = START_INDEX ; iCore < adminHomePage.numberOfCoreLinks; iCore++) {
            adminHomePage.clickCoreLinkByNumber(iCore);
            Assert.assertTrue(adminHomePage.isHeaderPresent());
            counter++;
            for (int iSub = START_INDEX; iSub < adminHomePage.numberOfDisplayedSublinks; iSub++ ) {
                adminHomePage.clickSublinkByNumber(iSub);
                Assert.assertTrue(adminHomePage.isHeaderPresent());
                counter++;
            }
        }
        System.out.println("[AUT] Core links clicked: " + iCore);
        System.out.println("[AUT] Total counter of links clicked: " + counter);
    }

    /*
     * Goes through all WebElements of List, performs getText() and verifies
     * they are sorted alphabetically.
     */
    public static void verifyListOfWebElementsIsSortedAlphabetically(List<WebElement> list) {
        String previousText = "";
        String currentText = "";
        int counter = 0;
        for (WebElement element : list){
            currentText = element.getText();
            if (!currentText.equals("")) { // skip this element
                Assert.assertTrue(currentText.compareToIgnoreCase(previousText) >= 0);
                System.out.println("[AUT] Element text: " + currentText);
                counter++;
                previousText = currentText;
            }
        }
        System.out.println("\n[AUT] Elements checked: " + counter + "\n");
    }

    /* Countries Tests */
    @Test // Task 9
    public void checkCountriesAreSortedAlphabetically(){
        adminCountriesPage.open();
        adminHomePage.loginAsAdmin(ADMIN_USERNAME, ADMIN_PASSWORD);
        List<WebElement> countries = adminCountriesPage.getCountryNames();
        verifyListOfWebElementsIsSortedAlphabetically(countries);
    }

    @Test // Task 9
    public void checkZonesOnCountriesPagesAreSortedAlphabetically(){
        adminCountriesPage.open();
        adminHomePage.loginAsAdmin(ADMIN_USERNAME, ADMIN_PASSWORD);
        /* get indexes of zones different from 0 */
        List<WebElement> zones = adminCountriesPage.getCountryZones();
        List<Integer> indexesToGo = new ArrayList<>();
        int counter = 0;
        for (int iZone = 0; iZone < zones.size(); iZone++){
            if (!zones.get(iZone).getText().equals(INDEX_TO_IGNORE))
                indexesToGo.add(iZone);
        }
        /* click on countries with indexes selected */
        int nextIndex = -1;
        for (int iIndex = 0; iIndex < indexesToGo.size(); iIndex++){
            nextIndex = indexesToGo.get(iIndex);
            List<WebElement> countries = adminCountriesPage.getCountryNames();
            WebElement linkToClick = countries.get(nextIndex).findElement(By.tagName(LINK_TAG_NAME));
            linkToClick.click();
            List<WebElement> countryZones = adminEditCountryPage.getZoneNames();
            verifyListOfWebElementsIsSortedAlphabetically(countryZones);
            adminCountriesPage.open();
        }
    }

    /* Geo Zones Tests */
    /*
     * Same as checkZonesOnCountriesPagesAreSortedAlphabetically,
     * but starts on Geo Zones page. A little bit different in Zones check - dropdowns.
     */
    @Test // Task 9
    public void checkZonesOfGeoZonesPageAreSortedAlphabetically(){
        int INDEX_TO_IGNORE = 0;
        adminGeoZonesPage.open(); // Difference is here
        adminHomePage.loginAsAdmin(ADMIN_USERNAME, ADMIN_PASSWORD);
        /* get indexes of zones different from 0 */
        List<WebElement> countryZones = adminGeoZonesPage.getCountryNames();
        List<Integer> indexesToGo = new ArrayList<>();
        for (int iZone = 0; iZone< countryZones.size(); iZone++){
            if (!countryZones.get(iZone).getText().equals(INDEX_TO_IGNORE))
                indexesToGo.add(iZone);
        }
        /* click on countries with indexes selected */
        int nextIndex = -1;
        for (int iIndex = 0; iIndex < indexesToGo.size(); iIndex++){
            nextIndex = indexesToGo.get(iIndex);
            List<WebElement> countries = adminGeoZonesPage.getCountryNames();
            WebElement linkToClick = countries.get(nextIndex).findElement(By.tagName(LINK_TAG_NAME));
            linkToClick.click();
            /* check column Zone in Zones table is sorted alphabetically */
            List<WebElement> zones = adminEditGeoZonePage.getZones();
            verifyListOfWebElementsIsSortedAlphabetically(zones);
            adminGeoZonesPage.open();
        }
    }

    /* Product tests */
    @Test // Task 12
    public void addNewProductTest() {
        Product newDucks = new Product(Products.ducksM);
        adminHomePage.open();
        adminHomePage.loginAsAdmin(ADMIN_USERNAME, ADMIN_PASSWORD);
        adminHomePage.clickCoreLinkByText(CATALOG_LINK_TEXT);
        adminCatalogPage.checkOpened();
        adminCatalogPage.clickAddNewProductBtn();
        adminAddNewProductPage.fillGeneralTab(newDucks);

    }
}