package com.services;


import com.dao.ProductMapper;
import com.domain.CartItem;
import com.domain.Product;
import com.utils.CookieUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class CartServiceImpl implements CartService{

    @Autowired
    private ProductMapper mapper;
    @Autowired
    private RedisTemplate redisTemplate;
    //添加商品到购物车（未登录cookie版）
    @Override
    public void addCartProduct(int productId,HttpServletRequest request, HttpServletResponse response) {
        //判断是否有这个购物车的cookieId（没有就创建一个）
        //不管怎么样都要去redis中取出这个购物车进行匹配商品（必须要有List）里面
        //进行判断是否有如果有就取出来没有就创建一个
        //如果没有这个购物车先创建cookieId的同时创建这个购物车的List对象
        List<CartItem> cartItems = selCart(request,response);
        System.out.println(cartItems+"X:1111xxxxxxxxxxxxxxx");
        //cookie的Id
        String id = getCartId(request,response);
        System.out.println(cartItems+"X:22222xxxxxxxxxxxxxxx");


        System.out.println(cartItems+"X:33333xxxxxxxxxxxxxxx");
        //创建一个cartItem对象用于存储新商品
        CartItem cartItem;
        //判断购物车商品列表中是否存在此商品,如果不存在就添加新商品
        if(cartItems.size()!=0){
            System.out.println(cartItems);
            for (CartItem c:cartItems) {
                System.out.println(cartItems+"X:44444xxxxxxxxxxxxxxx");
                //如果存在该商品,就只增加数量
                System.out.println(c.getProductId());
                System.out.println(productId);
                System.out.println("是否存在该商品的判断："+(c.getProductId() == productId));
                if (c.getProductId()==productId){
                    //这里的问题如何修改redis中的某个属性我通过获取之前他的购物车判断
                    // 是否有这个商品如果有number+1，其次通过opsForList的set方法将这个对象覆盖，但是第二个参数是索引
                    // 不太好拿，****因为商品编号是唯一的所以每个商品只会有一个对象所以直接通过list的indexof方法获取第一次出现的索引
                    //然后执行覆盖就好了   贼机智！！！！！！！！！
                    c.setNumber(c.getNumber()+1);
                    redisTemplate.opsForList().set(id,cartItems.indexOf(c),c);
                    System.out.println(cartItems+"X:55555xxxxxxxxxxxxxxx");
                    break;
                }//不能用else必须要这个集合走完所有属性否则可能出现里面明明有这个对象但是缺没有查出来
                else if (c.getProductId()!= productId && cartItems.lastIndexOf(c) == cartItems.size()-1){
                    System.out.println(cartItems+"X:888888xxxxxxxxxxxxxxx");
                    cartItem = addProduct(productId);
                    //因为CartItem中的数据都来自product表，
                    //是直接用product获取数值还是单独建造一个Mapper对应购物车呢
                    //添加到购物车
                    //将购物车转换为json放入redis中
                    //尽然没有这个商品直接追加就好了
                    redisTemplate.opsForList().rightPush(id,cartItem);
                    System.out.println("新添加之后的："+cartItem.getProductName());
                    break;
                }
            }
        }else{
            cartItem = addProduct(productId);
            //因为CartItem中的数据都来自product表，
            //是直接用product获取数值还是单独建造一个Mapper对应购物车呢
            //添加到购物车
            //添加到购物车
            cartItems.add(cartItem);
            redisTemplate.opsForList().rightPush(id,cartItem);

        }
    }
    //修改商品数量（未登录cookie版）

    public List<CartItem> addCartProduct(int productId, int number, HttpServletRequest request, HttpServletResponse response) {
        List<CartItem> cartItems = selCart(request,response);
        String id = getCartId(request,response);
        for (CartItem c:cartItems) {
            if (c.getProductId()==productId){
                c.setNumber(number);
                redisTemplate.opsForList().set(id,cartItems.indexOf(c),c);
                break;
            }
        }
        return cartItems;
    }
    //删除商品（未登录cookie版）
    @Override
    public void delCartProduct(CartItem cart, int productId,HttpServletRequest request,HttpServletResponse response) {
        List<CartItem> cartItems = selCart(request,response);
        for (CartItem c:cartItems) {
            if (c.getProductId() == productId){
                cartItems.remove(c);
            }
        }

    }
    //从redis中获取购物车的数据（未登录cookie版本）
    @Override
    public List<CartItem> selCart(HttpServletRequest request,HttpServletResponse response) {
        String id = getCartId(request,response);
        if (id!=null) {
            System.out.println("wqeqweqweqwewqeqwe");
            List<CartItem> cartItems =  redisTemplate.opsForList().range(id,0,-1);
            return cartItems;
        }
        System.out.println("1231231231231231");
        return new ArrayList<>();
    }

    //获取cookie中的对应未登录时候的购物车的id
    public String getCartId(HttpServletRequest request,HttpServletResponse response){
        //从cookie中取出购物车所对应的cookieid
        String cartId = CookieUtils.getCookieValue(request,"cart");
        if (cartId==null){
            cartId = UUID.randomUUID().toString();
            //把购物车存储在redis中的key写入cookie
            CookieUtils.setCookie(request,response,"cart",cartId);
        }
        return cartId;

    }
    @Override
    public void asdas1(){
        redisTemplate.opsForValue().set("xxxx","wqe");
    }

    public CartItem addProduct(int productId){
        CartItem cartItem = new CartItem();
        //因为CartItem中的数据都来自product表，
        //是直接用product获取数值还是单独建造一个Mapper对应购物车呢
        Product product = mapper.selectByPrimaryKey(productId);
        cartItem.setProductId(productId);
        cartItem.setDangPrice(product.getDangPrice());
        cartItem.setProductName(product.getProductName());
        cartItem.setNumber(1);
        cartItem.setProductPic(product.getProductPic());
    return cartItem;
    }
}
