package helpers;

import com.google.common.io.Files;
import org.openqa.selenium.*;
import org.openqa.selenium.support.events.AbstractWebDriverEventListener;

import java.io.File;
import java.io.IOException;

public class MyListener extends AbstractWebDriverEventListener {

/*    @Override
    public void beforeFindBy(By by, WebElement element, WebDriver driver) {
        System.out.println("[AUT] " + by);
    }

    @Override
    public void afterFindBy(By by, WebElement element, WebDriver driver) {
        System.out.println("[AUT] " + by + " found.");
    }
*/
    @Override
    public void onException(Throwable throwable, WebDriver driver) {
        System.out.println("[AUT] " + throwable);
        File tempFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        String screenName = "screen" +
                DateHelper.getCurrentDateTimeNoSeparators() +
                ".png";
        try {
            Files.copy(tempFile, new File(screenName));
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("[AUT] Screenshot in file: " + screenName);
    }
}
