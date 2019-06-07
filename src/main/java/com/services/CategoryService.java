package com.services;

import com.domain.Category;

import java.util.List;

public interface CategoryService {
    //获取指定目录及其次级目录的所有信息
    Category getCurrentLevel(Integer id);
    //获取所有二级目录及其子目录的所有信息
    List<Category> selectLevel();
    //四表联查查询对应目录下的图书的所有信息
    Category catalogAllInfo(Integer catId, Integer curPage);
    //获取总页数
    Integer categoryAllPage(Integer id);
}
