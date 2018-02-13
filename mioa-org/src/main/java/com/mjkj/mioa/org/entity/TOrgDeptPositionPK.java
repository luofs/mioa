package com.mjkj.mioa.org.entity;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the t_org_dept_pos database table.
 * 
 */
@Embeddable
public class TOrgDeptPositionPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	private String deptid;

	private String posid;

	public TOrgDeptPositionPK() {
	}
	public String getDeptid() {
		return this.deptid;
	}
	public void setDeptid(String deptid) {
		this.deptid = deptid;
	}
	public String getPosid() {
		return this.posid;
	}
	public void setPosid(String posid) {
		this.posid = posid;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof TOrgDeptPositionPK)) {
			return false;
		}
		TOrgDeptPositionPK castOther = (TOrgDeptPositionPK)other;
		return 
			this.deptid.equals(castOther.deptid)
			&& this.posid.equals(castOther.posid);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.deptid.hashCode();
		hash = hash * prime + this.posid.hashCode();
		
		return hash;
	}
}