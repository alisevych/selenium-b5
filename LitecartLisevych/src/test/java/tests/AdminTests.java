package tests;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

import static site.LitecartSite.*;

public class AdminTests extends WebInit {

    public static final String ADMIN_USERNAME = "admin";
    public static final String ADMIN_PASSWORD = "admin";

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
    @Test
    public void checkCountriesAreSortedAlphabetically(){
        adminCountriesPage.open();
        adminHomePage.loginAsAdmin(ADMIN_USERNAME, ADMIN_PASSWORD);
        List<WebElement> countries = adminCountriesPage.getCountryNames();
        verifyListOfWebElementsIsSortedAlphabetically(countries);
    }

    @Test
    public void checkZonesOnCountriesPagesAreSortedAlphabetically(){
        String INDEX_TO_IGNORE = "0";
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
            WebElement linkToClick = countries.get(nextIndex).findElement(By.tagName("a"));
            linkToClick.click();
            /* check column Name in Zones table is sorted alphabetically */
            List<WebElement> countryZones = adminEditCountryPage.getZoneNames();
            verifyListOfWebElementsIsSortedAlphabetically(countryZones);
            adminCountriesPage.open();
        }
    }

}