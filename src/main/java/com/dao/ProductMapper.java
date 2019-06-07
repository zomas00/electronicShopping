package com.dao;

import com.domain.Product;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Product record);

    int insertSelective(Product record);

    Product selectByPrimaryKey(Integer id);
    //获取推荐的图书信息
    List<Product> selectBookByPrimaryKey(String publishing);
    //查询product的部分信息(最新上架)
    List<Product> selectProduct(Integer num);
    //查询两表联查（热销图书）
    List<Product> selectNumberProduct(Integer num);
    //三表表查询
    List<Product> liangbiaochaxun(Integer id);
    int updateByPrimaryKeySelective(Product record);

    int updateByPrimaryKey(Product record);
}