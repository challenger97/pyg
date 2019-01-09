package cn.itcast.core.pojo.entity;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

public class CateGory02 implements Serializable {

    String category02Name;
    List<Map> category03List;

    public String getCategory02Name() {
        return category02Name;
    }

    public void setCategory02Name(String category02Name) {
        this.category02Name = category02Name;
    }

    public List<Map> getCategory03List() {
        return category03List;
    }

    public void setCategory03List(List<Map> category03List) {
        this.category03List = category03List;
    }
}
