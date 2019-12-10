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
public class CategoryModel implements Serializable {
    /**
    * 
    */
    private Integer categoryId;
    private String nameCategory;
    private Integer parentId;
    private String image;
    private Date createDate;
    private Date updateDate;
    private Integer delFlg;

    public CategoryModel() {
    }

    public CategoryModel(Integer categoryId, String nameCategory, Integer parentId, String image, Date createDate, Date updateDate, Integer delFlg) {
        this.categoryId = categoryId;
        this.nameCategory = nameCategory;
        this.parentId = parentId;
        this.image = image;
        this.createDate = createDate;
        this.updateDate = updateDate;
        this.delFlg = delFlg;
    }

    public CategoryModel(Integer categoryId, String nameCategory, String image) {
        this.categoryId = categoryId;
        this.nameCategory = nameCategory;
        this.image = image;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public String getNameCategory() {
        return nameCategory;
    }

    public void setNameCategory(String nameCategory) {
        this.nameCategory = nameCategory;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
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
