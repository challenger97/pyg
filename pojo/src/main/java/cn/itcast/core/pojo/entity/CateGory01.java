package cn.itcast.core.pojo.entity;

import java.io.Serializable;
import java.util.List;

public class CateGory01 implements Serializable{
    String category01Name;
    List<CateGory02> cateGory02list;

    public String getCategory01() {
        return category01Name;
    }

    public void setCategory01(String category01) {
        this.category01Name = category01;
    }

    public List<CateGory02> getCateGory02list() {
        return cateGory02list;
    }

    public void setCateGory02list(List<CateGory02> cateGory02list) {
        this.cateGory02list = cateGory02list;
    }
}
