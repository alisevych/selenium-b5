package site.data;

import helpers.DateHelper;
import site.entities.Product;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Products {

    public static Random random = new Random();

    public static final String UNIQUE_ID = DateHelper.getCurrentDateTimeNoSeparators();

    public static final String MANDARINE_NAME = "Ducks mandarin" + UNIQUE_ID;
    public static final String MANDARINE_CODE = UNIQUE_ID;
    public static final String MANDARINE_STATUS = "Enabled";
    public static final List<String> MANDARINE_CATEGORIES = Arrays.asList( "Subcategory", "Rubber Ducks");

    public static Product ducksM = new Product( MANDARINE_NAME, MANDARINE_CODE, MANDARINE_STATUS, MANDARINE_CATEGORIES);

}
