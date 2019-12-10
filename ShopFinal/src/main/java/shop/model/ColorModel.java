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
public class ColorModel implements Serializable {
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    private Integer colorId;
    private String nameColor;
    private Date createDate;
    private Date updateDate;
    private Integer delFlg;

    public ColorModel() {
    }

    /**
     * @param colorId
     * @param nameColor
     * @param createDate
     * @param updateDate
     * @param delFlg
     */
    public ColorModel(Integer colorId, String nameColor, Date createDate, Date updateDate, Integer delFlg) {
        super();
        this.colorId = colorId;
        this.nameColor = nameColor;
        this.createDate = createDate;
        this.updateDate = updateDate;
        this.delFlg = delFlg;
    }

    public Integer getColorId() {
        return colorId;
    }

    public void setColorId(Integer colorId) {
        this.colorId = colorId;
    }

    public String getNameColor() {
        return nameColor;
    }

    public void setNameColor(String nameColor) {
        this.nameColor = nameColor;
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
