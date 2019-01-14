package cn.itcast.core.controller;

import cn.itcast.core.pojo.ad.Content;
import cn.itcast.core.pojo.entity.CateGory01;
import cn.itcast.core.pojo.entity.FloorContent;
import cn.itcast.core.service.ContentService;
import com.alibaba.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/content")
public class ContentController {

    @Reference
    private ContentService contentService;

    @RequestMapping("/findByCategoryId")
    public Map findByCategoryId(Long categoryId) {
        List<Content> list = contentService.findByCategoryIdFromRedis(categoryId);

        List<FloorContent> floorContents=contentService.findFloorContent();

        List<CateGory01> cateGoryList = contentService.selectCategoryTree();
        Map map=new HashMap();

        map.put("contentList",list);
        map.put("floorContentList",floorContents);
        map.put("categoryList",cateGoryList);


        return map;
    }

    @RequestMapping("/findCategorys")
    public List selectCategoryTree(){
        List<CateGory01> list = contentService.selectCategoryTree();
        return list;
    }
}
