package com.services;

import com.domain.Product;

import java.util.List;

public interface ProductService {
    //根据出版社查找两本图书的所有信息
    public List<Product> getBookInfo(String publishing);
    //查询product的部分信息，根据时间越靠近现在的时间越是最新上架的书籍(最新上架)
    List<Product> selectProductInfo(Integer num);
    //根据销售量获取前6本书的信息（热销图书）
    List<Product> selectNumberProductInfo(Integer num);
}
