package helpers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class ElementHelper {

    public static final int NUMBER_ONE = 1;
    public static final int FIRST_ELEMENT_IN_LIST = 0;

    public static WebElement getElementFromListAndCheckItIsUnique(List<WebElement> webElementList){
        if (webElementList.size() != NUMBER_ONE)
            throw new RuntimeException ("[AUT_ERROR] One unique element expected to be, but found "
                    + webElementList.size());
        return webElementList.get(FIRST_ELEMENT_IN_LIST);
    }

    public static boolean areElementsPresent(WebDriver driver, By locator) {
        return driver.findElements(locator).size() > 0;
    }

    public static void waitElementsPresent (WebDriverWait wait, By locator) {
        wait.until(driver -> driver.findElements(locator));
    }
}
