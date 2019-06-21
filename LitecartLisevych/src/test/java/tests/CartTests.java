package tests;

import org.junit.Test;
import org.openqa.selenium.WebElement;

import static helpers.ElementHelper.*;
import static site.LitecartSite.*;

public class CartTests extends WebInit {

    /* Task 13. */
    /* Task 19. Page Objects refactoring. */
    @Test
    public void addAndRemoveProductsInCartTest() {
        int numberOfProductsToAdd = 3;
        String DEFAULT_SIZE = "Small";
        mainPage.open();
        for (int counter = 1; counter <= numberOfProductsToAdd; counter++) {
            mainPage.clickFirstProductOnPage();
            productPage.selectProductSizeIfPresent(DEFAULT_SIZE);
            productPage.addProductToCart();
            productPage.waitQuantityInCartToBe(counter);
            productPage.clickHomeLink();
        }
        productPage.clickCartCheckoutLink();
        while (cartPage.getFirstItem() != null) {
            cartPage.removeFirstItem();
        }
    }
}
