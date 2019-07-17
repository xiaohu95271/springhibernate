package com.xiaohu.demo.common;


import lombok.Data;

import java.util.LinkedList;
import java.util.List;

/**
 * 基础返回工具类
 * @author 13220
 */
@Data
public class BaseResult {

    /**
     * 返回码
     */
    private Integer code;
    /**
     * 返回信息
     */
    private String msg;
    /**
     * 返回数据
     */
    private List data;

    public BaseResult() {
        this.code = 0;
        this.msg = "";
        this.data = new LinkedList();
    }

    /**
     * 只有状态码
     * @param code 状态码
     */
    public BaseResult(Integer code) {
        this.code = code;
        this.msg = "";
        this.data = new LinkedList();
    }
    /**
     * 只有状态码和信息
     * @param code 状态码
     * @param msg 信息
     */
    public BaseResult(Integer code,String msg) {
        this.code = code;
        this.msg = msg;
        this.data = new LinkedList();
    }

    /**
     * 全有
     * @param code 状态码
     * @param msg 信息
     * @param data 数据
     */
    public BaseResult(Integer code,String msg,List data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    /**
     * 成功返回信息
     * @return
     */
    public static  BaseResult success(){
        return new BaseResult();
    }


    /**
     * 成功返回信息
     * @return
     */
    public static  BaseResult success(Integer code){
        return new BaseResult(code);
    }

    /**
     * 成功返回信息
     * @return
     */
    public static  BaseResult success(Integer code,String msg){
        return new BaseResult(code,msg);
    }

    /**
     * 成功返回信息
     * @return
     */
    public static  BaseResult success(Integer code,String msg,List data){
        return new BaseResult(code,msg,data);
    }
    /**
     * 错误返回信息
     *  状态码默认 500
     * @return
     */
    public static  BaseResult error(){
        return new BaseResult(500);
    }


    /**
     * 错误返回信息
     * @return
     */
    public static  BaseResult error(Integer code){
        return new BaseResult(code);
    }

    /**
     * 错误返回信息
     * @return
     */
    public static  BaseResult error(Integer code,String msg){
        return new BaseResult(code,msg);
    }

    /**
     * 错误返回信息
     * @return
     */
    public static  BaseResult error(Integer code,String msg,List data){
        return new BaseResult(code,msg,data);
    }
}
