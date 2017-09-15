package com.mjkj.mioa.org.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the t_menu database table.
 * 
 */
@Entity
@Table(name="t_menu")
@NamedQuery(name="TMenu.findAll", query="SELECT t FROM TMenu t")
public class TMenu implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(generator="uuid")
	@GenericGenerator(name="uuid", strategy="uuid")
	private String id;

	private String domain;

	private byte isdel;

	private String name;

	private String parentid;

	private String path;

	//bi-directional many-to-many association to TOrgRole
	@ManyToMany(mappedBy="TMenus")
	private List<TOrgRole> TOrgRoles;

	public TMenu() {
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

	public String getParentid() {
		return this.parentid;
	}

	public void setParentid(String parentid) {
		this.parentid = parentid;
	}

	public String getPath() {
		return this.path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public List<TOrgRole> getTOrgRoles() {
		return this.TOrgRoles;
	}

	public void setTOrgRoles(List<TOrgRole> TOrgRoles) {
		this.TOrgRoles = TOrgRoles;
	}

}