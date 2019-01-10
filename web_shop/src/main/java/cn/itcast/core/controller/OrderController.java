package cn.itcast.core.controller;

import cn.itcast.core.pojo.entity.PageResult;
import cn.itcast.core.pojo.order.Order;

import com.alibaba.dubbo.config.annotation.Reference;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Reference
    OrderService orderService;


    @RequestMapping("/findAll")
    public List<Order> findAll(){
        String username = SecurityContextHolder.getContext().getAuthentication().getName();

        List<Order> orderList = orderService.findAll(username);
        return orderList;
    }


    @RequestMapping("/findPage")
    public PageResult findPage(Integer page , Integer rows){

        /**获取当前登录的商家id*/
        String username = SecurityContextHolder.getContext().getAuthentication().getName();


        PageResult result = orderService.findPage(username, page, rows);
        return result;

    }

   /* @RequestMapping("/search")
    public PageResult search(@RequestBody Order order,Integer page , Integer rows){
        *//**获取当前登录的商家id*//*
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        order.setSellerId(username);
        PageResult result = orderService.search(order, page, rows);
        return result;
    }*/


}
