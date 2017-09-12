package com.mjkj.mioa.att.entity;

import java.io.Serializable;

import javax.persistence.*;

import org.hibernate.annotations.GenericGenerator;

import java.math.BigDecimal;


/**
 * The persistent class for the t_att_plan database table.
 * 
 */
@Entity
@Table(name="t_att_plan")
@NamedQuery(name="TAttPlan.findAll", query="SELECT t FROM TAttPlan t")
public class TAttPlan implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(generator="uuid")
	@GenericGenerator(name="uuid", strategy="uuid")
	private String id;

	@Column(name="day_hours")
	private BigDecimal dayHours;

	private String flexibility;

	private String name;

	@Column(name="print_time")
	private String printTime;

	private String weeks;

	public TAttPlan() {
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public BigDecimal getDayHours() {
		return this.dayHours;
	}

	public void setDayHours(BigDecimal dayHours) {
		this.dayHours = dayHours;
	}

	public String getFlexibility() {
		return this.flexibility;
	}

	public void setFlexibility(String flexibility) {
		this.flexibility = flexibility;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPrintTime() {
		return this.printTime;
	}

	public void setPrintTime(String printTime) {
		this.printTime = printTime;
	}

	public String getWeeks() {
		return this.weeks;
	}

	public void setWeeks(String weeks) {
		this.weeks = weeks;
	}

}