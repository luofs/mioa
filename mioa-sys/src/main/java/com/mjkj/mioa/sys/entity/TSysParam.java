package com.mjkj.mioa.sys.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the t_sys_param database table.
 * 
 */
@Entity
@Table(name="t_sys_param")
@NamedQuery(name="TSysParam.findAll", query="SELECT t FROM TSysParam t")
public class TSysParam implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="param_name")
	private String paramName;

	@Column(name="aggregate_function")
	private String aggregateFunction;

	@Column(name="default_value")
	private String defaultValue;

	private String domain;

	@Column(name="groovy_script")
	private String groovyScript;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="insert_time")
	private Date insertTime;

	@Column(name="param_field")
	private String paramField;

	@Column(name="param_table")
	private String paramTable;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="update_time")
	private Date updateTime;

	public TSysParam() {
	}

	public String getParamName() {
		return this.paramName;
	}

	public void setParamName(String paramName) {
		this.paramName = paramName;
	}

	public String getAggregateFunction() {
		return this.aggregateFunction;
	}

	public void setAggregateFunction(String aggregateFunction) {
		this.aggregateFunction = aggregateFunction;
	}

	public String getDefaultValue() {
		return this.defaultValue;
	}

	public void setDefaultValue(String defaultValue) {
		this.defaultValue = defaultValue;
	}

	public String getDomain() {
		return this.domain;
	}

	public void setDomain(String domain) {
		this.domain = domain;
	}

	public String getGroovyScript() {
		return this.groovyScript;
	}

	public void setGroovyScript(String groovyScript) {
		this.groovyScript = groovyScript;
	}

	public Date getInsertTime() {
		return this.insertTime;
	}

	public void setInsertTime(Date insertTime) {
		this.insertTime = insertTime;
	}

	public String getParamField() {
		return this.paramField;
	}

	public void setParamField(String paramField) {
		this.paramField = paramField;
	}

	public String getParamTable() {
		return this.paramTable;
	}

	public void setParamTable(String paramTable) {
		this.paramTable = paramTable;
	}

	public Date getUpdateTime() {
		return this.updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

}