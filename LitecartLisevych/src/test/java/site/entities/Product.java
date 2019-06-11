package site.entities;

import java.math.BigDecimal;

public class Product {

    /* General Tab */
    public String status;
    public String name;
    public String code;
    public String defaultCategory;
    public String gender;
    public int quantity;
    public String imageFilePath;
    public String dateValidFrom;
    public String dateValidTo;

    /* Information Tab */
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

    public Product(String name){
        this.name = name;
    }

    public Product(Product initialProduct){
        this.name = initialProduct.name;
    }

}
