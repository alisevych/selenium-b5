package tests;

import org.junit.Test;

import static site.LitecartSite.mainPage;

public class UserTests extends WebInit {

    public static final String ADMIN_USERNAME = "admin";
    public static final String ADMIN_PASSWORD = "admin";

    @Test
    public void registerUserTest() {
        mainPage.open();
        mainPage.clickNewCustomersLink();

    }

}
