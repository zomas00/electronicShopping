package com.dao;

import com.domain.Category;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Category record);

    int insertSelective(Category record);

    Category selectByPrimaryKey(Integer id);
    //获取当前目录的子目录所有信息
    Category selectOneLevel(Integer id);
    //获取所有二级目录及其子目录的所有信息
    List<Category> selectLevel();
    //四表联查查询对应目录下的图书的所有信息
    Category catalogAllInfo(@Param("catId") Integer catId, @Param("curPage") Integer curPage);
    //获取该目录下的所有图书的个数
    Integer categoryAllPage(Integer id);
    int updateByPrimaryKeySelective(Category record);

    int updateByPrimaryKey(Category record);
}