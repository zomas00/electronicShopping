package com.domain;

import java.io.Serializable;

/**
 * d_product
 * @author 
 */
public class Product implements Serializable {
    private Integer id;

    private String productName;

    private String description;

    private Long addTime;

    private Double fixedPrice;

    private Double dangPrice;

    private String keywords;

    private Integer hasDeleted;

    private String productPic;

    //附加属性
    private Integer isum;

    //关联属性
    private Book book;

    private static final long serialVersionUID = 1L;

    public Integer getIsum() {
        return isum;
    }

    public void setIsum(Integer isum) {
        this.isum = isum;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getAddTime() {
        return addTime;
    }

    public void setAddTime(Long addTime) {
        this.addTime = addTime;
    }

    public Double getFixedPrice() {
        return fixedPrice;
    }

    public void setFixedPrice(Double fixedPrice) {
        this.fixedPrice = fixedPrice;
    }

    public Double getDangPrice() {
        return dangPrice;
    }

    public void setDangPrice(Double dangPrice) {
        this.dangPrice = dangPrice;
    }

    public String getKeywords() {
        return keywords;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }

    public Integer getHasDeleted() {
        return hasDeleted;
    }

    public void setHasDeleted(Integer hasDeleted) {
        this.hasDeleted = hasDeleted;
    }

    public String getProductPic() {
        return productPic;
    }

    public void setProductPic(String productPic) {
        this.productPic = productPic;
    }
}