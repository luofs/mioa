package com.mjkj.mioa.att.entity;

import java.io.Serializable;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.validator.constraints.NotEmpty;

import java.util.Date;


/**
 * The persistent class for the t_att_immunity database table.
 * 
 */
@Entity
@Table(name="t_att_immunity")
@NamedQuery(name="TAttImmunity.findAll", query="SELECT t FROM TAttImmunity t")
public class TAttImmunity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "uuid")
	private String id;

	private int early;

	@Temporal(TemporalType.DATE)
	private Date enddate;

	@Column(name="immunity_type")
	private short immunityType;

	private int late;

	@Column(name="no_att")
	@NotEmpty
	private String noAtt;

	@Temporal(TemporalType.DATE)
	@NotNull
	private Date startdate;

	public TAttImmunity() {
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getEarly() {
		return this.early;
	}

	public void setEarly(int early) {
		this.early = early;
	}

	public Date getEnddate() {
		return this.enddate;
	}

	public void setEnddate(Date enddate) {
		this.enddate = enddate;
	}

	public short getImmunityType() {
		return this.immunityType;
	}

	public void setImmunityType(short immunityType) {
		this.immunityType = immunityType;
	}

	public int getLate() {
		return this.late;
	}

	public void setLate(int late) {
		this.late = late;
	}

	public String getNoAtt() {
		return this.noAtt;
	}

	public void setNoAtt(String noAtt) {
		this.noAtt = noAtt;
	}

	public Date getStartdate() {
		return this.startdate;
	}

	public void setStartdate(Date startdate) {
		this.startdate = startdate;
	}

}