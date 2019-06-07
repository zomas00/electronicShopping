package com.domain;

import java.io.Serializable;
import java.util.List;

/**
 * d_category
 * @author 
 */
public class Category implements Serializable {
    private Integer id;

    private Integer turn;

    private String enName;

    private String name;

    private String description;

    private Integer parentId;

    private static final long serialVersionUID = 1L;

    //关联属性
    private List<Category> categoryList;
    //关联属性
    private List<CategoryBookProduct> productList;

    public List<CategoryBookProduct> getProductList() {
        return productList;
    }

    public void setProductList(List<CategoryBookProduct> productList) {
        this.productList = productList;
    }

    public List<Category> getCategoryList() {
        return categoryList;
    }

    public void setCategoryList(List<Category> categoryList) {
        this.categoryList = categoryList;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getTurn() {
        return turn;
    }

    public void setTurn(Integer turn) {
        this.turn = turn;
    }

    public String getEnName() {
        return enName;
    }

    public void setEnName(String enName) {
        this.enName = enName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }
}