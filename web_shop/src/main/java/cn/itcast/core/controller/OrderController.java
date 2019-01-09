package cn.itcast.core.controller;

import cn.itcast.core.pojo.entity.PageResult;
import cn.itcast.core.pojo.order.Order;
import cn.itcast.core.service.OrderService;
import com.alibaba.dubbo.config.annotation.Reference;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Reference
    private OrderService orderService;


    @RequestMapping("/search")
    public PageResult search(@RequestBody Order order, Integer page , Integer rows){

        /**获取当前登录的商家id*/
        String sellerId = SecurityContextHolder.getContext().getAuthentication().getName();
        order.setSellerId(sellerId);

        PageResult result = orderService.findPage(order, page, rows);
        return result;

    }


}
