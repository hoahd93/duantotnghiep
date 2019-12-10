/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shop.model;

/**
 *
 * @author LENOVO
 */
public class ProductCart {

    private Integer productModelId;
    private Integer productId;
    private Integer colorId;
    private Integer sizeId;
    private Integer stork;
    private Double price;
    private String productName;
    private String productCode;
    private Integer discountRate;
    private String descriptionShort;
    private String description;
    private Integer categoryId;
    private String imageMain;
    private Integer trademarkId;

    public ProductCart() {
    }

    public ProductCart(Integer productModelId, Integer productId, Integer colorId, Integer sizeId, Integer stork, Double price, String productName, String productCode, Integer discountRate, String descriptionShort, String description, Integer categoryId, String imageMain, Integer trademarkId) {
        this.productModelId = productModelId;
        this.productId = productId;
        this.colorId = colorId;
        this.sizeId = sizeId;
        this.stork = stork;
        this.price = price;
        this.productName = productName;
        this.productCode = productCode;
        this.discountRate = discountRate;
        this.descriptionShort = descriptionShort;
        this.description = description;
        this.categoryId = categoryId;
        this.imageMain = imageMain;
        this.trademarkId = trademarkId;
    }

    public Integer getProductModelId() {
        return productModelId;
    }

    public void setProductModelId(Integer productModelId) {
        this.productModelId = productModelId;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public Integer getColorId() {
        return colorId;
    }

    public void setColorId(Integer colorId) {
        this.colorId = colorId;
    }

    public Integer getSizeId() {
        return sizeId;
    }

    public void setSizeId(Integer sizeId) {
        this.sizeId = sizeId;
    }

    public Integer getStork() {
        return stork;
    }

    public void setStork(Integer stork) {
        this.stork = stork;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public Integer getDiscountRate() {
        return discountRate;
    }

    public void setDiscountRate(Integer discountRate) {
        this.discountRate = discountRate;
    }

    public String getDescriptionShort() {
        return descriptionShort;
    }

    public void setDescriptionShort(String descriptionShort) {
        this.descriptionShort = descriptionShort;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public String getImageMain() {
        return imageMain;
    }

    public void setImageMain(String imageMain) {
        this.imageMain = imageMain;
    }

    public Integer getTrademarkId() {
        return trademarkId;
    }

    public void setTrademarkId(Integer trademarkId) {
        this.trademarkId = trademarkId;
    }

  
}
