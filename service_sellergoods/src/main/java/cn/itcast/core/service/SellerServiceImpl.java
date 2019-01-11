package cn.itcast.core.service;

import cn.itcast.core.dao.order.OrderDao;
import cn.itcast.core.dao.seller.SellerDao;
import cn.itcast.core.pojo.entity.PageResult;
import cn.itcast.core.pojo.entity.SumEntity;
import cn.itcast.core.pojo.order.OrderQuery;
import cn.itcast.core.pojo.seller.Seller;
import cn.itcast.core.pojo.seller.SellerQuery;
import cn.itcast.core.util.DateUtils;
import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.auditing.IsNewAwareAuditingHandler;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.*;

@Service
@Transactional
public class SellerServiceImpl implements SellerService {

    @Autowired
    private SellerDao sellerDao;

    @Autowired
    private OrderDao orderDao;

    @Override
    public void add(Seller seller) {
        seller.setCreateTime(new Date());
        //审核状态注册的时候默认为0 ,未审核
        seller.setStatus("0");
        sellerDao.insertSelective(seller);
    }

    @Override
    public PageResult findPage(Seller seller, Integer page, Integer rows) {
        PageHelper.startPage(page, rows);
        SellerQuery query = new SellerQuery();
        SellerQuery.Criteria criteria = query.createCriteria();
        if (seller != null) {
            if (seller.getStatus() != null && !"".equals(seller.getStatus())) {
                criteria.andStatusEqualTo(seller.getStatus());
            }
            if (seller.getName() != null && !"".equals(seller.getName())){
                criteria.andNameLike("%"+seller.getName()+"%");
            }
            if (seller.getNickName() != null && !"".equals(seller.getNickName())) {
                criteria.andNickNameLike("%"+seller.getNickName()+"%");
            }
        }

        Page<Seller> sellerList = (Page<Seller>)sellerDao.selectByExample(query);
        return new PageResult(sellerList.getTotal(), sellerList.getResult());
    }

    @Override
    public Seller findOne(String id) {
        return sellerDao.selectByPrimaryKey(id);
    }

    @Override
    public void updateStatus(String sellerId, String status) {
        Seller seller = new Seller();
        seller.setStatus(status);
        seller.setSellerId(sellerId);
        sellerDao.updateByPrimaryKeySelective(seller);
    }
    @Override
    public List<SumEntity> selectTotalPayment(){
        //获当前Date
        Date today = new Date();

        //获取三天前时间
        Date agoDays=getDaysAgo(7,today);

        List<String> dateList = getDateList(agoDays, today);

        ArrayList<SumEntity> returnList = new ArrayList<>();

        for (String date : dateList) {
            BigDecimal total = new BigDecimal(0);


            SumEntity entity = new SumEntity();

            List<Map> list = orderDao.selectByOneDay(date);
            for (Map order : list) {
                Object payment = order.get("payment");
                if (payment==null){
                    total.add(new BigDecimal(0));
                }else {
                    BigDecimal pay= (BigDecimal) payment;
                    total= total.add(pay);
                }
            }
            entity.setDate(date);
            entity.setTotal(total);

            returnList.add(entity);
        }

        return returnList;

    }

    public Date getDaysAgo(Integer day,Date date){
        Long time = date.getTime();

        Long startTime=time-1000*60*60*24*(day-1);


        return new Date(startTime);

    }

    public List<String> getDateList(Date start,Date end ){
        ArrayList<String> list = new ArrayList<>();
        //获取日期集合
        List<Date> periodOfTime = DateUtils.getPeriodOfTime(start, end);

        for (Date date : periodOfTime) {
            String s = DateUtils.formatDateToStr(date);
            list.add(s);
        }
        return list;
    }


}
