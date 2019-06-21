package helpers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.logging.LogEntry;

public class BrowserHelper {

    public static boolean arePresentBrowserLogs(WebDriver driver) {
        boolean arePresent = false;
        for (LogEntry l : driver.manage().logs().get("browser").getAll()){
            System.out.println(l);
            arePresent = true;
        }
        if (arePresent)
            System.out.println("[AUT] \n Logs above on page with url : \n "
                + driver.getCurrentUrl());
        return arePresent;
    }
}
