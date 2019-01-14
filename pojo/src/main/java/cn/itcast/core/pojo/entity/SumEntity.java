package cn.itcast.core.pojo.entity;

import java.io.Serializable;
import java.math.BigDecimal;

public class SumEntity implements Serializable{
    String date;
    BigDecimal total;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }
}
