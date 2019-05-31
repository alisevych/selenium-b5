package tests;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebElement;

import java.util.List;

import static site.LitecartSite.*;
import static helpers.ElementHelper.*;

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

    @Test
    public void checkCountriesAreSortedAlphabetically(){
        adminCountriesPage.open();
        adminHomePage.loginAsAdmin(ADMIN_USERNAME, ADMIN_PASSWORD);
        List<WebElement> countries = adminCountriesPage.getCountries();
        String previousName = "";
        String currentName = "";
        int counter = 0;
        for (WebElement country : countries){
            currentName = country.getText();
            Assert.assertTrue( currentName.compareToIgnoreCase(previousName) >= 0);
            System.out.println("[AUT] Country name: " + currentName);
            counter++;
            previousName = currentName;
        }
        System.out.println("[AUT] Countries checked: " + counter);
    }
}
