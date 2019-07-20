package com.xiaohu.demo.common.result;

import lombok.Data;

import java.util.LinkedList;
import java.util.List;

/**
 * 〈一句话功能简述〉<br>
 * 〈layui文件上传的返回值〉
 *
 * @author HuTao
 * @create 2019/7/19 13:29
 * @since 1.0.0
 */
@Data
public class FileResult {
    /**
     * {
     *   "code": 0
     *   ,"msg": ""
     *   ,"data": {
     *     "src": "http://cdn.layui.com/123.jpg"
     *   }
     * }
     *
     */
    private Integer code;
    private String msg;
    private String filePath;
    List data = new LinkedList();

    public FileResult(Integer code, String msg,String filePath, List data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
        this.filePath = filePath;
    }
    public FileResult(Integer code, String filePath) {
        this.code = code;
        this.msg = "";
        this.data = new LinkedList();
        this.filePath = filePath;
    }

    public FileResult( String filePath) {
        this.code = 0;
        this.msg = "";
        this.data = new LinkedList();
        this.filePath = filePath;
    }

    public FileResult() {
        this.code = 0;
        this.msg = "";
        this.data = new LinkedList();
        this.filePath = "";
    }

    public static FileResult success(String filePath){
        return new FileResult(0,filePath);
    }
    public static FileResult error(String filePath){
        return new FileResult(500,filePath);
    }
}
