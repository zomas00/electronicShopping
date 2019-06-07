package com.controller;


import com.domain.CartItem;
import com.services.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
@RequestMapping("/cart")
public class CartController {
    @Autowired
    private CartService cartService;
    //只是添加一个商品进入购物车
    @RequestMapping("/add")
    public void addCartItem( @RequestParam Integer productId,
                              HttpServletRequest request, HttpServletResponse response) {
         cartService.addCartProduct(productId, request, response);
    }
    //显示购物车信息
    @RequestMapping("/show")
    public String  showCartItem(HttpServletRequest request, HttpServletResponse response){
        List<CartItem> listcart = cartService.selCart(request,response);
        request.setAttribute("listcart",listcart);
    return "cart";
    }
    @RequestMapping("/cartPage")
    public String cartPage(){
        return "cart";
    }
    @RequestMapping("/editNumber")
    @ResponseBody
    public List<CartItem> addCartItemNumber(@RequestParam Integer productId,
                                  @RequestParam Integer number,
                                  HttpServletRequest request,
                                  HttpServletResponse response){
        List<CartItem> cartItems = cartService.addCartProduct(productId,number,request,response);
       return cartItems;
    }
}
