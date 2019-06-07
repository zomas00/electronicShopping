package com.services;

import com.dao.CategoryMapper;
import com.domain.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService{
    @Autowired
    private CategoryMapper mapper;
    @Override
    public Category getCurrentLevel(Integer id) {
        Category category = mapper.selectOneLevel(id);
        List<Category> list = category.getCategoryList();
        if (list.size()>0){
            return category;
        }else{
            return null;
        }
    }

    @Override
    public List<Category> selectLevel() {
        List<Category> category = mapper.selectLevel();
        if (category.size()>0){
            return category;
        }else{
            return null;
        }
    }

    @Override
    public Category catalogAllInfo(Integer catId, Integer curPage) {
        Category category = mapper.catalogAllInfo(catId,curPage);
        return category;
    }

    @Override
    public Integer categoryAllPage(Integer id) {
        //判断总页数若余数小于5则总页数加1
        Integer integer = mapper.categoryAllPage(id);
        Integer allPage = integer/5;
        allPage = (integer%5)<5&&(integer%5)>0?allPage+1:allPage;
        return allPage;
    }
}
