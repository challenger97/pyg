package cn.itcast.core.service;

import cn.itcast.core.pojo.ad.Content;
import cn.itcast.core.pojo.entity.PageResult;

import java.util.List;

public interface ContentService {


    public List<Content> findAll();

    public PageResult findPage(Content content, Integer page, Integer rows);

    public void add(Content content);

    public Content findOne(Long id);

    public void update(Content content);

    public void delete(Long[] ids);

    public List<Content> findByCategoryId(Long categoryId);

    public List<Content> findByCategoryIdFromRedis(Long categoryId);


<<<<<<< HEAD
    List<FloorContent> findFloorContent();

    public List qaz();
    public List<CateGory01> selectCategoryTree();
=======
>>>>>>> bc7aa0ad456680fd664c9564f1b6ee28835dfdd0
}
