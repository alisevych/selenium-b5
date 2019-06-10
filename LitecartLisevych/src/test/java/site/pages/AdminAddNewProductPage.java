package site.pages;

import org.openqa.selenium.By;
import site.customE.Dropdown;

public class AdminAddNewProductPage extends BasePage {

    /* switch between tabs */
    public static final String GENERAL_TAB_SWITCH_CSS = " [href=#tab-general]";
    public static final String INFORMATION_TAB_SWITCH_CSS = " [href=#tab-information]";
    public static final String PRICES_TAB_SWITCH_CSS = " [href=#tab-prices]";

    /* General Tab */
    public static final String GENERAL_TAB_CSS = " #tab-general";
    public static final String NAME_INPUT_CSS = " [name='name[en]']";
    public static final String CODE_INPUT_CSS = " [name=code]";
    public static final String DEFAULT_CATEGORY_DD_SELECTED_CSS = " [name=default_category_id]";
    public static final Dropdown defaultCategoryDropdown = new Dropdown(
            By.cssSelector(GENERAL_TAB_CSS + DEFAULT_CATEGORY_DD_SELECTED_CSS));
    public static final String GENDER_FEMALE_CHECKBOX_CSS = " [type=checkbox][value='1-2']";
    public static final String GENDER_MALE_CHECKBOX_CSS = " [type=checkbox][value='1-1']";
    public static final String GENDER_UNISEX_CHECKBOX_CSS = " [type=checkbox][value='1-3']";
    public static final String QUANTITY_INPUT_CSS = " [name=quantity]";
    public static final String CHOOSE_FILE_BTN_CSS = " [name='new_images[]']";
    public static final String DATE_VALID_FROM_INPUT_CSS = " [name=date_valid_from]";
    public static final String DATE_VALID_TO_INPUT_CSS = " [name=date_valid_to]";

    /* Information Tab */
    public static final String INFORMATION_TAB_CSS = " #tab-information";
    public static final String KEYWORDS_INPUT_CSS  = " [name=keywords]";
    public static final String SHORT_DESCRIPTION_INPUT_CSS  = " [name='short_description[en]']";
    public static final String DESCRIPTION_AREA_CSS  = " .trumbowyg-editor";
    public static final String HEAD_TITLE_INPUT_CSS  = " [name='head_title[en]']";
    public static final String META_DESCRIPTION_INPUT_CSS  = " [name='meta_description[en]']";

    /* Prices Tab */
    public static final String PRICES_TAB_CSS = " #tab-prices";
    public static final String PURCHASE_PRICE_INPUT_CSS  = " [name=purchase_price]";
    public static final String PURCHASE_PRICE_CURRENCY_INPUT_CSS  = " [name=purchase_price_currency_code]";
    public static final String PRICE_USD = " [name='prices[USD]']";
    public static final String PRICE_TAX_USD = " [name='gross_prices[USD]']";
    public static final String PRICE_EUR = " [name='prices[EUR]']";
    public static final String PRICE_TAX_EUR = " [name='gross_prices[EUR]']";

    public AdminAddNewProductPage() {
        url = "app=catalog&doc=edit_product";
        title = "Add New Product";
    }

}