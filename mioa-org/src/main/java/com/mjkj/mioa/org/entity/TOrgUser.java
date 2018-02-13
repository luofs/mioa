package com.mjkj.mioa.org.entity;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;


/**
 * The persistent class for the t_org_user database table.
 * 
 */
@Entity
@Table(name="t_org_user")
@NamedQuery(name="TOrgUser.findAll", query="SELECT t FROM TOrgUser t")
public class TOrgUser implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(generator="uuid")
	@GenericGenerator(name="uuid", strategy="uuid")
	private String id;

	private String address;

	private Timestamp createtime;

	private String domain;

	private String email;

	private byte isdel;

	private String mobile;

	private String name;

	private String password;

	private String realname;

	private byte sex = 0;

	private String telephone;

	private Timestamp updatetime;
	
	private byte disable = 0;
	
	private Timestamp lastlogintime;
	
	private String lastloginip;

	//bi-directional many-to-many association to TOrgRole
	@ManyToMany(fetch=FetchType.EAGER)
	@JoinTable(
		name="t_user_role"
		, joinColumns={
			@JoinColumn(name="userid")
			}
		, inverseJoinColumns={
			@JoinColumn(name="roleid")
			}
		)
	private List<TOrgRole> TOrgRoles;
	
	//bi-directional many-to-many association to TOrgRole
	@ManyToMany(fetch=FetchType.LAZY)
	@JoinTable(
		name="t_user_menu"
		, joinColumns={
			@JoinColumn(name="userid")
			}
		, inverseJoinColumns={
			@JoinColumn(name="menuid")
			}
		)
	private List<TMenu> TMenus;

	public TOrgUser() {
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Timestamp getCreatetime() {
		return this.createtime;
	}

	public void setCreatetime(Timestamp createtime) {
		this.createtime = createtime;
	}

	public String getDomain() {
		return this.domain;
	}

	public void setDomain(String domain) {
		this.domain = domain;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public byte getIsdel() {
		return this.isdel;
	}

	public void setIsdel(byte isdel) {
		this.isdel = isdel;
	}

	public String getMobile() {
		return this.mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRealname() {
		return this.realname;
	}

	public void setRealname(String realname) {
		this.realname = realname;
	}

	public byte getSex() {
		return this.sex;
	}

	public void setSex(byte sex) {
		this.sex = sex;
	}

	public String getTelephone() {
		return this.telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public Timestamp getUpdatetime() {
		return this.updatetime;
	}

	public void setUpdatetime(Timestamp updatetime) {
		this.updatetime = updatetime;
	}

	public List<TOrgRole> getTOrgRoles() {
		return this.TOrgRoles;
	}

	public void setTOrgRoles(List<TOrgRole> TOrgRoles) {
		this.TOrgRoles = TOrgRoles;
	}
	
	public List<TMenu> getTMenus()
	{
		return TMenus;
	}

	
	public void setTMenus(List<TMenu> tMenus)
	{
		TMenus = tMenus;
	}

	public byte getDisable()
	{
		return disable;
	}

	public void setDisable(byte disable)
	{
		this.disable = disable;
	}

	public Timestamp getLastlogintime()
	{
		return lastlogintime;
	}

	public void setLastlogintime(Timestamp lastlogintime)
	{
		this.lastlogintime = lastlogintime;
	}

	public String getLastloginip()
	{
		return lastloginip;
	}

	public void setLastloginip(String lastloginip)
	{
		this.lastloginip = lastloginip;
	}

	
	

}