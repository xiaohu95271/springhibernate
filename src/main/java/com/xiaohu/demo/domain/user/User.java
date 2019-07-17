package com.xiaohu.demo.domain.user;

import com.xiaohu.demo.common.DateUtil;
import com.xiaohu.demo.common.StringUtil;
import com.xiaohu.demo.domain.BaseVO;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

/**
 * 用户信息表
 * @author Administrator
 *
 */
@Entity
@Table(name = "common_user")
public class User extends BaseVO {

	/**
	 *  用户帐号
	 */
	private String userCode;
	/**
	 * 手机号
	 */
	private String mobile;
	/**
	 * 姓名
	 */
	private String name;
	/**
	 * /性别 女；男
	 */
	private String sex;
	/**
	 *  密码
	 */
	private String password;
	/**
	 * 密码盐
	 */
	private String salt = StringUtil.generateCheckCode(4);
	/**
	 * 最后一次登录时间
	 */
	private String lastLoginTime;
	/**
	 * /用户头像
	 */
	private String headimg;

	/**
	 * 所属公司
	 */
	private String companyId;

	/**
	 * 用户角色
	 */
	@ManyToMany(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
	@JoinTable(name = "common_user_role", joinColumns = { @JoinColumn(name = "user_id", referencedColumnName = "id") },
			inverseJoinColumns = { @JoinColumn(name = "role_id", referencedColumnName = "id") })
	private Set<Role> roles = new HashSet<Role>();


	/**
	 * 临时变量
	 */
	@Transient
	private Role role;

	public String getUserCode() {
		return userCode;
	}

	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getSalt() {
		return salt;
	}

	public void setSalt(String salt) {
		this.salt = salt;
	}

	public String getLastLoginTime() {
		return lastLoginTime;
	}

	public void setLastLoginTime(String lastLoginTime) {
		this.lastLoginTime = lastLoginTime;
	}

	public String getHeadimg() {
		return headimg;
	}

	public void setHeadimg(String headimg) {
		this.headimg = headimg;
	}

	public String getCompanyId() {
		return companyId;
	}

	public void setCompanyId(String companyId) {
		this.companyId = companyId;
	}

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}
}
