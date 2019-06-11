package site.data;

import helpers.DateHelper;
import site.entities.Product;

import java.util.Random;

public class Products {

    public static Random random = new Random();

    public static final String UNIQUE_ID = DateHelper.getCurrentDateTimeNoSeparators();

    public static final String NEW_NAME = "Auto" + UNIQUE_ID;

    public static Product randomProduct = new Product( NEW_NAME);

}
