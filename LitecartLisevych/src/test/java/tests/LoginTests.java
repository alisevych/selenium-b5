package tests;

import org.junit.Test;

import static site.LitecartSite.*;

public class LoginTests extends WebInit {

    private static final String ADMIN_USERNAME = "admin";
    private static final String ADMIN_PASSWORD = "admin";

    @Test
    public void loginAsAdminTest() {
        adminLoginPage.open();
        adminLoginPage.loginAsAdmin(ADMIN_USERNAME, ADMIN_PASSWORD);
    }

}
