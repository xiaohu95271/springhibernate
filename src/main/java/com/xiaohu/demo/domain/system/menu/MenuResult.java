package com.xiaohu.demo.domain.system.menu;

/**
 * 树形插件返回实体对象
 */

import lombok.Data;

import java.util.List;

/**
 * title	节点标题	                                            String	                未命名
 * id	    节点唯一索引，用于对指定节点进行各类操作	                String/Number	        任意唯一的字符或数字
 * children	子节点。支持设定选项同父节点	                        Array	                [{title: '子节点1', id: '111'}]
 * href	    点击节点弹出新窗口对应的 url。需开启 isJump 参数	        String	                任意 URL
 * spread	节点是否初始展开，默认 false	                        Boolean	                true
 * checked	节点是否初始为选中状态（如果开启复选框的话），默认 false	Boolean             	true
 * disabled 节点是否为禁用状态。默认 false
 * @author hu
 */
@Data
public class MenuResult {


    private String title;
    private String text;
    private String id;
    private List<MenuResult> children;
    private String href;
    private Boolean spread;
    private Boolean checked;
    private Boolean disabled;

}
