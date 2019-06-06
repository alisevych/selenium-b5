package site.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import site.entities.User;

import java.util.List;

public class CreateAccountPage extends BasePage {

    public CreateAccountPage() {
        url = "http://litecart.stqa.ru/en/create_account";
        title = "Create Account | My Store";
    }

    public void fillCreateAccountForm(User newUser){

    }

}