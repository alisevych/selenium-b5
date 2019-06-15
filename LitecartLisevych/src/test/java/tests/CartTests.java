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
        mainPage.open();
        List<WebElement> products = null;
        WebElement firstProduct = null;
        for (int counter=1; counter <= numberOfProductsToAdd; counter++) {
            products = mainPage.getAllProductsList();
            firstProduct = products.get(FIRST_ELEMENT_IN_LIST);
            firstProduct.click();
            productPage.addProductToCart();
            productPage.waitQuantityInCartToBe(counter, driverWait);
            productPage.clickHomeLink();
        }
        productPage.getCartCheckoutLink().click();
        WebElement item = cartPage.getFirstItem();
        while (item != null) {
            item.getText();
            cartPage.removeItem(item);
            // после каждого удаления подождать, пока внизу обновится таблица
            //cartPage.waitOrderTable();
            item = cartPage.getFirstItem();
        }
    }
}
