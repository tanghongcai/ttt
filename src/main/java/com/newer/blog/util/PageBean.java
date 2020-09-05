package com.newer.blog.util;

import java.util.List;

public class PageBean<T> {
    //当前页的数据
    private List<T> data;
    // 总记录数
    private int totalRecords;
    //
    private int pageNo;
    //
    private int pageSize;

    public PageBean() {
    }

    public PageBean(List<T> data, int totalRecords, int pageNo, int pageSize) {
        this.data = data;
        this.totalRecords = totalRecords;
        this.pageNo = pageNo;
        this.pageSize = pageSize;
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }

    public int getTotalRecords() {
        return totalRecords;
    }

    public void setTotalRecords(int totalRecords) {
        this.totalRecords = totalRecords;
    }

    public int getPageNo() {
        return pageNo;
    }

    public void setPageNo(int pageNo) {
        this.pageNo = pageNo;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    @Override
    public String toString() {
        return "PageBean{" +
                "data=" + data +
                ", totalRecords=" + totalRecords +
                ", pageNo=" + pageNo +
                ", pageSize=" + pageSize +
                '}';
    }
}
