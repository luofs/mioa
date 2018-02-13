package com.mjkj.mioa.org.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the t_org_dept_pos database table.
 * 
 */
@Entity
@Table(name="t_org_dept_pos")
@NamedQuery(name="TOrgDeptPosition.findAll", query="SELECT t FROM TOrgDeptPosition t")
public class TOrgDeptPosition implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private TOrgDeptPositionPK id;

	public TOrgDeptPosition() {
	}

	public TOrgDeptPositionPK getId() {
		return this.id;
	}

	public void setId(TOrgDeptPositionPK id) {
		this.id = id;
	}

}