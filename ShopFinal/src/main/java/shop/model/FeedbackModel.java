/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shop.model;

import java.io.Serializable;
import java.sql.Date;

/**
 *
 * @author LENOVO
 */
public class FeedbackModel implements Serializable {
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    private Integer feedbackId;
    private UsersModel customerId;
    private ProductModel productId;
    private String description;
    private Date createdAt;

    public FeedbackModel() {
    }

    /**
     * @param feedbackId
     * @param customerId
     * @param productId
     * @param description
     * @param createdAt
     */
    public FeedbackModel(Integer feedbackId, UsersModel customerId, ProductModel productId, String description, Date createdAt) {
        super();
        this.feedbackId = feedbackId;
        this.customerId = customerId;
        this.productId = productId;
        this.description = description;
        this.createdAt = createdAt;
    }

    public Integer getFeedbackId() {
        return feedbackId;
    }

    public void setFeedbackId(Integer feedbackId) {
        this.feedbackId = feedbackId;
    }

    public UsersModel getCustomerId() {
        return customerId;
    }

    public void setCustomerId(UsersModel customerId) {
        this.customerId = customerId;
    }

    public ProductModel getProductId() {
        return productId;
    }

    public void setProductId(ProductModel productId) {
        this.productId = productId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

}
