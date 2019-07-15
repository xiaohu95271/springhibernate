package com.xiaohu.demo.domain.user;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.transaction.Transactional;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.xiaohu.demo.domain.BaseVO;
import com.xiaohu.demo.domain.system.menu.Menu;
import lombok.Data;

/**
 *  角色实体表
 *
 * @author hu
 */
@Data
@Entity
@Table(name = "common_role")
public class Role extends BaseVO {
	
	private static final long serialVersionUID = 1L;

	/**
	 *  角色名称
	 */
	@Column(name = "name_en", nullable = false)
	private String nameEn;

	/**
	 *  角色名称
	 */
	@Column(name = "name_zh", nullable = false)
	private String nameZh;

	/**
	 *  用户列表
	 */
	@ManyToMany(cascade = CascadeType.MERGE, mappedBy = "roles", fetch = FetchType.LAZY)
	@JsonIgnore
	private Set<User> users;

	/**
	 * 菜单列表
	 */
	@ManyToMany(cascade = CascadeType.PERSIST,fetch = FetchType.EAGER)
	@JoinTable(name = "common_role_menu", joinColumns = { @JoinColumn(name = "role_id",referencedColumnName = "id")}, inverseJoinColumns = { @JoinColumn(name = "menu_id",referencedColumnName = "id")})
	@JsonIgnore
	private Set<Menu> menus;
	
}
