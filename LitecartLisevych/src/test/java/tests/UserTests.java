package tests;

import org.junit.Test;
import site.data.Users;
import site.entities.User;

import static site.LitecartSite.createAccountPage;
import static site.LitecartSite.mainPage;

public class UserTests extends WebInit {

    @Test // Task 11
    public void registerUserWithUSCountryTest() {
        mainPage.open();
        mainPage.clickNewCustomersLink();
        User newUser = new User(Users.randomUserWithUS);
        createAccountPage.fillCreateAccountFormStarFields(newUser);
        mainPage.logout();
        mainPage.loginAs(newUser);
        mainPage.logout();
    }

}
