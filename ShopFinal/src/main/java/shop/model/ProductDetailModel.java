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
 * @author LENOVO
 */
public class ProductDetailModel implements Serializable {

    private static final long serialVersionUID = 1L;
    private Integer productDetailId;
    private Integer productId;
    private Integer colorId;
    private Integer sizeId;
    private Integer stock;
    private Double price;
    private Date createDate;
    private Date updateDate;
    private Integer delFlg;

    public ProductDetailModel() {
    }

    public ProductDetailModel(Integer productDetailId, Integer productId, Integer colorId, Integer sizeId, Integer stock, Double price, Date createDate, Date updateDate, Integer delFlg) {
        this.productDetailId = productDetailId;
        this.productId = productId;
        this.colorId = colorId;
        this.sizeId = sizeId;
        this.stock = stock;
        this.price = price;
        this.createDate = createDate;
        this.updateDate = updateDate;
        this.delFlg = delFlg;
    }

    public Integer getProductDetailId() {
        return productDetailId;
    }

    public void setProductDetailId(Integer productDetailId) {
        this.productDetailId = productDetailId;
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

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
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
