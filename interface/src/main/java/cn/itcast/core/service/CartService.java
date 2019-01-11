package cn.itcast.core.service;


import cn.itcast.core.pojo.entity.Cart;

import java.util.List;

public interface CartService {

    public List<Cart> addItemToCartList(List<Cart> cartList, Long itemId, Integer num);

    public  void setCartListToRedis(String userName, List<Cart> cartList);

    public List<Cart> getCartListFromRedis(String userName);

    public List<Cart> mergeCookieCartListToRedisCartList(List<Cart> cookieCartList, List<Cart> redisCartList);
}
