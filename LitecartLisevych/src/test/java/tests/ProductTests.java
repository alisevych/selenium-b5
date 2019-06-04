package tests;

import org.junit.Assert;
import org.assertj.core.api.SoftAssertions;
import org.junit.Test;
import org.openqa.selenium.WebElement;

import java.math.BigDecimal;
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

    /* Test checks that Product page opened is correct. */
    @Test
    public void  checkCorrectProductPageIsOpened() {
        mainPage.open();
        List<WebElement> products = mainPage.getProductsFromBlockCampaigns();
        WebElement firstCampaignProduct = products.get(FIRST_ELEMENT_IN_LIST);
        String nameMainPage = mainPage.getProductName(firstCampaignProduct);
        BigDecimal regPriceMainPage = mainPage.getProductRegularPrice(firstCampaignProduct);
        BigDecimal camPriceMainPage = mainPage.getProductCampaignPrice(firstCampaignProduct);
        // go to Product page and check data there
        firstCampaignProduct.click();
        productPage.checkOpened();
        String nameProdPage = productPage.getProductName();
        BigDecimal regPriceProdPage = productPage.getProductRegularPrice();
        BigDecimal camPriceProdPage = productPage.getProductCampaignPrice();
        SoftAssertions softAssert = new SoftAssertions();
        softAssert.assertThat(nameMainPage.equals( nameProdPage));
        softAssert.assertThat(regPriceMainPage.equals(regPriceProdPage));
        softAssert.assertThat(camPriceMainPage.equals(camPriceProdPage));
        System.out.println("[AL] Name : " + nameMainPage + "; " + nameProdPage);
        System.out.println("[AL] Reg price : " + regPriceMainPage + "; " + regPriceProdPage);
        System.out.println("[AL] Cam price : " + camPriceMainPage + "; " + camPriceProdPage);
        softAssert.assertAll();
    }
}
