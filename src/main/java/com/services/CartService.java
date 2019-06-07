package com.services;

import com.domain.CartItem;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 购物车
 */
public interface CartService {
    //添加到购物车
    public void addCartProduct(int productId, HttpServletRequest request, HttpServletResponse response);
    public List<CartItem> addCartProduct(int productId, int number, HttpServletRequest request, HttpServletResponse response);
    //删除购物车商品
    public void delCartProduct(CartItem cart, int ProductId,HttpServletRequest request,HttpServletResponse response);
    //显示购物车信息
    public List<CartItem> selCart(HttpServletRequest request,HttpServletResponse response);
    public void asdas1();
}
