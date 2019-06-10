package site.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import site.customE.Dropdown;
import site.entities.User;

import static helpers.ElementHelper.getUniqueElement;
import static helpers.ElementHelper.getUniqueElementInBlock;

public class CreateAccountPage extends BasePage {

    /* Create account form */
    public static final String CREATE_ACCOUNT_FORM_CSS = " #create-account";
    public static final String FIRST_NAME_INPUT_CSS = " [name=firstname]";
    public static final String LAST_NAME_INPUT_CSS = " [name=lastname]";
    public static final String ADDRESS_1_INPUT_CSS = " [name=address1]";
    public static final String POSTCODE_INPUT_CSS = " [name=postcode]";
    public static final String CITY_INPUT_CSS = " [name=city]";
    public static final String EMAIL_INPUT_CSS = " [name=email]";
    public static final String PHONE_INPUT_CSS = " [name=phone]";
    public static final String DESIRED_PASSWORD_INPUT_CSS = " [name=password]";
    public static final String CONFIRM_PASSWORD_INPUT_CSS = " [name=confirmed_password]";
    public static final String CREATE_ACCOUNT_BTN_CSS = " [name=create_account]";
    /* Country  Dropdown */
    public static final String COUNTRY_DD_SELECTED_CSS = " span[id^=select2-country_code]";
    public static final String COUNTRY_DD_EXPAND_CSS = " .select2-selection__arrow";
    public static final String COUNTRY_DD_INPUT_CSS = " .select2-search__field";
    public static Dropdown countryDropdown = new Dropdown(By.cssSelector(COUNTRY_DD_SELECTED_CSS),
            By.cssSelector(COUNTRY_DD_EXPAND_CSS),
            By.cssSelector(COUNTRY_DD_INPUT_CSS));
    /* Zone/State/Province Dropdown */
    public static final String STATE_DD_SELECTED_CSS = " input[name=zone_code]";
    public static final String STATE_DD_OPTIONS_CSS = " select[name=zone_code]";
    public static Dropdown stateDropdown = new Dropdown(By.cssSelector(STATE_DD_SELECTED_CSS),
            By.cssSelector(STATE_DD_OPTIONS_CSS),
            By.cssSelector(STATE_DD_OPTIONS_CSS));


    public CreateAccountPage() {
        url = "/create_account";
        title = "Create Account";
    }

    public void fillCreateAccountFormStarFields(User newUser){
        WebElement createAccountForm = getUniqueElement(driver , By.cssSelector(CREATE_ACCOUNT_FORM_CSS));
        /* find all * elements inside Create Account FOrm */
        WebElement firstNameInput = getUniqueElementInBlock(createAccountForm,
                By.cssSelector(FIRST_NAME_INPUT_CSS));
        WebElement lastNameInput = getUniqueElementInBlock(createAccountForm,
                By.cssSelector(LAST_NAME_INPUT_CSS));
        WebElement address1Input = getUniqueElementInBlock(createAccountForm,
                By.cssSelector(ADDRESS_1_INPUT_CSS));
        WebElement postcodeInput = getUniqueElementInBlock(createAccountForm,
                By.cssSelector(POSTCODE_INPUT_CSS));
        WebElement cityInput = getUniqueElementInBlock(createAccountForm,
                By.cssSelector(CITY_INPUT_CSS));
        WebElement emailInput = getUniqueElementInBlock(createAccountForm,
                By.cssSelector(EMAIL_INPUT_CSS));
        WebElement phoneInput = getUniqueElementInBlock(createAccountForm,
                By.cssSelector(PHONE_INPUT_CSS));
        WebElement desiredPasswordInput = getUniqueElementInBlock(createAccountForm,
                By.cssSelector(DESIRED_PASSWORD_INPUT_CSS));
        WebElement confirmPasswordInput = getUniqueElementInBlock(createAccountForm,
                By.cssSelector(CONFIRM_PASSWORD_INPUT_CSS));
        WebElement createAccountBtn = getUniqueElementInBlock(createAccountForm,
                By.cssSelector(CREATE_ACCOUNT_BTN_CSS));
        /* fill all * fields */
        firstNameInput.sendKeys(newUser.firstName);
        lastNameInput.sendKeys(newUser.lastName);
        address1Input.sendKeys(newUser.address1);
        postcodeInput.sendKeys(newUser.postcode);
        cityInput.sendKeys(newUser.city);
        emailInput.sendKeys(newUser.email);
        phoneInput.sendKeys(newUser.phone);
        desiredPasswordInput.sendKeys(newUser.desiredPassword);
        confirmPasswordInput.sendKeys(newUser.confirmPassword);
        countryDropdown.select(driverWait, driver, newUser.country);
        if (newUser.state != null)
            stateDropdown.select(driverWait, driver, newUser.state);
        /* click submit button */
        createAccountBtn.click();
    }

}