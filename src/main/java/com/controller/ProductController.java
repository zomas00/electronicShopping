package com.controller;

import com.domain.Product;
import com.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private ProductService service;
    //显示首页
    @RequestMapping("/main")
    public String showMain(){
        return "mainPage";
    }
    //编辑推荐
    @RequestMapping("/recommend")
    public String RecommendInfo(Model model){
        String publishing = "清华大学出版社";
        List<Product> list = service.getBookInfo(publishing);
        model.addAttribute("productList",list);
        return "recommendInfoPage";
    }
    //热销图书
    @RequestMapping("/sellwell")
    public String sellWellBook(Model model){
        int num = 6;
        List<Product> list = service.selectNumberProductInfo(num);
        model.addAttribute("productListSell",list);
        return "sellWellBook";
    }
    //最新上架
    @RequestMapping("/newarrival")
    public String newarrivalInfo(Model model){
        int num = 6;
        List<Product> list = service.selectProductInfo(num);
        model.addAttribute("productListNew",list);
        return "newArrival";
    }
}
