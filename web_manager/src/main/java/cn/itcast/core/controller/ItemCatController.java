package cn.itcast.core.controller;

import cn.itcast.core.pojo.entity.PageResult;
import cn.itcast.core.pojo.entity.Result;
import cn.itcast.core.pojo.item.ItemCat;
import cn.itcast.core.service.ItemCatService;
import com.alibaba.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/itemCat")
public class ItemCatController {

    @Reference
    private ItemCatService catService;

    @RequestMapping("/updateStatus")
    public Result updateStatus(Long[] ids,Integer auditStatus){
        try {
            if (ids!=null){
                for (Long id : ids) {
                    catService.updateStatus(id,auditStatus);
                }
            }
            return new Result(true,"审核成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false,"审核失败");
        }

    }


    @RequestMapping("/search")
    public PageResult search(Integer rows,Integer page){
        PageResult pageResult = catService.findPage(null, rows, page);
        return pageResult;
    }



    @RequestMapping("/findByParentId")
    public List<ItemCat> findByParentId(Long parentId) {
        List<ItemCat> list = catService.findByParentId(parentId);
        return list;
    }

    @RequestMapping("/findAll")
    public List<ItemCat> findAll() {
        return catService.findAll();
    }

    @RequestMapping("/findPage")
    public PageResult findPage(@RequestBody ItemCat itemCat, Integer page,Integer rows){
        PageResult result = catService.findPage(null, page, rows);
        return result;
    }
}
