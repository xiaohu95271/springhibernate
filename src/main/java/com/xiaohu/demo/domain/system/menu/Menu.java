package com.xiaohu.demo.domain.system.menu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.xiaohu.demo.domain.BaseVO;
import com.xiaohu.demo.domain.user.Role;
import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

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

    /**
     * 角色列表
     */
    @ManyToMany(mappedBy = "menus")
    @JsonIgnore
    private Set<Role> roles;

    /**
     * 辅助
     */
    @Transient
    private List<Menu> children = new ArrayList<Menu>();


    @Transient
    @JsonIgnore
    private Menu parentMenu;
}
