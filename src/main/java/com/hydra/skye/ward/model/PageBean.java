package com.hydra.skye.ward.model;

import java.io.Serializable;

/**
 * Created by yahto on 20/03/2018
 */
public class PageBean implements Serializable {

    private static final long serialVersionUID = -3671200661698301791L;

    private Integer pageIndex;
    private Integer pageSize;
    private Long pageMax;
    private Long counts;

    public PageBean() {
        this.pageIndex = 1;
        this.pageSize = 10;
    }

    public Integer getPageIndex() {
        return pageIndex;
    }

    public void setPageIndex(Integer pageIndex) {
        this.pageIndex = pageIndex;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Long getPageMax() {
        return pageMax;
    }

    public void setPageMax(Long pageMax) {
        this.pageMax = pageMax;
    }

    public Long getCounts() {
        return counts;
    }

    public void setCounts(Long counts) {
        this.counts = counts;
    }
}
