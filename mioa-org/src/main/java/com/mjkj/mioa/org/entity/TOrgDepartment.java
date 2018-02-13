package com.mjkj.mioa.org.entity;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;


/**
 * The persistent class for the t_org_department database table.
 * 
 */
@Entity
@Table(name="t_org_department")
@NamedQuery(name="TOrgDepartment.findAll", query="SELECT t FROM TOrgDepartment t")
public class TOrgDepartment implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(generator="uuid")
	@GenericGenerator(name="uuid", strategy="uuid")
	private String id;

	private String deptpath;

	private String domain;

	private byte isdelete;

	private String name;

	private String parentid;
	
	private String abbr;
	
	private String telphone;
	
	private String fax;
	
	private String address;
	
	private Timestamp createtime;
	
	private Timestamp updatetime;
	
	@ElementCollection(targetClass=String.class)
	@CollectionTable(name = "t_org_department", joinColumns = @JoinColumn(name = "id", referencedColumnName="parentid"))
	@Column(name = "name")
	private List<String> parentNames;
	

	//bi-directional many-to-many association to TOrgPosition
	@ManyToMany(cascade = { CascadeType.REFRESH})
	@JoinTable(
		name="t_org_dept_pos"
		, joinColumns={
			@JoinColumn(name="deptid")
			}
		, inverseJoinColumns={
			@JoinColumn(name="posid")
			}
		)
	private List<TOrgPosition> TOrgPositions;

	public TOrgDepartment() {
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDeptpath() {
		return this.deptpath;
	}

	public void setDeptpath(String deptpath) {
		this.deptpath = deptpath;
	}

	public String getDomain() {
		return this.domain;
	}

	public void setDomain(String domain) {
		this.domain = domain;
	}

	public byte getIsdelete() {
		return this.isdelete;
	}

	public void setIsdelete(byte isdelete) {
		this.isdelete = isdelete;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getParentid() {
		return this.parentid;
	}

	public void setParentid(String parentid) {
		this.parentid = parentid;
	}

	public List<TOrgPosition> getTOrgPositions() {
		return this.TOrgPositions;
	}

	public void setTOrgPositions(List<TOrgPosition> TOrgPositions) {
		this.TOrgPositions = TOrgPositions;
	}

	public String getAbbr()
	{
		return abbr;
	}

	public void setAbbr(String abbr)
	{
		this.abbr = abbr;
	}

	public String getTelphone()
	{
		return telphone;
	}

	public void setTelphone(String telphone)
	{
		this.telphone = telphone;
	}

	public String getFax()
	{
		return fax;
	}

	public void setFax(String fax)
	{
		this.fax = fax;
	}

	public String getAddress()
	{
		return address;
	}

	public void setAddress(String address)
	{
		this.address = address;
	}

	public Timestamp getCreatetime()
	{
		return createtime;
	}

	public void setCreatetime(Timestamp createtime)
	{
		this.createtime = createtime;
	}

	public Timestamp getUpdatetime()
	{
		return updatetime;
	}

	public void setUpdatetime(Timestamp updatetime)
	{
		this.updatetime = updatetime;
	}

	public List<String> getParentNames()
	{
		return parentNames;
	}

	public void setParentNames(List<String> parentNames)
	{
		this.parentNames = parentNames;
	}
	
	

}