package tests;

import org.junit.Test;
import org.openqa.selenium.By;

import static site.LisevychSite.*;


public class LoginTests extends WebInit {

    public static final String ADMIN_USERNAME = "admin";
    public static final String ADMIN_PASSWORD = "admin";

    /* loginAsAdmin_All_in_one_place_Test parameters */
    public static final String ADMIN_URL = "http://localhost/litecart/admin/";
    public static final String USERNAME_INPUT_NAME = "username";
    public static final String PASSWORD_INPUT_NAME = "password";
    public static final String LOGIN_BUTTON_NAME = "login";

    @Test
    public void loginAsAdminTest() {
        adminLoginPage.open();
        adminLoginPage.loginAsAdmin(ADMIN_USERNAME, ADMIN_PASSWORD);
    }

    @Test
    public void loginAsAdmin_All_in_one_place_Test() {
        driver.navigate().to(ADMIN_URL);
        driver.findElement(By.name(USERNAME_INPUT_NAME)).sendKeys(ADMIN_USERNAME);
        driver.findElement(By.name(PASSWORD_INPUT_NAME)).sendKeys(ADMIN_PASSWORD);
        driver.findElement(By.name(LOGIN_BUTTON_NAME)).click();
    }

}
