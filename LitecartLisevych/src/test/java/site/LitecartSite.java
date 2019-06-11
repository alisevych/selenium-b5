package site;

import site.pages.*;

public class LitecartSite {

    /* Admin pages */
    public static AdminHomePage adminHomePage = new AdminHomePage();
    public static AdminCountriesPage adminCountriesPage = new AdminCountriesPage();
    public static AdminEditCountryPage adminEditCountryPage = new AdminEditCountryPage();
    public static AdminGeoZonesPage adminGeoZonesPage = new AdminGeoZonesPage();
    public static AdminEditGeoZonePage adminEditGeoZonePage = new AdminEditGeoZonePage();
    public static AdminCatalogPage adminCatalogPage = new AdminCatalogPage();
    public static AdminAddNewProductPage adminAddNewProductPage = new AdminAddNewProductPage();

    /* Online Store pages */
    public static MainPage mainPage = new MainPage();
    public static ProductPage productPage = new ProductPage();
    public static CreateAccountPage createAccountPage = new CreateAccountPage();
}
