package com.xiaohu.demo.domain.system.menu;

import com.xiaohu.demo.domain.BaseVO;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * 菜单实体类
 *
 * @author 13220
 */
@Entity
@Table(name = "sys_menu")
@Data
public class Menu extends BaseVO {

    /**
     * 名称
     */
    private String name;
    /**
     * 图标路径
     */
    private String icon;
    /**
     * 父级id
     */
    private String pid;
    /**
     * 菜单连接
     */
    private String href;
    /**
     * 备注
     */
    private String remark;
    /**
     * 排序
     */
    private Integer orderNumber;
}
