package com.xiaohu.demo.common.page;

import lombok.Data;

import java.util.List;

/**
 * 〈一句话功能简述〉<br>
 * 〈layui 表格显示返回数据〉
 *
 * @author HuTao
 * @create 2019/7/15 14:37
 * @since 1.0.0
 */
@Data
public class LayuiPageResult {

    /**
     * 解析接口状态
     */
    private Integer code;

    /**
     * 解析数据列表
     */
    private List data;

    /**
     * 解析提示文本
     */
    private String msg;

    /**
     * 解析数据长度
     */
    private Long count;

    /**
     * 空的构造方法
     */
    public LayuiPageResult() {
        this.code = 0;
        this.msg="SUCCESS";
    }

    /**
     * 空的构造方法
     */
    public LayuiPageResult(List data) {
        this.code = 0;
        this.msg="SUCCESS";
        this.data = data;
        this.count = Long.valueOf(data.size());
    }
    /**
     * 有参的构造方法
     */
    public LayuiPageResult(Integer code,List data) {
        this.code = code;
        this.msg="SUCCESS";
        this.data = data;
        this.count = Long.valueOf(data.size());
    }
    /**
     * 有参构造方法
     */
    public LayuiPageResult(Integer code,List data,Long count) {
        this.code = code;
        this.msg="SUCCESS";
        this.data = data;
        this.count =count;
    }
}
