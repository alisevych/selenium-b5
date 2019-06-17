package site.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import static org.openqa.selenium.support.ui.ExpectedConditions.*;
import site.elements.CheckboxList;
import site.elements.DropList;
import site.elements.RadioButtons;
import site.entities.Product;

import static helpers.ElementHelper.*;

public class AdminAddNewProductPage extends BasePage {

    /* switch between tabs */
    public static final String GENERAL_TAB_SWITCH_CSS = " [href='#tab-general']";
    public static final String INFORMATION_TAB_SWITCH_CSS = " [href='#tab-information']";
    public static final String PRICES_TAB_SWITCH_CSS = " [href='#tab-prices']";

    /* common objects */
    public static final String  SAVE_BTN_CSS = " [name=save]";

    /* General Tab */
    public static final String GENERAL_TAB_CSS = " #tab-general";
    public static final String STATUS_RB_LABEL_XPATH = "//*[@name='status']/..";
    public static final String NAME_INPUT_CSS = " [name='name[en]']";
    public static final String CODE_INPUT_CSS = " [name=code]";
    public static final String CATEGORIES_CHECKBOXES_XPATH = "//input[@name='categories[]']";
    public static final String CATEGORIES_LABELS_XPATH = "//input[@name='categories[]']/../../td[2]";
    public static final String DEFAULT_CATEGORY_DD_SELECTED_CSS = " [name=default_category_id]";
    public static final String DEFAULT_CATEGORY_DD_SUGGESTIONS_CSS = " [name=default_category_id]>option";
    public static final String GROUPS_CHECKBOXES_XPATH = "//input[@name='product_groups[]']";
    public static final String GROUPS_LABELS_XPATH = "//input[@name='product_groups[]']/../../td[2]";
    public static final String QUANTITY_INPUT_CSS = " [name=quantity]";
    public static final String IMAGE_INPUT_CSS = " input[name='new_images[]']";
    public static final String DATE_VALID_FROM_INPUT_CSS = " [name=date_valid_from]";
    public static final String DATE_VALID_TO_INPUT_CSS = " [name=date_valid_to]";

    /* Information Tab */
    public static final String INFORMATION_TAB_CSS = " #tab-information";
    public static final String MANUFACTURER_SELECTED_CSS = " [name=manufacturer_id]";
    public static final String MANUFACTURER_SUGGESTIONS_CSS = " [name=manufacturer_id]>option";
    public static final String SUPPLIER_SELECTED_CSS = " [name=supplier_id]";
    public static final String SUPPLIER_SUGGESTIONS_CSS = " [name=supplier_id]>option";
    public static final String KEYWORDS_INPUT_CSS  = " [name=keywords]";
    public static final String SHORT_DESCRIPTION_INPUT_CSS  = " [name='short_description[en]']";
    public static final String DESCRIPTION_AREA_CSS  = " .trumbowyg-editor";
    public static final String HEAD_TITLE_INPUT_CSS  = " [name='head_title[en]']";
    public static final String META_DESCRIPTION_INPUT_CSS  = " [name='meta_description[en]']";

    /* Prices Tab */
    public static final String PRICES_TAB_CSS = " #tab-prices";
    public static final String PURCHASE_PRICE_INPUT_CSS  = " [name=purchase_price]";
    public static final String PURCHASE_CURRENCY_SELECTED_CSS = " [name=purchase_price_currency_code]";
    public static final String PURCHASE_CURRENCY_SUGGESTIONS_CSS = " [name=purchase_price_currency_code]>option";
    public static final String PRICE_USD = " [name='prices[USD]']";
    public static final String PRICE_TAX_USD = " [name='gross_prices[USD]']";
    public static final String PRICE_EUR = " [name='prices[EUR]']";
    public static final String PRICE_TAX_EUR = " [name='gross_prices[EUR]']";

    public AdminAddNewProductPage() {
        url = "app=catalog&doc=edit_product";
        title = "Add New Product";
    }

    public void clickGeneralTab(){
        getUniqueElement(driver, By.cssSelector(GENERAL_TAB_SWITCH_CSS))
                .click();
        driverWait.until(presenceOfElementLocated(
                By.cssSelector(NAME_INPUT_CSS)));
    }

    public void switchToInformationTab(){
        getUniqueElement(driver, By.cssSelector(INFORMATION_TAB_SWITCH_CSS))
                .click();
        driverWait.until(presenceOfElementLocated(
                By.cssSelector(DESCRIPTION_AREA_CSS)));
    }

    public void switchToPricesTab(){
        getUniqueElement(driver, By.cssSelector(PRICES_TAB_SWITCH_CSS))
                .click();
        driverWait.until(presenceOfElementLocated(
                By.cssSelector(PURCHASE_PRICE_INPUT_CSS)));
    }

