package site.pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;
import static helpers.ElementHelper.*;

public class AdminPage extends BasePage {

    /* Login Form */
    public static final String USERNAME_INPUT_NAME = "username";
    public static final String PASSWORD_INPUT_NAME = "password";
    public static final String LOGIN_BUTTON_NAME = "login";
    /* Apps Menu */
    public static final String APPS_MENU_XPATH = "//ul[@id='box-apps-menu']";
    public static final String LINK_XPATH = "./li/a";
    public static final String SUBLINK_XPATH = "./li//li/a";
    public int numberOfCoreLinks = 0;

    public static final String PAGE_HEADER_CSS = "h1";

    public AdminPage() {
        url = "http://localhost/litecart/admin/";
        title = "Lisevych Software";
    }

    public void loginAsAdmin(String username, String password) {
        driver.findElement(By.name(USERNAME_INPUT_NAME)).sendKeys(username);
        driver.findElement(By.name(PASSWORD_INPUT_NAME)).sendKeys(password);
        driver.findElement(By.name(LOGIN_BUTTON_NAME)).click();
    }

    public WebElement getAppsMenu() {
        //List<WebElement> elements = driver.findElements(By.cssSelector(APPS_MENU_CSS));
        List<WebElement> elements = driver.findElements(By.xpath(APPS_MENU_XPATH));
        return getElementFromListAndCheckItIsUnique(elements);
    }

    public WebElement getCoreLinkByNumber(int number) {
        WebElement appsMenu = getAppsMenu();
        List<WebElement> linksFound = appsMenu.findElements(By.xpath(LINK_XPATH));
        if (numberOfCoreLinks != linksFound.size())
            throw new RuntimeException ( "[AUT_ERROR] Number of core links changed. Was : " +
                    numberOfCoreLinks + ", and now: " + linksFound.size() );
        return linksFound.get(number);
    }

    public WebElement getSublinksByNumber(int number){
        WebElement appsMenu = getAppsMenu();
        List<WebElement> sublinksFound = appsMenu.findElements(By.xpath(SUBLINK_XPATH));
        if (sublinksFound.size() == number + 1)
            return sublinksFound.get(number);
        else
            return null;
    }

    public boolean isHeaderPresent(){
        List<WebElement> headersFound = driver.findElements(By.cssSelector(PAGE_HEADER_CSS));
        WebElement header = getElementFromListAndCheckItIsUnique(headersFound);
        System.out.println("[AUT] Header is found.");
        return header.isDisplayed();
    }

    public void clickAllCoreLinks() {
        WebElement appsMenu = getAppsMenu();
        List<WebElement> linksFound = appsMenu.findElements(By.xpath(LINK_XPATH));
        numberOfCoreLinks = linksFound.size();
        for (int i=0; i < numberOfCoreLinks; i++) {
            WebElement nextLink = getCoreLinkByNumber(i);
            nextLink.click();
            isHeaderPresent();
            /* go through sublinks */
            int j = 0;
            WebElement nextSublink = getSublinksByNumber(j);
            while (nextSublink != null){
                nextSublink.click();
                Assert.assertTrue(isHeaderPresent());
                j++;
                nextSublink = getSublinksByNumber(j);
                if (j > 100)
                    throw new RuntimeException ( "[AUT_ERROR] Number of sublinks is > 100 : " + j);
            }
        }
    }
}