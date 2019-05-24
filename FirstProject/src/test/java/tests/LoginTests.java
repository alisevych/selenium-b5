package tests;

import org.junit.Test;
import static site.LisevychSite.*;


public class LoginTests extends WebInit {

    public static final String ADMIN_USERNAME = "admin";
    public static final String ADMIN_PASSWORD = "admin";

    @Test
    public void loginAsAdminTest() {
        adminLoginPage.open();
        adminLoginPage.loginAsAdmin(ADMIN_USERNAME, ADMIN_PASSWORD);
    }

}
