package tests;

import org.junit.Test;
import org.openqa.selenium.WebElement;

import java.util.List;

import static helpers.ElementHelper.*;
import static site.LitecartSite.*;

public class CartTests extends WebInit {

    /* Test checks that product is added to the Cart. */
    @Test
    public void checkAddAndRemoveProductInCart() {
        int numberOfProductsToAdd = 3;
        String DEFAULT_SIZE = "Small";
        mainPage.open();
        List<WebElement> products = null;
        WebElement firstProduct = null;
        for (int counter=1; counter <= numberOfProductsToAdd; counter++) {
            products = mainPage.getAllProductsList();
            firstProduct = products.get(FIRST_ELEMENT_IN_LIST);
            firstProduct.click();
            if (productPage.sizeDroplist.isPresent(driver))
                productPage.sizeDroplist.select(DEFAULT_SIZE, driver);
            productPage.addProductToCart();
            productPage.waitQuantityInCartToBe(counter, driverWait);
            productPage.clickHomeLink();
        }
        productPage.getCartCheckoutLink().click();
        WebElement item = cartPage.getFirstItem();
        while (item != null) {
            System.out.println("[AUT] item text: " + item.getText());
            cartPage.removeItem(item);
            item = cartPage.getFirstItem();
        }
    }
}
