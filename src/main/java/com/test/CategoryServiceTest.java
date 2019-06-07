package com.test;

import com.domain.Category;
import com.domain.CategoryBookProduct;
import com.services.CategoryService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring-mybatis.xml")
public class CategoryServiceTest {

    @Autowired
    private CategoryService service;

    @Test
    public void getTwoLevel() {
        Category x = service.getCurrentLevel(2);
        List<Category> list = x.getCategoryList();
        System.out.println(x.getName());
        for (Category c:list) {
            System.out.println(c.getName());
        }
    }
    @Test
    public void selectLevel(){
        List<Category> x = service.selectLevel();
        for (Category x1:x) {
            System.out.println(x1.getName());
            List<Category> list = x1.getCategoryList();
            for (Category c:list) {
                System.out.println(c.getName());
            }
        }
    }
    @Test
    public void catalogAllInfo(){
        Category category = service.catalogAllInfo(10,2);
        List<CategoryBookProduct> list = category.getProductList();
        System.out.println(category.getName());
        for (CategoryBookProduct x: list) {
            System.out.print(x.getProductName()+",");
            System.out.println(x.getAuthor());
        }
    }
    @Test
    public void categoryAllPage(){
        Integer allPage = service.categoryAllPage(9);
        System.out.println(allPage);
    }
}