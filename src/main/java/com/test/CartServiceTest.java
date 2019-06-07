package com.test;

import com.domain.CartItem;
import com.services.CartService;
import com.services.CartServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import javax.servlet.http.HttpServletRequest;

@RunWith(SpringRunner.class)
@ContextConfiguration(locations = "classpath*:/spring-mybatis.xml")
public class CartServiceTest {

    @Autowired
    private CartService cartService;

    @Test
    public void addCartProduct() {
    }

    @Test
    public void editCartProduct() {
    }

    @Test
    public void delCartProduct() {
    }

    @Test
    public void selCart() {
    }
    @Test
    public void asdas1(){
        cartService.asdas1();
    }
}