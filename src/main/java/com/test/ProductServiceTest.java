package com.test;

import com.domain.Book;
import com.domain.Product;
import com.services.ProductService;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class ProductServiceTest {

    private ProductService service;

    @Before
    public void setUp() throws Exception {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-mybatis.xml");
        service = context.getBean(ProductService.class);
    }

    @Test
    public void getBookInfo() {
        String s = "清华大学出版社";
        List<Product> x = service.getBookInfo(s);
        for (Product p:x) {
            System.out.println(p.getProductName()+","+p.getProductPic()+","+p.getDescription()+","+
                    p.getFixedPrice()+","+p.getDangPrice());
            Book b = p.getBook();
            System.out.println(b.getAuthor()+","+b.getPublishing());
        }
    }
    @Test
    public void selectProductInfo(){
        int num = 8;
        List<Product> x = service.selectProductInfo(num);
        for (Product p:x) {
            System.out.println(p.getProductName()+","+p.getProductPic()+","+p.getFixedPrice()+","+p.getDangPrice());
        }
    }
    @Test
    public void selectNumberProductInfo(){
        int num = 6;
        List<Product> x = service.selectNumberProductInfo(num);
        for (Product p:x) {
            System.out.println(p.getIsum()+"本,"+p.getProductName()+","+p.getProductPic()+","+p.getFixedPrice()+","+p.getDangPrice());
        }
    }
}