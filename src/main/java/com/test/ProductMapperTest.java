package com.test;

import com.dao.ProductMapper;
import com.domain.Book;
import com.domain.Product;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;


public class ProductMapperTest {

    private ProductMapper productMapper;


    @Before
    public void setUp() throws Exception {
        //创建IOC容器(因为通过容器获取对象)
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-mybatis.xml");
        productMapper = context.getBean(ProductMapper.class);
    }

    @Test
    public void deleteByPrimaryKey() {
    }

    @Test
    public void insert() {
    }

    @Test
    public void insertSelective() {
    }

    @Test
    public void selectByPrimaryKey() {
        int id = 1;
        Product product = productMapper.selectByPrimaryKey(id);
        System.out.println(product.getId()+","+product.getProductName());
    }

    @Test
    public void selectBookByPrimaryKey(){
        String s = "清华大学出版社";
        List<Product> x = productMapper.selectBookByPrimaryKey(s);
        for (Product p:x) {
            System.out.println(p.getProductName()+","+p.getProductPic()+","+p.getDescription()+","+
                    p.getFixedPrice()+","+p.getDangPrice());
            Book b = p.getBook();
            System.out.println(b.getAuthor()+","+b.getPublishing());
        }
    }

    @Test
    public void updateByPrimaryKeySelective() {
    }

    @Test
    public void updateByPrimaryKey() {
    }

    @Test
    public void selectProduct(){
     List<Product> x = productMapper.selectProduct(8);
        for (Product s:x) {
            System.out.println(s.getProductName()+","+s.getProductPic()+","+s.getFixedPrice()+","+s.getDangPrice());
        }
    }
    @Test
    public void liangbiaochaxun(){
        List<Product> productlist = productMapper.liangbiaochaxun(9);
        for (Product p: productlist) {
            System.out.println(p.getBook().getAuthor());
        }
    }
}