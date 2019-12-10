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
public class SizeModel implements Serializable {
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    private Integer sizeId;
    private String sizeName;
    private Date createDate;
    private Date updateDate;
    private Integer delFlg;

    public SizeModel() {
    }

    /**
     * @param sizeId
     * @param sizeName
     * @param createDate
     * @param updateDate
     * @param delFlg
     */
    public SizeModel(Integer sizeId, String sizeName, Date createDate, Date updateDate, Integer delFlg) {
        super();
        this.sizeId = sizeId;
        this.sizeName = sizeName;
        this.createDate = createDate;
        this.updateDate = updateDate;
        this.delFlg = delFlg;
    }

    public Integer getSizeId() {
        return sizeId;
    }

    public void setSizeId(Integer sizeId) {
        this.sizeId = sizeId;
    }

    public String getSizeName() {
        return sizeName;
    }

    public void setSizeName(String sizeName) {
        this.sizeName = sizeName;
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
