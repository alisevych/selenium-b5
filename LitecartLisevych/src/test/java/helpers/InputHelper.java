package helpers;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class InputHelper {

    public static final String PROPERTIES_FILE_NAME = "test.properties";

    public String getPropertyValue (String propertyName) {
        InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream(PROPERTIES_FILE_NAME);
        Properties properties = new Properties();
        try {
            properties.load(inputStream);
        } catch (IOException exceptionTExt) {
            System.out.println("[AuT_ERROR] IOException when try to load from " + PROPERTIES_FILE_NAME +
                    "IOException text ::\n" + exceptionTExt);
        }
        return properties.getProperty(propertyName);
    }
}
