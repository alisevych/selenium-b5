package site.pages;

import org.openqa.selenium.By;

public class AdminLoginPage extends BasePage {

    public static final String USERNAME_NAME = "username";
    public static final String PASSWORD_NAME = "password";

    public AdminLoginPage(){
        url = "http://localhost/litecart/admin/";
        title = "Lisevych Software";
    }

    public void loginAsAdmin(String username, String password){
        driver.findElement(By.name(USERNAME_NAME)).sendKeys(username);
        driver.findElement(By.name(PASSWORD_NAME)).sendKeys(password);
    }
}
