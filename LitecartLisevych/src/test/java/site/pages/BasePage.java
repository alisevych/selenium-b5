package site.pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import tests.WebInit;

import static helpers.ElementHelper.getUniqueElement;
import static helpers.ElementHelper.getUniqueElementInBlock;

public class BasePage extends WebInit {

    /* Site menu */
    public static final String HOME_LINK_CSS = " #site-menu i.fa-home";

    /* Cart block */
    public static final String CART_BLOCK_CSS = " #cart";
    public static final String CART_QUANTITY_CSS = " .quantity";
    public static final String CART_CHECKOUT_LINK_CSS = " .link[href$=checkout]";

    public String url = "";
    public String title = "";

    BasePage(){
        start();
        PageFactory.initElements(driver,this );
    }

    public void open(){
        driver.navigate().to(domain + url);
    }

    public void checkOpened(){
        Assert.assertTrue(driver.getCurrentUrl().contains(domain));
        Assert.assertTrue(driver.getCurrentUrl().contains(url));
        Assert.assertTrue(driver.getTitle().contains(title));
    }

    @FindBy(css = HOME_LINK_CSS)
    public WebElement homeLink;

    @FindBy(css = CART_BLOCK_CSS )
    public WebElement cartBlock;

    @FindBy(css = CART_BLOCK_CSS + CART_QUANTITY_CSS)
    public WebElement cartQuantityText;

    /* Site menu actions */
    public void clickHomeLink(){
        homeLink.click();
    }

    /* Cart actions*/
    public void waitQuantityInCartToBe(int expectedValue){
        driverWait.until(ExpectedConditions.textToBePresentInElement(
                cartQuantityText,
                String.valueOf(expectedValue)));
    }

    public void clickCartCheckoutLink(){
        WebElement checkoutLink = getUniqueElementInBlock(cartBlock,
                By.cssSelector(CART_CHECKOUT_LINK_CSS));
        checkoutLink.click();
    }

}
