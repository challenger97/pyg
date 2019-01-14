package cn.itcast.core.pojo.entity;



import cn.itcast.core.pojo.item.ItemCat;

import java.io.Serializable;
import java.util.List;

public class CateGory02 implements Serializable {

    String category02Name;
    List<ItemCat> category03List;

    public String getCategory02Name() {
        return category02Name;
    }

    public void setCategory02Name(String category02Name) {
        this.category02Name = category02Name;
    }

    public List<ItemCat> getCategory03List() {
        return category03List;
    }

    public void setCategory03List(List<ItemCat> category03List) {
        this.category03List = category03List;
    }
}
