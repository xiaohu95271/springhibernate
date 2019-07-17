package com.xiaohu.demo.domain.system.menu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.xiaohu.demo.domain.BaseVO;
import com.xiaohu.demo.domain.user.Role;
import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Set;

/**
 * 菜单实体类
 *
 * @author 13220
 */
@Entity
@Table(name = "sys_menu")
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Integer getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(Integer orderNumber) {
        this.orderNumber = orderNumber;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public List<Menu> getChildren() {
        return children;
    }

    public void setChildren(List<Menu> children) {
        this.children = children;
    }

    public Menu getParentMenu() {
        return parentMenu;
    }

    public void setParentMenu(Menu parentMenu) {
        this.parentMenu = parentMenu;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {return true;}
        if (o == null || getClass() != o.getClass()) {return false;}
        if (!super.equals(o)) {return false;}
        Menu menu = (Menu) o;
        return Objects.equals(name, menu.name) &&
                Objects.equals(icon, menu.icon) &&
                Objects.equals(pid, menu.pid) &&
                Objects.equals(href, menu.href) &&
                Objects.equals(remark, menu.remark) &&
                Objects.equals(orderNumber, menu.orderNumber) &&
                Objects.equals(roles, menu.roles) &&
                Objects.equals(children, menu.children) &&
                Objects.equals(parentMenu, menu.parentMenu);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), name, icon, pid, href, remark, orderNumber, roles, children, parentMenu);
    }
}
