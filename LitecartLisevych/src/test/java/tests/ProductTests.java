package tests;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebElement;

import java.util.List;

import static site.LitecartSite.*;
import static helpers.ElementHelper.*;

public class ProductTests extends WebInit {

    /* Main Page Tests */
    /* Test checks that every product on the Main Page has exactly one sticker. */
    @Test
    public void checkUniqueStickerForEveryProduct() {
        mainPage.open();
        int START_INDEX = 0;
        int iProduct = START_INDEX;
        List<WebElement> products = mainPage.getAllProductsList();
        for (iProduct = START_INDEX ; iProduct < products.size(); iProduct++) {
            List<WebElement> stickers = mainPage.getStickersFromProduct(products.get(iProduct));
            Assert.assertEquals(stickers.size(), SIZE_ONE);
            System.out.println("[AUT] Sticker text: " + stickers.get(FIRST_ELEMENT_IN_LIST).getText());
        }
        System.out.println("[AUT] Total counter of products verified: " + iProduct);
    }
}
