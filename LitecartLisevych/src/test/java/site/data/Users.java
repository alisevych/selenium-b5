package site.data;

import helpers.DateHelper;
import site.entities.User;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Users {

    public static Random random = new Random();

    public static final String EMAIL_ENDING = "@sel.ali";
    public static final List<String> states = Arrays.asList( "Alaska", "Montana", "Oklahoma");

    public static final String UNIQUE_ID = DateHelper.getCurrentDateTimeNoSeparators();

    public static final String NEW_FIRST_NAME = "Auto" + String.valueOf(random.nextLong());
    public static final String NEW_LAST_NAME = "Test" + String.valueOf(random.nextLong());
    public static final String NEW_ADDRESS1 = "Test str., " + String.valueOf(random.nextLong());
    public static final String NEW_POSTCODE = String.valueOf(random.nextInt(99999));
    public static final String NEW_CITY = "Autotest";
    public static final String NEW_COUNTRY = "United States";
    public static final String NEW_STATE = states.get(random.nextInt(states.size()));
    public static final String NEW_EMAIL = "auto" + UNIQUE_ID + EMAIL_ENDING;
    public static final String NEW_PHONE = "+1" + random.nextInt(999999999);
    public static final String NEW_PASSWORD = "test" + random.nextInt(999)+"%";

    public static User randomUserWithUS = new User( NEW_FIRST_NAME, NEW_LAST_NAME,
            NEW_ADDRESS1, NEW_POSTCODE, NEW_CITY, NEW_COUNTRY, NEW_STATE,
            NEW_EMAIL, NEW_PHONE, NEW_PASSWORD);

}
