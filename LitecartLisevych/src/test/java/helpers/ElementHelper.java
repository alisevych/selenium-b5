package helpers;

import org.assertj.core.api.SoftAssertions;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.Dimension;
import tests.WebInit;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;

public class ElementHelper {

    /* CSS Values */
    public static final String CSS_COLOR = "color";
    public static String COLORS_NUMBERS_PATTERN = "(\\d+)";
    public static final String FONT_WEIGHT = "font-weight";
    public static final String STRONG_TEXT_TAG = "strong";
    public static final String LINE_THROUGH_TAG_NAME = "s";
    public static final String TEXT_DECORATION_LINE = "text-decoration-line";
    public static final String LINE_THROUGH_STYLE = "line-through";

    /* Table locators */
    public static final String HEADERS_CSS = "tr.header > th";
    public static final String TABLE_CELLS_CSS = "tr > td";

    public static final int SIZE_ONE = 1;
    public static final int FIRST_ELEMENT_IN_LIST = 0;
    public static final Integer ZERO_VALUE = 0;

    public static WebElement getUniqueElement(WebDriver driver, By locator){
        List<WebElement> elements = driver.findElements(locator);
        if (elements.size() != SIZE_ONE)
            throw new RuntimeException ("[AUT_ERROR] One unique element expected to be, but found "
                    + elements.size());
        return elements.get(FIRST_ELEMENT_IN_LIST);
    }

    public static WebElement getUniqueElementInBlock(WebElement block, By locator){
        List<WebElement> elements = block.findElements(locator);
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

    /* Styles */
    public static ArrayList<Integer> getColorsOfElement(WebElement element){
        String elementColors = element.getCssValue(CSS_COLOR);
        Pattern totalNumberOfItemsPattern = Pattern.compile(COLORS_NUMBERS_PATTERN);
        Matcher matcher = totalNumberOfItemsPattern.matcher(elementColors);
        ArrayList<Integer> results = new ArrayList() {};
        while (matcher.find())
            results.add(Float.valueOf(matcher.group()).intValue());
        return results;
    }

    public static boolean isElementColorIsGrey(WebElement element){
        ArrayList<Integer> colors = getColorsOfElement(element);
        System.out.println("[AL] Must be GREY: " + colors);
        if (colors.get(0).equals(colors.get(1)))
            if (colors.get(1).equals(colors.get(2)))
                return true;
        return false;
    }

    public static boolean isElementColorIsRed(WebElement element){
        ArrayList<Integer> colors = getColorsOfElement(element);
        System.out.println("[AL] Must be RED: " + colors);
        if (colors.get(0) != ZERO_VALUE)
            if (colors.get(1) == ZERO_VALUE)
                if (colors.get(2) == ZERO_VALUE)
                    return true;
        return false;
    }

    public static boolean isElementFontIsStrong(WebElement element){
        String tagName = element.getTagName();
        System.out.println("[AL] Must be STRONG: " + tagName);
        if (tagName.equals(STRONG_TEXT_TAG))
            return true;
        else
            return false;
    }

    public static boolean isElementFontIsLinedThrough(WebElement element){
        String browserName = new InputHelper().getPropertyValue("driver");
        String tagName = element.getTagName();
        if (browserName.equals(WebInit.IE_NAME)) {
            tagName = element.getTagName();
            System.out.println("[AL] Must be S: " + tagName);
            if (tagName.equals(LINE_THROUGH_TAG_NAME))
                return true;
            else
                return false;
        }
        else {
            String textDecorationLine = element.getCssValue(TEXT_DECORATION_LINE);
            System.out.println("[AL] Must be LINE THROUGH: " + textDecorationLine);
            if (textDecorationLine.equals(LINE_THROUGH_STYLE))
                return true;
            else
                return false;
        }
    }

    public static boolean isSecondElementBiggerThanFirst (WebElement element1, WebElement element2){
        Dimension size1 = element1.getSize();
        Dimension size2 = element2.getSize();
        if (size1.getHeight() < size2.getHeight())
            if (size1.getWidth() < size2.getWidth()) {
                System.out.println("[AL] Size 2 bigger than size 1: TRUE.");
                return true;
            }
        System.out.println("[AL] Size 2 bigger than size 1: FALSE.");
        return false;
    }
}
