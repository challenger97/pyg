package cn.itcast.core.service;

import cn.itcast.core.pojo.entity.PageResult;
import cn.itcast.core.pojo.seckill.SeckillOrder;

import java.util.List;

public interface SeckillOrderServicd {

    public PageResult findPage(SeckillOrder seckillOrder, Integer page , Integer rows);

    public List<SeckillOrder> findAll();
}
