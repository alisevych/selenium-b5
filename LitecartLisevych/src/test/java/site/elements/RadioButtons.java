package site.customE;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class RadioButtons {

    public By labelsLoc;
    public WebDriver driver;

    public RadioButtons(WebDriver driver, By labelsLoc) {
        this.driver = driver;
        this.labelsLoc = labelsLoc;
    }

    public List<WebElement> getLabels(){
        return driver.findElements(labelsLoc);
    }

    public void select(String labelText){
        List<WebElement> labels = getLabels();
        for (WebElement label : labels){
            if (label.getText().equals(labelText))
                label.click();
        }
    }
}
