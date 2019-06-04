package tests;

import org.junit.Assert;
import org.assertj.core.api.SoftAssertions;
import org.junit.Test;
import org.openqa.selenium.WebElement;

import java.math.BigDecimal;
import java.util.List;

import static helpers.AmountHelper.convertStringToBigDecimal;
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
        WebElement nameLbl = mainPage.getProductName(firstCampaignProduct);
        WebElement regularPriceLbl = mainPage.getProductRegularPrice(firstCampaignProduct);
        WebElement campaignPriceLbl = mainPage.getProductCampaignPrice(firstCampaignProduct);
        // get text from elements
        String nameMainPage = nameLbl.getText();
        BigDecimal regPriceMainPage = convertStringToBigDecimal(regularPriceLbl.getText());
        BigDecimal camPriceMainPage = convertStringToBigDecimal(campaignPriceLbl.getText());
        SoftAssertions softAssertions = new SoftAssertions();
        // check styles of elements on Main page
        assertElementColorIsGrey(regularPriceLbl, softAssertions);
        // go to Product page and get data there
        firstCampaignProduct.click();
        productPage.checkOpened();
        nameLbl = productPage.getProductName();
        String nameProdPage = nameLbl.getText();
        regularPriceLbl = productPage.getProductRegularPrice();
        campaignPriceLbl = productPage.getProductCampaignPrice();
        // get text from elements
        BigDecimal regPriceProdPage = convertStringToBigDecimal(regularPriceLbl.getText());
        BigDecimal camPriceProdPage = convertStringToBigDecimal(campaignPriceLbl.getText());
        softAssertions.assertThat(nameMainPage.equals( nameProdPage));
        softAssertions.assertThat(regPriceMainPage.equals(regPriceProdPage));
        softAssertions.assertThat(camPriceMainPage.equals(camPriceProdPage));
        System.out.println("[AL] Prod name : " + nameMainPage + "; " + nameProdPage);
        System.out.println("[AL] Reg price : " + regPriceMainPage + "; " + regPriceProdPage);
        System.out.println("[AL] Cam price : " + camPriceMainPage + "; " + camPriceProdPage);
        // check styles of elements on Product page
        assertElementColorIsGrey(regularPriceLbl, softAssertions);
        softAssertions.assertAll();
    }
}
