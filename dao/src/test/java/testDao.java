import cn.itcast.core.dao.ad.ContentDao;
import cn.itcast.core.pojo.ad.Content;
import cn.itcast.core.pojo.ad.ContentQuery;
import cn.itcast.core.util.Constants;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath*:spring/applicationContext*.xml")
public class testDao {

    @Autowired
    ContentDao contentDao;

    @Autowired
    RedisTemplate redisTemplate;


    @Test
    public void getResul(){

        List<Map> list = contentDao.selectFloorContentName(5L);
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
}
