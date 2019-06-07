package site.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import site.entities.User;

import java.util.List;

public class CreateAccountPage extends BasePage {

    /* Create account form */
    public static final String CREATE_ACCOUTN_FORM_CSS = " #create-account";
    public static final String FIRST_NAME_INPUT_CSS = " [name=firstname]";
    public static final String LAST_NAME_INPUT_CSS = " [name=lastname]";
    public static final String ADDRESS_1_INPUT_CSS = " [name=address1]";
    public static final String POSTCODE_INPUT_CSS = " [name=city]";
    public static final String EMAIL_INPUT_CSS = " [name=email]";
    public static final String PHONE_INPUT_CSS = " [name=phone]";
    public static final String DESIRED_PASSWORD_INPUT_CSS = " [name=password]";
    public static final String CONFIRM_PASSWORD_INPUT_CSS = " [name=confirmed_password]";

    public CreateAccountPage() {
        url = "http://litecart.stqa.ru/en/create_account";
        title = "Create Account | My Store";
    }

    public void fillCreateAccountForm(User newUser){

    }

}