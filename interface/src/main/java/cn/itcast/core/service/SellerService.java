package cn.itcast.core.service;

import cn.itcast.core.pojo.entity.PageResult;
<<<<<<< HEAD
import cn.itcast.core.pojo.entity.Result;
import cn.itcast.core.pojo.entity.SumEntity;
=======
import cn.itcast.core.pojo.entity.ResultMessage;
>>>>>>> bc7aa0ad456680fd664c9564f1b6ee28835dfdd0
import cn.itcast.core.pojo.seller.Seller;

import java.util.List;
import java.util.Map;

public interface SellerService {

    public void add(Seller seller);


    public PageResult findPage(Seller seller,Integer page,Integer rows);

    public Seller findOne(String id);

    public void updateStatus(String sellerId, String status);

    public List<SumEntity> selectTotalPayment();
}
