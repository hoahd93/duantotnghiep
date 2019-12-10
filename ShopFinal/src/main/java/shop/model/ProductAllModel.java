/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shop.model;

import java.io.Serializable;
import java.util.Base64;
import java.util.Date;

/**
 *
 * @author admin
 */
public class ProductAllModel implements Serializable{
    private Integer productModelId;
    private Integer productId;
    private String name;
    private String productCode;
    private Integer categoryId;
    private Integer colorId;
    private Integer sizeId;
    private Integer stock;
    private Double price;
    private Integer discountRate;
    private String descriptionShort;
    private String description;
    private String imgMain;
    private String img1;
    private String img2;
    private String img3;
    private String img4;
    private Integer trademarkId;
    private Date createdAt;
    private Date updateDate;
    private Integer delFlg;

    public ProductAllModel() {
    }

    public ProductAllModel(Integer productModelId, Integer productId, String name, String productCode, Integer categoryId, Integer colorId, Integer sizeId, Integer stock, Double price, Integer discountRate, String descriptionShort, String description, String imgMain, String img1, String img2, String img3, String img4, Integer trademarkId, Date createdAt, Date updateDate, Integer delFlg) {
        this.productModelId = productModelId;
        this.productId = productId;
        this.name = name;
        this.productCode = productCode;
        this.categoryId = categoryId;
        this.colorId = colorId;
        this.sizeId = sizeId;
        this.stock = stock;
        this.price = price;
        this.discountRate = discountRate;
        this.descriptionShort = descriptionShort;
        this.description = description;
        this.imgMain = imgMain;
        this.img1 = img1;
        this.img2 = img2;
        this.img3 = img3;
        this.img4 = img4;
        this.trademarkId = trademarkId;
        this.createdAt = createdAt;
        this.updateDate = updateDate;
        this.delFlg = delFlg;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
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

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
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

    public String getImgMain() {
        return imgMain;
    }

    public void setImgMain(String imgMain) {
        this.imgMain = imgMain;
    }

    public String getImg1() {
        return img1;
    }

    public void setImg1(String img1) {
        this.img1 = img1;
    }

    public String getImg2() {
        return img2;
    }

    public void setImg2(String img2) {
        this.img2 = img2;
    }

    public String getImg3() {
        return img3;
    }

    public void setImg3(String img3) {
        this.img3 = img3;
    }

    public String getImg4() {
        return img4;
    }

    public void setImg4(String img4) {
        this.img4 = img4;
    }

    public Integer getTrademarkId() {
        return trademarkId;
    }

    public void setTrademarkId(Integer trademarkId) {
        this.trademarkId = trademarkId;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public Integer getDelFlg() {
        return delFlg;
    }

    public void setDelFlg(Integer delFlg) {
        this.delFlg = delFlg;
    }

}
