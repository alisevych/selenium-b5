package site.pages;

import org.openqa.selenium.By;

public class AdminLoginPage extends BasePage {

    public static final String USERNAME_INPUT_NAME = "username";
    public static final String PASSWORD_INPUT_NAME = "password";
    public static final String LOGIN_BUTTON_NAME = "login";

    public AdminLoginPage(){
        url = "http://localhost/litecart/admin/";
        title = "Lisevych Software";
    }

    public void loginAsAdmin(String username, String password){
        driver.findElement(By.name(USERNAME_INPUT_NAME)).sendKeys(username);
        driver.findElement(By.name(PASSWORD_INPUT_NAME)).sendKeys(password);
        driver.findElement(By.name(LOGIN_BUTTON_NAME)).click();
    }
}
