package com.mjkj.mioa.org.entity;

import java.io.Serializable;

import javax.persistence.*;

import org.hibernate.annotations.GenericGenerator;


/**
 * The persistent class for the t_org_role database table.
 * 
 */
@Entity
@Table(name="t_org_role")
@NamedQuery(name="TOrgRole.findAll", query="SELECT t FROM TOrgRole t")
public class TOrgRole implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(generator="uuid")
	@GenericGenerator(name="uuid", strategy="uuid")
	private String id;

	private String desp;

	private String domain;

	private byte isdel;

	private String name;

	public TOrgRole() {
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDesp() {
		return this.desp;
	}

	public void setDesp(String desp) {
		this.desp = desp;
	}

	public String getDomain() {
		return this.domain;
	}

	public void setDomain(String domain) {
		this.domain = domain;
	}

	public byte getIsdel() {
		return this.isdel;
	}

	public void setIsdel(byte isdel) {
		this.isdel = isdel;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

}