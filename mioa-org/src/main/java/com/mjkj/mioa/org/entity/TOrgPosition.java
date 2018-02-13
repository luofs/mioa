package com.mjkj.mioa.org.entity;

import java.io.Serializable;

import javax.persistence.*;

import org.hibernate.annotations.GenericGenerator;


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

	private byte isdelete;

	private String name;

	private String positdesc;

	public TOrgPosition() {
	}

	public TOrgPosition(String name, String positdesc, String domain)
	{
		this.name = name;
		this.positdesc = positdesc;
		this.domain = domain;
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

	public String getPositdesc() {
		return this.positdesc;
	}

	public void setPositdesc(String positdesc) {
		this.positdesc = positdesc;
	}

}