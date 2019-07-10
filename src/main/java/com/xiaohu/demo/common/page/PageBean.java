package com.xiaohu.demo.common.page;

import java.util.ArrayList;
import java.util.List;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author HuTao
 * @create 2019/7/10 17:45
 * @since 1.0.0
 */
public class PageBean<M> {
    private static final long serialVersionUID = -7134980480452601034L;

    /**
     * 当前页
     */
    private Integer page = 1;
    /**
     * 总纪录数
     */
    private Long allCount = 0L;
    /**
     * 总页数
     */
    private Integer allPage = 0;
    /**
     * 每页显示信息数
     */
    private Integer rows = 13;
    /**
     * 纪录集合
     */
    private List<M> result = null;

    /**
     * 纪录集合
     */
    private List<Object[]> resultArray = null;

    /**
     * 是否有上一页
     */
    private boolean isPrePage = false;
    /**
     * 是否有下一页
     */
    private boolean isNextPage = false;
    /**
     * 是否首页
     */
    private boolean isFirstPage = false;
    /**
     * 是否最后一页
     */
    private boolean isLastPage = false;

    /** 模拟百度分页 */
    private List<Integer> pages = null;
    private Integer min = 1;
    private Integer max;
    private Integer pageShowSize = 15;

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Long getAllCount() {
        return allCount;
    }

    public void setAllCount(Long allCount) {
        // 总页数
        this.allPage = (int) (allCount / rows);
        if (allCount % rows != 0) {
            this.allPage = this.allPage + 1;
        }
        // 设置是否有上一页
        if (this.page > 1) {
            this.isFirstPage = true;
            this.isPrePage = true;
        } else {
            this.isFirstPage = false;
            this.isPrePage = false;
        }
        // 设置是否有下一页
        if (this.page < this.allPage) {
            this.isLastPage = true;
            this.isNextPage = true;
        } else {
            this.isLastPage = false;
            this.isNextPage = false;
        }
        // 设置百度页码显示模式
        if (this.page < this.pageShowSize) {
            this.min = 1;
        } else {
            this.min = this.page - this.pageShowSize;
        }
        this.max = this.page + this.pageShowSize;
        if (this.min <= 0) {
            this.min = 1;
        }
        if (this.max > this.allPage) {
            this.max = this.allPage;
        }
        this.pages = new ArrayList<Integer>();
        for (Integer i = this.min; i <= this.max; i++) {
            pages.add(i);
        }
        this.allCount = allCount;
    }

    public Integer getAllPage() {
        return allPage;
    }

    public void setAllPage(Integer allPage) {

        this.allPage = allPage;
    }

    public Integer getRows() {
        return rows;
    }

    public void setRows(Integer rows) {
        this.rows = rows;
    }

    public List<M> getResult() {
        return result;
    }

    public void setResult(List<M> result) {
        this.result = result;
    }

    public List<Object[]> getResultArray() {
        return resultArray;
    }

    public void setResultArray(List<Object[]> resultArray) {
        this.resultArray = resultArray;
    }

    public boolean isPrePage() {
        return isPrePage;
    }

    public void setPrePage(boolean isPrePage) {
        this.isPrePage = isPrePage;
    }

    public boolean isNextPage() {
        return isNextPage;
    }

    public void setNextPage(boolean isNextPage) {
        this.isNextPage = isNextPage;
    }

    public boolean isFirstPage() {
        return isFirstPage;
    }

    public void setFirstPage(boolean isFirstPage) {
        this.isFirstPage = isFirstPage;
    }

    public boolean isLastPage() {
        return isLastPage;
    }

    public void setLastPage(boolean isLastPage) {
        this.isLastPage = isLastPage;
    }

    public List<Integer> getPages() {
        return pages;
    }

    public void setPages(List<Integer> pages) {
        this.pages = pages;
    }

    public Integer getMin() {
        return min;
    }

    public void setMin(Integer min) {
        this.min = min;
    }

    public Integer getMax() {
        return max;
    }

    public void setMax(Integer max) {
        this.max = max;
    }

    public Integer getPageShowSize() {
        return pageShowSize;
    }

    public void setPageShowSize(Integer pageShowSize) {
        this.pageShowSize = pageShowSize;
    }
}
