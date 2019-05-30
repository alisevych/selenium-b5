package tests;

import org.junit.Assert;
import org.junit.Test;

import static site.LitecartSite.*;

public class AdminTests extends WebInit {

    public static final String ADMIN_USERNAME = "admin";
    public static final String ADMIN_PASSWORD = "admin";

    @Test
    public void checkAllLinksOfAppsMenu() {
        adminPage.open();
        adminPage.loginAsAdmin(ADMIN_USERNAME, ADMIN_PASSWORD);
        int START_INDEX = 0;
        int counter = START_INDEX;
        int iCore = START_INDEX;
        for (iCore = START_INDEX ; iCore < adminPage.numberOfCoreLinks; iCore++) {
            adminPage.clickCoreLinkByNumber(iCore);
            Assert.assertTrue(adminPage.isHeaderPresent());
            counter++;
            for (int iSub = START_INDEX; iSub < adminPage.numberOfDisplayedSublinks; iSub++ ) {
                adminPage.clickSublinkByNumber(iSub);
                Assert.assertTrue(adminPage.isHeaderPresent());
                counter++;
            }
        }
        System.out.println("[AUT] Core links clicked: " + iCore);
        System.out.println("[AUT] Total counter of links clicked: " + counter);
    }
}
