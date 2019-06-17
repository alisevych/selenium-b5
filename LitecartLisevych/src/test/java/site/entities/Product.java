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
                   String imageFileName){
        this.name = name;
        this.code = code;
        this.status = status;
        this.categories = categories;
        this.defaultCategory = defaultCategory;
        this.productGroups = productGroups;
        this.quantity = quantity;
        File imageFile = new File(imageFileName);
        this.imageFilePath = imageFile.getAbsolutePath();
    }

    public Product(Product initialProduct){
        this.name = initialProduct.name;
        this.code = initialProduct.code;
        this.status = initialProduct.status;
        this.categories = initialProduct.categories;
        this.defaultCategory = initialProduct.defaultCategory;
        this.productGroups = initialProduct.productGroups;
    }

}
