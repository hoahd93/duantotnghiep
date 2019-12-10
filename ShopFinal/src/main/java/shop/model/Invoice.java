/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shop.model;

import java.io.Serializable;

/**
 *
 * @author LENOVO
 */
public class Invoice implements Serializable{
    private Integer invoiceId;
    private String dateTime;
    private Integer quantity;
    private Double totalPrice;
    private String month;

    public Invoice(){
        
    }

    public Invoice(Integer invoiceId, String dateTime, Integer quantity, Double totalPrice, String month) {
        this.invoiceId = invoiceId;
        this.dateTime = dateTime;
        this.quantity = quantity;
        this.totalPrice = totalPrice;
        this.month = month;
    }
    
    public Integer getInvoiceId() {
        return invoiceId;
    }

    public void setInvoiceId(Integer invoiceId) {
        this.invoiceId = invoiceId;
    }

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }
    
}
