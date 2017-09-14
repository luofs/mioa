package com.mjkj.mioa.att.entity;

import java.io.Serializable;

import javax.persistence.*;

import org.hibernate.annotations.GenericGenerator;

import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the t_att_holiday database table.
 * 
 */
@Entity
@Table(name="t_att_holiday")
@NamedQuery(name="TAttHoliday.findAll", query="SELECT t FROM TAttHoliday t")
public class TAttHoliday implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(generator="uuid")
	@GenericGenerator(name="uuid", strategy="uuid")
	private String id;

	private BigDecimal base;

	@Temporal(TemporalType.TIMESTAMP)
	private Date createtime;

	private String domain;

	private BigDecimal increment;

	private BigDecimal max;

	private String name;

	@Temporal(TemporalType.TIMESTAMP)
	private Date updatetime;

	public TAttHoliday() {
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public BigDecimal getBase() {
		return this.base;
	}

	public void setBase(BigDecimal base) {
		this.base = base;
	}

	public Date getCreatetime() {
		return this.createtime;
	}

	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}

	public String getDomain() {
		return this.domain;
	}

	public void setDomain(String domain) {
		this.domain = domain;
	}

	public BigDecimal getIncrement() {
		return this.increment;
	}

	public void setIncrement(BigDecimal increment) {
		this.increment = increment;
	}

	public BigDecimal getMax() {
		return this.max;
	}

	public void setMax(BigDecimal max) {
		this.max = max;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getUpdatetime() {
		return this.updatetime;
	}

	public void setUpdatetime(Date updatetime) {
		this.updatetime = updatetime;
	}

}