package site.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static helpers.ElementHelper.*;

public class DDwithInput {

    public By selectedLoc;
    public By expandLoc;
    public By inputLoc;

    public DDwithInput(By selectedLoc, By expandLoc, By inputLoc) {
        this.selectedLoc = selectedLoc;
        this.expandLoc = expandLoc;
        this.inputLoc = inputLoc;
    }

    public void select(WebDriver driver, String value){
        WebElement selected = getUniqueElement(driver, selectedLoc);
        if (selected.getText().equals(value))
            return;
        WebElement expand = getUniqueElement(driver, expandLoc);
        expand.click();
        // enter value and press Enter
        WebElement input = getUniqueElement(driver, inputLoc);
        input.sendKeys(value);
        input.sendKeys(Keys.ENTER);
    }
}
