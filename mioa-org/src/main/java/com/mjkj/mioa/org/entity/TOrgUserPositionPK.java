package com.mjkj.mioa.org.entity;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the t_org_user_pos database table.
 * 
 */
@Embeddable
public class TOrgUserPositionPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	private String userid;

	private String posid;

	private String deptid;

	public TOrgUserPositionPK() {
	}
	public String getUserid() {
		return this.userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getPosid() {
		return this.posid;
	}
	public void setPosid(String posid) {
		this.posid = posid;
	}
	public String getDeptid() {
		return this.deptid;
	}
	public void setDeptid(String deptid) {
		this.deptid = deptid;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof TOrgUserPositionPK)) {
			return false;
		}
		TOrgUserPositionPK castOther = (TOrgUserPositionPK)other;
		return 
			this.userid.equals(castOther.userid)
			&& this.posid.equals(castOther.posid)
			&& this.deptid.equals(castOther.deptid);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.userid.hashCode();
		hash = hash * prime + this.posid.hashCode();
		hash = hash * prime + this.deptid.hashCode();
		
		return hash;
	}
}