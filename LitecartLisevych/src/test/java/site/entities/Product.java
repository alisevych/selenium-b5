package site.entities;

import java.io.File;
import java.math.BigDecimal;
import java.util.List;

public class Product {

    /* General Tab */
    public String status;
    public String name;
    public String code;
    public List<String> categories;
    public String defaultCategory;
    public List<String> productGroups;
    public int quantity;
    public String imageFilePath;
    public String dateValidFrom;
    public String dateValidTo;

    /* Information Tab */
    public String manufacturer;
    public String supplier;
    public String keywords;
    public String shortDescription;
    public String description;
    public String headTitle;
    public String metaDescription;

    /* Prices Tab */
    public BigDecimal purchasePrice;
    public String purchasePriceCurrency;
    public BigDecimal priceUSD;
    public BigDecimal priceTaxUSD;
    public BigDecimal priceEUR;
    public BigDecimal priceTaxEUR;

    public Product(String name, String code, String status,
                   List<String> categories, String defaultCategory,
                   List<String> productGroups, int quantity,
                   String imageFileName,
                   String dateValidFrom, String dateValidTo,
                   String manufacturer, String supplier,
                   String keywords, String shortDescription,
                   String description, String headTitle,
                   String metaDescription,
                   BigDecimal purchasePrice, String purchasePriceCurrency,
                   BigDecimal priceUSD, BigDecimal priceEUR
    ){
        this.name = name;
        this.code = code;
        this.status = status;
        this.categories = categories;
        this.defaultCategory = defaultCategory;
        this.productGroups = productGroups;
        this.quantity = quantity;
        this.imageFilePath = new File(imageFileName).getAbsolutePath().replaceAll("\\\\", "\\\\\\\\");
        this.dateValidFrom = dateValidFrom;
        this.dateValidTo = dateValidTo;
        /* information tab */
        this.manufacturer = manufacturer;
        this.supplier = supplier;
        this.keywords = keywords;
        this.shortDescription = shortDescription;
        this.description = description;
        this.headTitle = headTitle;
        this.metaDescription = metaDescription;
        /* prices tab */
        this.purchasePrice = purchasePrice;
        this.purchasePriceCurrency = purchasePriceCurrency;
        this.priceUSD = priceUSD;
        this.priceEUR = priceEUR;
    }

    public Product(Product initialProduct){
        this.name = initialProduct.name;
        this.code = initialProduct.code;
        this.status = initialProduct.status;
        this.categories = initialProduct.categories;
        this.defaultCategory = initialProduct.defaultCategory;
        this.productGroups = initialProduct.productGroups;
        this.quantity = initialProduct.quantity;
        this.imageFilePath = initialProduct.imageFilePath;
        this.dateValidFrom = initialProduct.dateValidFrom;
        this.dateValidTo = initialProduct.dateValidTo;
        /* information tab */
        this.manufacturer = initialProduct.manufacturer;
        this.supplier = initialProduct.supplier;
        this.keywords = initialProduct.keywords;
        this.shortDescription = initialProduct.shortDescription;
        this.description = initialProduct.description;
        this.headTitle = initialProduct.headTitle;
        this.metaDescription = initialProduct.metaDescription;
        /* prices tab */
        this.purchasePrice = initialProduct.purchasePrice;
        this.purchasePriceCurrency = initialProduct.purchasePriceCurrency;
        this.priceUSD = initialProduct.priceUSD;
        this.priceEUR = initialProduct.priceEUR;
    }

}