    public void fillGeneralTab (Product product){
        WebElement generalTabForm = getUniqueElement(driver , By.cssSelector(GENERAL_TAB_CSS));
        /* find all * elements inside General Tab Form */
        WebElement nameInput = getUniqueElementInBlock(generalTabForm,
                By.cssSelector(NAME_INPUT_CSS));
        WebElement codeInput = getUniqueElementInBlock(generalTabForm,
                By.cssSelector(CODE_INPUT_CSS));
        RadioButtons statusRadioButtons = new RadioButtons( driver,
                By.xpath(STATUS_RB_LABEL_XPATH));
        CheckboxList categoriesCheckboxList = new CheckboxList(driver,
                By.xpath(CATEGORIES_CHECKBOXES_XPATH),
                By.xpath(CATEGORIES_LABELS_XPATH));
        DropList defaultCategoryDropdown = new DropList( driver,
                By.cssSelector(GENERAL_TAB_CSS + DEFAULT_CATEGORY_DD_SELECTED_CSS),
                By.cssSelector(GENERAL_TAB_CSS + DEFAULT_CATEGORY_DD_SUGGESTIONS_CSS));
        CheckboxList groupsCheckboxList = new CheckboxList(driver,
                By.xpath(GROUPS_CHECKBOXES_XPATH),
                By.xpath(GROUPS_LABELS_XPATH));
        WebElement quantityInput = getUniqueElementInBlock(generalTabForm,
                By.cssSelector(QUANTITY_INPUT_CSS));
        WebElement dateFromInput = getUniqueElementInBlock(generalTabForm,
                By.cssSelector(DATE_VALID_FROM_INPUT_CSS));
        WebElement dateToInput = getUniqueElementInBlock(generalTabForm,
                By.cssSelector(DATE_VALID_TO_INPUT_CSS));
        /* set values from product */
        statusRadioButtons.select(product.status);
        nameInput.sendKeys(product.name);
        codeInput.sendKeys(product.code);
        categoriesCheckboxList.checkByLabelText(product.categories);
        defaultCategoryDropdown.select(product.defaultCategory);
        groupsCheckboxList.checkByLabelText(product.productGroups);
        quantityInput.click();
        quantityInput.clear();
        quantityInput.sendKeys(String.valueOf(product.quantity));
        attachFile(driver,  By.cssSelector(IMAGE_INPUT_CSS), product.imageFilePath);
        dateFromInput.sendKeys(Keys.HOME + product.dateValidFrom);
        dateToInput.sendKeys(Keys.HOME + product.dateValidTo);
    }


    public void fillInformationTab (Product product) {
        WebElement informationTabForm = getUniqueElement(driver, By.cssSelector(INFORMATION_TAB_CSS));
        /* find all * elements inside Information Tab Form */
        DropList manufacturerDropList = new DropList(driver,
                By.cssSelector(MANUFACTURER_SELECTED_CSS),
                By.cssSelector(MANUFACTURER_SUGGESTIONS_CSS));
        DropList supplierDropList = new DropList(driver,
                By.cssSelector(SUPPLIER_SELECTED_CSS),
                By.cssSelector(SUPPLIER_SUGGESTIONS_CSS));
        WebElement keywordsInput = getUniqueElementInBlock(informationTabForm,
                By.cssSelector(KEYWORDS_INPUT_CSS));
        WebElement shortDescriptionInput = getUniqueElementInBlock(informationTabForm,
                By.cssSelector(SHORT_DESCRIPTION_INPUT_CSS));
        WebElement descriptionArea = getUniqueElementInBlock(informationTabForm,
                By.cssSelector(DESCRIPTION_AREA_CSS));
        WebElement headTitleInput = getUniqueElementInBlock(informationTabForm,
                By.cssSelector(HEAD_TITLE_INPUT_CSS));
        WebElement metaDescriptionInput = getUniqueElementInBlock(informationTabForm,
                By.cssSelector(META_DESCRIPTION_INPUT_CSS));
        /* fill fields */
        if (product.manufacturer != null)
            manufacturerDropList.select(product.manufacturer);
        if (product.supplier != null)
            supplierDropList.select(product.supplier);
        keywordsInput.sendKeys(product.keywords);
        shortDescriptionInput.sendKeys(product.shortDescription);
        descriptionArea.sendKeys(product.description);
        headTitleInput.sendKeys(product.headTitle);
        metaDescriptionInput.sendKeys(product.metaDescription);
    }

    public void fillPricesTab (Product product) {
        WebElement pricesTabForm = getUniqueElement(driver, By.cssSelector(PRICES_TAB_CSS));
        /* find all * elements inside Prices Tab Form */
        WebElement purchasePriceInput = getUniqueElementInBlock(pricesTabForm,
                By.cssSelector(PURCHASE_PRICE_INPUT_CSS));
        DropList purchaseCurrencyDropList = new DropList(driver,
                By.cssSelector(PURCHASE_CURRENCY_SELECTED_CSS),
                By.cssSelector(PURCHASE_CURRENCY_SUGGESTIONS_CSS));
        WebElement priceUSDInput = getUniqueElementInBlock(pricesTabForm,
                By.cssSelector(PRICE_USD));
        WebElement priceEURInput = getUniqueElementInBlock(pricesTabForm,
                By.cssSelector(PRICE_EUR));
        /* fill fields */
        purchasePriceInput.sendKeys(CLEAR_KEYS);
        purchasePriceInput.sendKeys(product.purchasePrice.toString());
        purchaseCurrencyDropList.select(product.purchasePriceCurrency);
        priceUSDInput.sendKeys(Keys.HOME + product.priceUSD.toString());
        priceEURInput.sendKeys(Keys.HOME + product.priceEUR.toString());
    }

    public void clickSaveBtn(){
        getUniqueElement(driver, By.cssSelector(SAVE_BTN_CSS))
                .click();
    }
}