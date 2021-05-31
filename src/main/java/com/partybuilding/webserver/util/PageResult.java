package com.partybuilding.webserver.util;


import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description:  分页数据封装类
 */
public class PageResult<T>{
    private Integer total;
    private List<T> list;

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }
}
