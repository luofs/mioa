package com.mjkj.mioa.att.entity;

import java.io.Serializable;

import javax.persistence.*;

import org.hibernate.annotations.GenericGenerator;

import java.util.Date;


/**
 * The persistent class for the t_att_ori_record database table.
 * 
 */
@Entity
@Table(name="t_att_ori_record")
@NamedQuery(name="TAttOriRecord.findAll", query="SELECT t FROM TAttOriRecord t")
public class TAttOriRecord implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(generator="uuid")
	@GenericGenerator(name="uuid", strategy="uuid")
	private String id;

	@Column(name="insert_times")
	private String insertTimes;

	@Temporal(TemporalType.DATE)
	@Column(name="record_date")
	private Date recordDate;

	@Column(name="record_times")
	private String recordTimes;

	private String sources;

	private String userid;

	public TAttOriRecord() {
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getInsertTimes() {
		return this.insertTimes;
	}

	public void setInsertTimes(String insertTimes) {
		this.insertTimes = insertTimes;
	}

	public Date getRecordDate() {
		return this.recordDate;
	}

	public void setRecordDate(Date recordDate) {
		this.recordDate = recordDate;
	}

	public String getRecordTimes() {
		return this.recordTimes;
	}

	public void setRecordTimes(String recordTimes) {
		this.recordTimes = recordTimes;
	}

	public String getSources() {
		return this.sources;
	}

	public void setSources(String sources) {
		this.sources = sources;
	}

	public String getUserid() {
		return this.userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

}