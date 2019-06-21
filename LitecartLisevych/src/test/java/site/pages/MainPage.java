package site.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import site.entities.User;

import java.util.List;

import static helpers.ElementHelper.*;

public class MainPage extends BasePage {

    /* Blocks */
    public static final String CAMPAIGNS_BLOCK_CSS = "#box-campaigns";

    /* Products */
    public static final String ALL_PRODUCTS_CSS = " li.product";
    public static final String ALL_STICKERS_CSS = " .sticker";
    public static final String PRODUCT_NAME_CSS = " .name";
    public static final String PRODUCT_REGULAR_PRICE_CSS = " .regular-price";
    public static final String PRODUCT_CAMPAIGN_PRICE_CSS = " .campaign-price";

    /* Login form */
    public static final String LOGIN_FORM_CSS = " #box-account-login";
    public static final String EMAIL_INPUT_CSS = " [name=email]";
    public static final String PASSWORD_INPUT_CSS = " [name=password]";
    public static final String LOGIN_BTN_CSS = " [name=login]";
    public static final String LOST_PASSWORD_BTN_CSS = " [name=lost_password]";
    public static final String NEW_CUSTOMERS_LINK_CSS = " a[href$='create_account']";

    /* Account form */
    public static final String ACCOUNT_FORM_CSS = " #box-account";
    public static final String LOGOUT_LINK_CSS = " a[href$='logout']";

    public MainPage() {
        url = "";
        title = "Online Store";
    }

    @FindBy(css = ALL_PRODUCTS_CSS)
    public List<WebElement> allProducts;

    @FindBy(css = CAMPAIGNS_BLOCK_CSS)
    public WebElement campainsBlock;

    @FindBy(css = LOGIN_FORM_CSS + NEW_CUSTOMERS_LINK_CSS)
    public WebElement newCustomersLink;

    @FindBy(css = ACCOUNT_FORM_CSS + LOGOUT_LINK_CSS)
    public WebElement logoutLink;

    @FindBy(css = LOGIN_FORM_CSS + EMAIL_INPUT_CSS)
    public WebElement emailInput;

    @FindBy(css = LOGIN_FORM_CSS + PASSWORD_INPUT_CSS)
    public WebElement passwordInput;

    @FindBy(css = LOGIN_FORM_CSS + LOGIN_BTN_CSS)
    public WebElement loginBtn;

    public void clickFirstProductOnPage(){
        allProducts.get(FIRST_ELEMENT_IN_LIST).click();
    }

    public List<WebElement> getProductsFromBlockCampaigns() {
        return campainsBlock.findElements(By.cssSelector(ALL_PRODUCTS_CSS));
    }

    public List<WebElement> getStickersFromProduct(WebElement product) {
        return product.findElements(By.cssSelector(ALL_STICKERS_CSS));
    }

    public WebElement getProductName(WebElement product){
        return getUniqueElementInBlock(product, By.cssSelector(PRODUCT_NAME_CSS));
    }

    public WebElement getProductRegularPrice(WebElement product){
        return getUniqueElementInBlock(product, By.cssSelector(PRODUCT_REGULAR_PRICE_CSS));
    }

    public WebElement getProductCampaignPrice(WebElement product){
        return getUniqueElementInBlock(product, By.cssSelector(PRODUCT_CAMPAIGN_PRICE_CSS));
    }

    public void logout() {
        logoutLink.click();
    }

    public void loginAs(User user) {
        emailInput.sendKeys(user.email);
        passwordInput.sendKeys(user.desiredPassword);
        loginBtn.click();
    }
}