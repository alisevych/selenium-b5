package tests;

import org.junit.Test;

import static site.LitecartSite.*;

public class AdminTests extends WebInit {

    public static final String ADMIN_USERNAME = "admin";
    public static final String ADMIN_PASSWORD = "admin";

    @Test
    public void checkAllLinksOfAppsMenu() {
        adminPage.open();
        adminPage.loginAsAdmin(ADMIN_USERNAME, ADMIN_PASSWORD);
        adminPage.clickAllCoreLinks();
    }
}
