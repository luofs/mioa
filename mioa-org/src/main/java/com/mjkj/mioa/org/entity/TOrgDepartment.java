package com.mjkj.mioa.org.entity;

import java.io.Serializable;

import javax.persistence.*;

import org.hibernate.annotations.GenericGenerator;

import java.util.List;


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

	//bi-directional many-to-many association to TOrgPosition
	@ManyToMany
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

}