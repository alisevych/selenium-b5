package site.pages;

import helpers.ElementHelper;
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
    public static final String APPS_MENU_CSS = "ul#box-apps-menu";
    public static final String APPS_MENU_XPATH = "//ul[@id='box-apps-menu']";
    public static final String LINK_XPATH = "./li/a";
    public static final String SUBLINK_XPATH = "./li//li/a";
    public int numberOfCoreLinks = -1;
    public int numberOfDisplayedSublinks = -1;

    public static final String PAGE_HEADER_CSS = "h1";

    public AdminPage() {
        url = "http://localhost/litecart/admin/";
        title = "Lisevych Software";
    }

    public void loginAsAdmin(String username, String password) {
        driver.findElement(By.name(USERNAME_INPUT_NAME)).sendKeys(username);
        driver.findElement(By.name(PASSWORD_INPUT_NAME)).sendKeys(password);
        driver.findElement(By.name(LOGIN_BUTTON_NAME)).click();
        getCoreLinks(); // initializing numberOfCoreLInks;
    }

    public WebElement getAppsMenu() {
        List<WebElement> elements = driver.findElements(By.cssSelector(APPS_MENU_CSS));
        //List<WebElement> elements = driver.findElements(By.xpath(APPS_MENU_XPATH));
        return getElementFromListAndCheckItIsUnique(elements);
    }

    public List<WebElement> getCoreLinks() {
        WebElement appsMenu = getAppsMenu();
        List<WebElement> linksFound = appsMenu.findElements(By.xpath(LINK_XPATH));
        if (numberOfCoreLinks == -1)
            numberOfCoreLinks = linksFound.size(); // initialize
        if (numberOfCoreLinks != linksFound.size())
            throw new RuntimeException ( "[AUT_ERROR] Number of core links changed. Was : " +
                    numberOfCoreLinks + ", and now: " + linksFound.size() );
        return linksFound;
    }

    public List<WebElement> getSublinks() {
        WebElement appsMenu = getAppsMenu();
        List<WebElement> sublinksFound = appsMenu.findElements(By.xpath(SUBLINK_XPATH));
        numberOfDisplayedSublinks = sublinksFound.size();
        return sublinksFound;
    }

    public void clickCoreLinkByNumber(int number) {
        WebElement coreLink = getCoreLinks().get(number);
        System.out.println("[AUT] Core Link: " + coreLink.getText());
        coreLink.click();
        getSublinks(); // initialize number of sublinks displayed
    }

    public void clickSublinkByNumber(int number){
        WebElement sublink = getSublinks().get(number);
        System.out.println("[AUT] Sublink: " + sublink.getText());
        sublink.click();
    }

    public boolean isHeaderPresent(){
        WebElement headerFound = ElementHelper.getElementWhenPresent(driverWait, By.cssSelector(PAGE_HEADER_CSS)) ;
        //System.out.println("[AUT] Header: " + headerFound.getText());
        return headerFound.isDisplayed();
    }
}