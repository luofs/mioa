package com.mjkj.mioa.org.entity;

import java.io.Serializable;

import javax.persistence.*;

import org.hibernate.annotations.GenericGenerator;


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

	private String parentid;

	private String spread;

	private String title;

	private String url;
	
	private String icon;

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

	public String getParentid() {
		return this.parentid;
	}

	public void setParentid(String parentid) {
		this.parentid = parentid;
	}

	public String getSpread() {
		return this.spread;
	}

	public void setSpread(String spread) {
		this.spread = spread;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getUrl() {
		return this.url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getIcon()
	{
		return icon;
	}

	public void setIcon(String icon)
	{
		this.icon = icon;
	}

}