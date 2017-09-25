package com.mjkj.mioa.org.entity;

import java.io.Serializable;

import javax.persistence.*;

import org.hibernate.annotations.GenericGenerator;

import java.util.List;


/**
 * The persistent class for the t_org_position database table.
 * 
 */
@Entity
@Table(name="t_org_position")
@NamedQuery(name="TOrgPosition.findAll", query="SELECT t FROM TOrgPosition t")
public class TOrgPosition implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(generator="uuid")
	@GenericGenerator(name="uuid", strategy="uuid")
	private String id;

	private String domain;

	private int isdelete;

	private String name;
	
	private String desc;

	//bi-directional many-to-many association to TOrgDepartment
	@ManyToMany(mappedBy="TOrgPositions")
	private List<TOrgDepartment> TOrgDepartments;

	//bi-directional many-to-many association to TOrgUser
	@ManyToMany(mappedBy="TOrgPositions")
	private List<TOrgUser> TOrgUsers;

	public TOrgPosition() {
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDomain() {
		return this.domain;
	}

	public void setDomain(String domain) {
		this.domain = domain;
	}

	public int getIsdelete() {
		return this.isdelete;
	}

	public void setIsdelete(int isdelete) {
		this.isdelete = isdelete;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String getDesc()
	{
		return desc;
	}

	public void setDesc(String desc)
	{
		this.desc = desc;
	}

	public List<TOrgDepartment> getTOrgDepartments() {
		return this.TOrgDepartments;
	}

	public void setTOrgDepartments(List<TOrgDepartment> TOrgDepartments) {
		this.TOrgDepartments = TOrgDepartments;
	}

	public List<TOrgUser> getTOrgUsers() {
		return this.TOrgUsers;
	}

	public void setTOrgUsers(List<TOrgUser> TOrgUsers) {
		this.TOrgUsers = TOrgUsers;
	}

}