package com.domain;

import java.io.Serializable;

/**
 * d_category_product
 * @author 
 */
public class CategoryProduct implements Serializable {
    private Integer id;

    private Integer productId;

    private Integer catId;
//    //关联属性
//    private Integer Category

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public Integer getCatId() {
        return catId;
    }

    public void setCatId(Integer catId) {
        this.catId = catId;
    }
}