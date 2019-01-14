import cn.itcast.core.dao.ad.ContentDao;
import cn.itcast.core.dao.order.OrderDao;
import cn.itcast.core.pojo.ad.Content;
import cn.itcast.core.pojo.ad.ContentQuery;
import cn.itcast.core.pojo.order.Order;
import cn.itcast.core.pojo.order.OrderQuery;
import cn.itcast.core.util.Constants;
import cn.itcast.core.util.DateUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.management.Query;
import java.math.BigDecimal;
import java.util.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath*:spring/applicationContext*.xml")
public class testDao {

    @Autowired
    ContentDao contentDao;

    @Autowired
    RedisTemplate redisTemplate;

    @Autowired
    OrderDao orderDao;


    @Test
    public void getResul(){

        List<Map> list = contentDao.selectFloorContentName(1L);
        Map redismap=new HashMap();
        for (Map map : list) {
            Object title = map.get("title");
            ContentQuery query = new ContentQuery();
            ContentQuery.Criteria criteria = query.createCriteria();
            criteria.andTitleEqualTo(String.valueOf(title));
            List<Content> list1 = contentDao.selectByExample(query);
            redismap.put(title,list1);
        }
        redisTemplate.boundHashOps(Constants.FLOORCONTENT_lIST_REDIS).putAll(redismap);
    }

    @Test
    public void getMap(){

        Map entries = redisTemplate.boundHashOps(Constants.FLOORCONTENT_lIST_REDIS).entries();
        for (Object o : entries.keySet()) {
            System.out.println(o+"===="+entries.get(o));
        }
        System.out.println(entries);
    }

    @Test
    public void getResult(){

        Date today = new Date();

        Long time = today.getTime();
        Long startTime=time-1000*60*60*24*2;
        Long yesterday=time-1000*60*60*24;
        Date yesday=new Date(yesterday);
        Date startDay=new Date(startTime);
        List<Date> periodOfTime = DateUtils.getPeriodOfTime(startDay, today);

        List<Order> orsers = getOrsers(yesday, today);
        System.out.println(orsers.size());


    }

    public List<Order> getOrsers(Date startDate,Date endDate){
        OrderQuery query = new OrderQuery();
        OrderQuery.Criteria criteria = query.createCriteria();

        String s = DateUtils.formatDateToStr(new Date());
        System.out.println(s);


        List<Order> orders = orderDao.selectByExample(query);
        return orders;
    }

    @Test
    public void add(){
        Date daysAgo = getDaysAgo(7, new Date());
        Order order = new Order();
        order.setPayment(new BigDecimal(1000));
        order.setStatus("1");
        order.setCreateTime(daysAgo);
        orderDao.insertSelective(order);

    }


    @Test
    public void selectTotalPayment(){

        List<Map> orders = orderDao.selectByOneDay("2017-10-12");
        for (Map order : orders) {
            System.out.println(order);
        }
    }


    public Date getDaysAgo(Integer day,Date date){
        Long time = date.getTime();

        Long startTime=time-1000*60*60*24*(day-1);


        return new Date(startTime);

    }

    public List<String> getDateList(Date start,Date end ){
        ArrayList<String> list = new ArrayList<String>();
        //获取日期集合
        List<Date> periodOfTime = DateUtils.getPeriodOfTime(start, end);

        for (Date date : periodOfTime) {
            String s = DateUtils.formatDateToStr(date);
            list.add(s);
        }
        return list;
    }

    @Test
    public void tesss(){
        //获当前Date
        Date today = new Date();

        //获取三天前时间
        Date agoDays=getDaysAgo(7,today);

        List<String> dateList = getDateList(agoDays, today);

        ArrayList<Map> returnList = new ArrayList<Map>();

        for (String date : dateList) {
            BigDecimal total = new BigDecimal(0);

            Map map=new HashMap();

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
            map.put(date,total);
            returnList.add(map);
        }
        for (Map map : returnList) {
            System.out.println(map);
        }
    }






}
