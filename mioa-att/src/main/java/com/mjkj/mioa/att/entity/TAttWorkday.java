package com.mjkj.mioa.att.entity;

import java.io.Serializable;

import javax.persistence.*;

import org.hibernate.annotations.GenericGenerator;

import java.util.Date;


/**
 * The persistent class for the t_att_workday database table.
 * 
 */
@Entity
@Table(name="t_att_workday")
@NamedQuery(name="TAttWorkday.findAll", query="SELECT t FROM TAttWorkday t")
public class TAttWorkday implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "uuid")
	private String id;

	@Temporal(TemporalType.TIMESTAMP)
	private Date enddate;

	@Column(name="need_work")
	private String needWork;

	private String remark;

	@Temporal(TemporalType.TIMESTAMP)
	private Date startdate;

	public TAttWorkday() {
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Date getEnddate() {
		return this.enddate;
	}

	public void setEnddate(Date enddate) {
		this.enddate = enddate;
	}

	public String getNeedWork() {
		return this.needWork;
	}

	public void setNeedWork(String needWork) {
		this.needWork = needWork;
	}

	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Date getStartdate() {
		return this.startdate;
	}

	public void setStartdate(Date startdate) {
		this.startdate = startdate;
	}

}