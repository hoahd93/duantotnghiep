/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shop.model;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author admin
 */
public class ProductModel implements Serializable {

    private Integer productId;
    private String name;
    private String productCode;
    private Integer discountRate;
    private String descriptionShort;
    private String description;
    private Integer categoryId;
    private String imgMain;
    private String img1;
    private String img2;
    private String img3;
    private String img4;
    private Integer trademarkId;
    private java.util.Date createdAt;
    private java.util.Date updateDate;
    private Integer delFlg;

    public ProductModel() {
    }

    public ProductModel(Integer productId, String name, String productCode, Integer discountRate, String descriptionShort, String description, Integer categoryId, String imgMain, String img1, String img2, String img3, String img4, Integer trademarkId, Date createdAt, Date updateDate, Integer delFlg) {
        this.productId = productId;
        this.name = name;
        this.productCode = productCode;
        this.discountRate = discountRate;
        this.descriptionShort = descriptionShort;
        this.description = description;
        this.categoryId = categoryId;
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
