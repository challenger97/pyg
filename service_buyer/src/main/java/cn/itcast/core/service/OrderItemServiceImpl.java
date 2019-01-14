package cn.itcast.core.service;

import cn.itcast.core.dao.order.OrderItemDao;
import cn.itcast.core.pojo.order.OrderItem;
import cn.itcast.core.pojo.order.OrderItemQuery;
import com.alibaba.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Service
public class OrderItemServiceImpl implements OrderItemService {


    @Autowired
    OrderItemDao orderItemDao;



    @Override
    public List<OrderItem> findById(Long orderId) {
        OrderItemQuery query = new OrderItemQuery();
        OrderItemQuery.Criteria criteria = query.createCriteria();
        criteria.andOrderIdEqualTo(orderId);
        List<OrderItem> orderItemList = orderItemDao.selectByExample(query);


        return orderItemList;
    }
}
