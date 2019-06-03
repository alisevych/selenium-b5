package tests;

import org.junit.Test;

import static site.LitecartSite.*;

public class LoginTests extends WebInit {

    public static final String ADMIN_USERNAME = "admin";
    public static final String ADMIN_PASSWORD = "admin";

    @Test
    public void loginAsAdminTest() {
        adminHomePage.open();
        adminHomePage.loginAsAdmin(ADMIN_USERNAME, ADMIN_PASSWORD);
    }

}
