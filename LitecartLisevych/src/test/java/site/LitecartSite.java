package site;

import site.pages.AdminCountriesPage;
import site.pages.AdminGeoZonesPage;
import site.pages.AdminHomePage;
import site.pages.MainPage;

public class LitecartSite {

    /* Admin pages */
    public static AdminHomePage adminHomePage = new AdminHomePage();
    public static AdminCountriesPage adminCountriesPage = new AdminCountriesPage();
    public static AdminGeoZonesPage adminGeoZonesPage = new AdminGeoZonesPage();

    /* Online Store pages */
    public static MainPage mainPage = new MainPage();

}
