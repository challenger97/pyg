package cn.itcast.core.controller;


import cn.itcast.core.pojo.entity.PageResult;
import cn.itcast.core.pojo.good.Brand;
import cn.itcast.core.pojo.seckill.SeckillOrder;
import cn.itcast.core.service.SeckillOrderServicd;
import com.alibaba.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/seckillOrder")
public class SeckillOrderController {

    @Reference
    SeckillOrderServicd seckillOrderServicd;


    /**
     * 分页查询
     * @param page 当前页
     * @param rows 每页展示数据条数
     * @return
     */
    @RequestMapping("/findPage")
    public PageResult findPage(Integer page, Integer rows) {
        PageResult result = seckillOrderServicd.findPage(null, page, rows);
        return result;
    }

    @RequestMapping("/findAll")
    public List<SeckillOrder> findAll() {
        return seckillOrderServicd.findAll();
    }


    @RequestMapping("/search")
    public PageResult search(@RequestBody SeckillOrder seckillOrder, Integer page, Integer rows) {
        PageResult result = seckillOrderServicd.findPage(seckillOrder, page, rows);
        return result;
    }
}
