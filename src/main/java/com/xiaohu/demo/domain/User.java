package com.xiaohu.demo.domain;

import com.xiaohu.demo.common.DateUtil;
import com.xiaohu.demo.common.StringUtil;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * 用户信息表
 * @author Administrator
 *
 */
@Entity
@Table(name = "common_user")
@Data
public class User  {

	private static final long serialVersionUID = -926874738132420619L;

	@Id
	@GeneratedValue(generator="system-uuid")
	@GenericGenerator(name="system-uuid", strategy = "uuid.hex")
	@Column(name = "id", unique = true, nullable = true)
	private String id;
	@Column(name="create_date")
	private String createDate = DateUtil.getDate(DateUtil.YYYY_MM_DD_HH_MM_SS);
	@Column(name="update_date")
	private String updateDate = DateUtil.getDate(DateUtil.YYYY_MM_DD_HH_MM_SS);
	@Column(name="status")
	private String status;
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
	
//	@ManyToMany(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
//	@JoinTable(name = "common_user_role", joinColumns = { @JoinColumn(name = "user_id", referencedColumnName = "id") }, inverseJoinColumns = { @JoinColumn(name = "role_id", referencedColumnName = "id") })
//	private Set<Role> roles = new HashSet<Role>();  //用户角色
	
//	//------------临时变量-----------------------
//	@Transient
//	private Role role;


}
