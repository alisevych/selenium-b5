package helpers;

import java.math.BigDecimal;

public class AmountHelper {

    public static final String SPACE_REGEXP_DELIMITER = "\\s+";
    public static final String DOLLAR = "$";

    public static BigDecimal convertStringToBigDecimal (String initialString){
        if(initialString == null){
            throw new RuntimeException("[AUT-ERROR] The null can't be converted to the BigDecimal, " +
                    "please verify parameters.");
        }
        String newString = initialString.replace(DOLLAR, "");
        newString = newString.replaceAll(SPACE_REGEXP_DELIMITER, "");
        return new BigDecimal(newString);
    }
}
