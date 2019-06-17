package site.data;

import helpers.DateHelper;
import site.entities.Product;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Products {

    public static Random random = new Random();

    public static final String UNIQUE_ID = DateHelper.getCurrentDateTimeNoSeparators();

    public static final String MANDARINE_NAME = "Ducks mandarin" + UNIQUE_ID;
    public static final String MANDARINE_CODE = UNIQUE_ID;
    public static final String MANDARINE_STATUS = "Enabled";
    public static final List<String> MANDARINE_CATEGORIES = Arrays.asList( "Rubber Ducks", "Subcategory");
    public static final String MANDARINE_DEFAULT_CATEGORY = "Rubber Ducks";
    public static final List<String> MANDARINE_PRODUCT_GROUPS = Arrays.asList( "Female", "Unisex");
    public static final int  MANDARINE_QUANTITY = random.nextInt(1000);
    public static final String MANDARINE_FILE_NAME = "ducks_mandarin.jpg";

    public static Product ducksM = new Product( MANDARINE_NAME, MANDARINE_CODE, MANDARINE_STATUS,
            MANDARINE_CATEGORIES, MANDARINE_DEFAULT_CATEGORY, MANDARINE_PRODUCT_GROUPS,
            MANDARINE_QUANTITY, MANDARINE_FILE_NAME);

}
