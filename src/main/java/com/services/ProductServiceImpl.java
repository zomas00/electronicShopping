package com.services;

import com.dao.ProductMapper;
import com.domain.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ProductServiceImpl implements ProductService{

    //依赖属性mapper(记得按照名称或者类型进行自动装配，这里呢按类型自动装配)
    @Autowired
    private ProductMapper mapper;

    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    @Override
    public List<Product> getBookInfo(String publishing) {
        List<Product> list = mapper.selectBookByPrimaryKey(publishing);
        list = list.subList(0,2);
        return list;
    }
    //最新上架
    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    @Override
    public List<Product> selectProductInfo(Integer num) {
        List<Product> list = mapper.selectProduct(num);
        return list;
    }
    //热销图书
    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    @Override
    public List<Product> selectNumberProductInfo(Integer num) {
        List<Product> list = mapper.selectNumberProduct(num);
        return list;
    }
}
