package cn.itcast.core.service;

import cn.itcast.core.dao.seckill.SeckillOrderDao;
import cn.itcast.core.pojo.entity.PageResult;
import cn.itcast.core.pojo.seckill.SeckillOrder;
import cn.itcast.core.pojo.seckill.SeckillOrderQuery;
import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@Transactional
public class SeckillOrderServiceImpl implements SeckillOrderServicd {

    @Autowired
    SeckillOrderDao seckillOrderDao;

    @Override
    public PageResult findPage(SeckillOrder seckillOrder, Integer page, Integer rows) {
        PageHelper.startPage(page, rows);
        SeckillOrderQuery query = new SeckillOrderQuery();
        SeckillOrderQuery.Criteria criteria = query.createCriteria();

        Page<SeckillOrder> seckillOrderList = (Page<SeckillOrder>)seckillOrderDao.selectByExample(query);
        return new PageResult(seckillOrderList.getTotal(), seckillOrderList.getResult());
    }

    @Override
    public List<SeckillOrder> findAll() {
        return seckillOrderDao.selectByExample(null);
    }
}
