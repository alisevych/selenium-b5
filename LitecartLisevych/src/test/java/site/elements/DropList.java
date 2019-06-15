package site.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

import static helpers.ElementHelper.*;

public class DropList {

    public By selectedLoc;
    public By suggestionLoc;
    public WebDriver driver;

    public DropList(WebDriver driver, By selectedLoc, By suggestionLoc) {
        this.selectedLoc = selectedLoc;
        this.suggestionLoc = suggestionLoc;
        this.driver = driver;
    }

    public List<WebElement> getSuggestions() {
        return driver.findElements(suggestionLoc);
    }

    public WebElement getSelected(){
        return getUniqueElement(driver, selectedLoc);
    }

    public void select(String value){
        WebElement selected = getSelected();
        if (selected.getText().equals(value))
            return;
        selected.click();
        List<WebElement> suggestions = getSuggestions();
        for (WebElement suggestion : suggestions) {
            if (suggestion.getText().equals(value)) {
                suggestion.click();
                return;
            }
        }
        throw new RuntimeException("[AUT-ERROR] Suggestion with text " +
                value + " is not found in DropList.");
    }

    public boolean isPresent() {
        if (driver.findElements(selectedLoc).isEmpty())
            return false;
        else
            return true;
    }
}
