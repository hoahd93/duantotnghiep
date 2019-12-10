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
public class TrademarkModel implements Serializable {
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    private Integer trademarkId;
    private String trademarkName;
    private Date createDate;
    private Date updateDate;
    private Integer delFlg;

    public TrademarkModel() {
    }

    /**
     * @param trademarkId
     * @param trademarkName
     * @param createDate
     * @param updateDate
     * @param delFlg
     */
    public TrademarkModel(Integer trademarkId, String trademarkName, Date createDate, Date updateDate, Integer delFlg) {
        super();
        this.trademarkId = trademarkId;
        this.trademarkName = trademarkName;
        this.createDate = createDate;
        this.updateDate = updateDate;
        this.delFlg = delFlg;
    }

    public Integer getTrademarkId() {
        return trademarkId;
    }

    public void setTrademarkId(Integer trademarkId) {
        this.trademarkId = trademarkId;
    }

    public String getTrademarkName() {
        return trademarkName;
    }

    public void setTrademarkName(String trademarkName) {
        this.trademarkName = trademarkName;
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
