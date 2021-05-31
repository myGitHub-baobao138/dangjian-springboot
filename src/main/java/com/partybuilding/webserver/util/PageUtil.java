package com.partybuilding.webserver.util;

import org.apache.poi.ss.formula.functions.T;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description: 手动分页组件
 */
public class PageUtil<T> {
    private Integer total;
    private Integer currentPage;
    private Integer pageSize;
    private List<T> list;

    public PageUtil(Integer currentPage,Integer pageSize,List<T> list){
        this.setCurrentPage(currentPage);
        this.setPageSize(pageSize);
        this.setList(list);
        this.setTotal(list.size());

        // 切分数组
        getPageList();

    }

    private void getPageList(){
        if(this.total == 0){
            list = new ArrayList<>();
        } else {
            Integer startIndex = (this.currentPage -1) * this.pageSize;
            List<T> list1 = new ArrayList<T>();
            if(startIndex < this.total){ // 正常的下标
                if(startIndex + this.pageSize <= this.total){
                    list1 = this.list.subList(startIndex, startIndex + this.pageSize);
                } else {
                    list1 = this.list.subList(startIndex, this.total);
                }
            } else { // 返回最后一页
                if(this.total > this.pageSize){
                    int remain = this.total % this.pageSize;
                    list1 = this.list.subList(this.total - remain, this.total);
                } else { // 只有一页
                    list1 = this.list.subList(0, this.total);
                }

            }
            setList(list1);
        }
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = (total == null) ? 0 : total;
    }

    public Integer getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(Integer currentPage) {

        this.currentPage = currentPage <= 0 ? 1: currentPage;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize <= 0 ? 1: pageSize;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }
}
