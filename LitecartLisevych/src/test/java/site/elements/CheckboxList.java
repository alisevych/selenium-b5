package site.customE;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

import static helpers.ElementHelper.*;

public class CheckboxList {

    public By inputsLoc;
    public By labelsLoc;
    public WebDriver driver;

    public CheckboxList(WebDriver driver, By inputsLoc, By labelsLoc) {
        this.driver = driver;
        this.inputsLoc = inputsLoc;
        this.labelsLoc = labelsLoc;
    }

    public List<WebElement> getInputs(){
        return driver.findElements(inputsLoc);
    }

    public List<WebElement> getLabels(){
        return driver.findElements(labelsLoc);
    }

    public boolean isChecked(WebElement input){
        String checkedText = input.getAttribute(CHECKED_ATTRIBUTE);
        if (checkedText == null)
            return false;
        if (checkedText.equals(TRUE_VALUE))
            return true;
        throw new RuntimeException("Checkbox checked attribute has value "+ checkedText + "" +
                ", but expected true or null.");
    }

    public void checkByLabelText(List<String> textsToCheck){
        List<WebElement> labels = getLabels();
        List<Integer> indexesYES = new ArrayList<>();
        List<Integer> indexesNO = new ArrayList<>();
        for (int i = 0; i < labels.size(); i++){
            WebElement label = labels.get(i);
            String labelText = label.getText();
            if (textsToCheck.contains(labelText))
                indexesYES.add(i);
            else
                indexesNO.add(i);
        }
        if (indexesYES.size() + indexesNO.size() != labels.size())
            throw new RuntimeException("AUT-ERROR Size indexesYes + indexesNO != labels.");
        List<WebElement> inputs = getInputs();
        if (indexesYES.size() + indexesNO.size() != inputs.size())
            throw new RuntimeException("AUT-ERROR Size indexesYes + indexesNO != inputs.");
        /* check if needed */
        for (int j=0; j < indexesYES.size(); j++){
            WebElement input = inputs.get(indexesYES.get(j));
            if (!isChecked(input))
                input.click();
        }
        /* uncheck if needed */
        for (int j=0; j < indexesNO.size(); j++){
            WebElement input = inputs.get(indexesNO.get(j));
            if (isChecked(input))
                input.click();
        }
    }

}
