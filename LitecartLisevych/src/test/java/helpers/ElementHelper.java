package helpers;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;

public class ElementHelper {

    public static final String HEADERS_CSS = "tr.header > th";
    public static final String TABLE_CELLS_CSS = "tr > td";

    public static final int SIZE_ONE = 1;
    public static final int FIRST_ELEMENT_IN_LIST = 0;

    public static WebElement getUniqueElement(WebDriver driver, By locator){
        List<WebElement> elements = driver.findElements(locator);
        if (elements.size() != SIZE_ONE)
            throw new RuntimeException ("[AUT_ERROR] One unique element expected to be, but found "
                    + elements.size());
        return elements.get(FIRST_ELEMENT_IN_LIST);
    }

    public static boolean areElementsPresent(WebDriver driver, By locator) {
        return driver.findElements(locator).size() > 0;
    }

    public static WebElement getElementWhenPresent (WebDriverWait wait, By locator) {
        return wait.until(presenceOfElementLocated(locator));
    }

    public static int getIndexOfElementInList(List<WebElement> list, String text){
        for (WebElement element : list) {
            if (element.getText().equals(text))
                return list.indexOf(element);
        }
        throw new RuntimeException( "[AUT_ERROR] Element with getText() equals to "+ text +
                " is not found in list.");
    }

    /* Tables */
    public static List<WebElement> getTableHeaders(WebElement table){
        return table.findElements(By.cssSelector(HEADERS_CSS));
    }

    public static List<WebElement> getColumnOfTableWithIndex(WebElement table, int columnIndex){
        String COLUMN_CSS = TABLE_CELLS_CSS + ":nth-child(" + columnIndex + ")";
        return table.findElements(By.cssSelector(COLUMN_CSS));
    }

    public static List<WebElement> getTableColumnWithHeader(WebElement table, String headerText){
        List<WebElement> headers = getTableHeaders(table);
        int columnListIndex = getIndexOfElementInList(headers, headerText);
        return getColumnOfTableWithIndex(table, columnListIndex + 1);
    }

}
