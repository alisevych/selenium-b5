package site.data;

import helpers.DateHelper;
import site.entities.Product;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Products {

    public static Random random = new Random();

    public static final String UNIQUE_ID = DateHelper.getCurrentDateTimeNoSeparators();

    public static final String MANDARINE_NAME = "Mandarin Ducks " + UNIQUE_ID;
    public static final String MANDARINE_CODE = UNIQUE_ID;
    public static final String MANDARINE_STATUS = "Enabled";
    public static final List<String> MANDARINE_CATEGORIES = Arrays.asList( "Rubber Ducks", "Subcategory");
    public static final String MANDARINE_DEFAULT_CATEGORY = "Rubber Ducks";
    public static final List<String> MANDARINE_PRODUCT_GROUPS = Arrays.asList( "Female", "Unisex");
    public static final int  MANDARINE_QUANTITY = random.nextInt(1000);
    public static final String MANDARINE_FILE_NAME = "src\\test\\resources\\ducks_mandarin.jpg";
    public static final String MANDARINE_DATE_VALID_FROM = DateHelper.getDateYearsFromNowWithSlashes(0);
    public static final String MANDARINE_DATE_VALID_TO = DateHelper.getDateYearsFromNowWithSlashes(1);
    /* Information */
    public static final String MANDARINE_MANUFACTURER = "ACME Corp.";
    public static final String MANDARINE_SUPPLIER = null;
    public static final String MANDARINE_KEYWORDS = "mandarin, ducks";
    public static final String MANDARINE_SHORT_DESCRIPTION = "short";
    public static final String MANDARINE_DESCRIPTION = "full\ndescription";
    public static final String MANDARINE_HEAD_TITLE = "Mandarin Ducks";
    public static final String MANDARINE_META_DESCRIPTION = "meta";
    /* Prices */
    public static final BigDecimal MANDARINE_PURCHASE_PRICE = new BigDecimal("15.00");
    public static final String MANDARINE_PURCHASE_CURRENCY = "Euros";
    public static final BigDecimal MANDARINE_PRICE_USD = new BigDecimal("25.00");
    public static final BigDecimal MANDARINE_PRICE_EUR = new BigDecimal("18.00");

    public static Product ducksM = new Product( MANDARINE_NAME, MANDARINE_CODE, MANDARINE_STATUS,
            MANDARINE_CATEGORIES, MANDARINE_DEFAULT_CATEGORY, MANDARINE_PRODUCT_GROUPS,
            MANDARINE_QUANTITY, MANDARINE_FILE_NAME,
            MANDARINE_DATE_VALID_FROM, MANDARINE_DATE_VALID_TO,
             MANDARINE_MANUFACTURER, MANDARINE_SUPPLIER,
             MANDARINE_KEYWORDS,  MANDARINE_SHORT_DESCRIPTION,
            MANDARINE_DESCRIPTION,  MANDARINE_HEAD_TITLE,
             MANDARINE_META_DESCRIPTION,
             MANDARINE_PURCHASE_PRICE, MANDARINE_PURCHASE_CURRENCY,
             MANDARINE_PRICE_USD, MANDARINE_PRICE_EUR);
}
