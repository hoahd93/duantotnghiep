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
public class OrderDetailModel implements Serializable {
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    private Integer id;
    private Integer orderId;
    private Integer productModelId;
    private String productName;
    private Double price;
    private Integer quantity;
    private Integer discountRate;
    private Date createdAt;

    public OrderDetailModel() {
    }

    /**
     * @param id
     * @param orderId
     * @param productModelId
     * @param productName
     * @param price
     * @param quantity
     * @param discountRate
     * @param createdAt
     */
    public OrderDetailModel(Integer id, Integer orderId, Integer productModelId, String productName, Double price, Integer quantity, Integer discountRate,
            Date createdAt) {
        super();
        this.id = id;
        this.orderId = orderId;
        this.productModelId = productModelId;
        this.productName = productName;
        this.price = price;
        this.quantity = quantity;
        this.discountRate = discountRate;
        this.createdAt = createdAt;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Integer getProductModelId() {
        return productModelId;
    }

    public void setProductModelId(Integer productModelId) {
        this.productModelId = productModelId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Integer getDiscountRate() {
        return discountRate;
    }

    public void setDiscountRate(Integer discountRate) {
        this.discountRate = discountRate;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

}
