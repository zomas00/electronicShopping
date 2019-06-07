package com.dao;

import com.domain.CategoryProduct;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryProductMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(CategoryProduct record);

    int insertSelective(CategoryProduct record);

    CategoryProduct selectByPrimaryKey(Integer id);


    int updateByPrimaryKeySelective(CategoryProduct record);

    int updateByPrimaryKey(CategoryProduct record);
}