package cn.itcast.core.service;

import cn.itcast.core.pojo.entity.PageResult;
import cn.itcast.core.pojo.log.PayLog;
import cn.itcast.core.pojo.order.Order;

import java.util.List;

public interface OrderService {

    public void add(Order order);

    public PayLog getPayLogByUserName(String username);

    public void updatePayStatus(String username);

    public List<Order> findAll(String username);

    public PageResult findPage(String username, Integer page , Integer rows);

    /*public PageResult search(Order order,Integer page , Integer rows);*/
}
