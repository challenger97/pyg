package cn.itcast.core.controller;

import cn.itcast.core.pojo.entity.PageResult;
import cn.itcast.core.pojo.order.Order;

import cn.itcast.core.pojo.order.OrderItem;
import cn.itcast.core.service.OrderItemService;
import cn.itcast.core.service.OrderService;
import com.alibaba.dubbo.config.annotation.Reference;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Reference
    OrderService orderService;

    @Reference
    OrderItemService orderItemService;

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

    /***
     * 先根据页面传递的时间段到order表中查询对应订单的id集合,
     * 再根据订单的id到order_item表中查询订单详情(商品详情title,单价price,数量num,总价totle_fee)
     * @return
     */

    @RequestMapping("/findById")
    public List findById(Date start, Date end){
        List idList = findIdByTime(start, end);
        ArrayList<OrderItem> list = new ArrayList<>();
        if (idList!=null){
            for (Object id : idList) {
                List<OrderItem> orderItemList = orderItemService.findById(Long.valueOf(String.valueOf(id)));
                for (OrderItem orderItem : orderItemList) {
                    if (orderItem!=null){
                        list.add(orderItem);
                    }
                }

            }
        }

        return list;

    }




    @RequestMapping("/findIdByTime")
    public List findIdByTime(Date start,Date end){

        List idList = orderService.findIdByTime(start, end);
        return idList;
    }

}
