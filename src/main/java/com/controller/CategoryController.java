package com.controller;

import com.domain.Category;
import com.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    private CategoryService service;

    //显示左栏页面

    //左栏的分类目录
    @RequestMapping("/hierarchicaldirectory")
    public String leftHierarchicalDirectory(Model model){
        List<Category> category = service.selectLevel();
        model.addAttribute("category",category);
        return "leftPage";
    }
    //左栏局部刷新（显示当前目录及其子目录）
    @RequestMapping("/leftCurrentDirectory")
    public String leftCurrentDirectory(@RequestParam("CatId") Integer id, Model model){
//        System.out.println(id);
//        System.out.println("到底进来没有啊！！！！！！！！！！！");
        Category category = service.getCurrentLevel(id);
//        System.out.println(category.getName());
        model.addAttribute("category",category);
        return "leftCurrentPage";
    }
    //分页的返回值
    @RequestMapping("/pagingquery")
    public String pagingQuery(@RequestParam("CatId") Integer catId,
                              @RequestParam("CurPage") Integer curPage,
                              Model model){
        Category category = service.catalogAllInfo(catId,curPage);
        Integer allPage  = service.categoryAllPage(catId);
        model.addAttribute("category",category);
        model.addAttribute("allPage",allPage);
        model.addAttribute("curPage",curPage);
        return "rightPagingQuery";
    }
}
