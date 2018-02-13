package com.mjkj.mioa.org.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the t_org_user_pos database table.
 * 
 */
@Entity
@Table(name="t_org_user_pos")
@NamedQuery(name="TOrgUserPosition.findAll", query="SELECT t FROM TOrgUserPosition t")
public class TOrgUserPosition implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private TOrgUserPositionPK id;

	public TOrgUserPosition() {
	}

	public TOrgUserPositionPK getId() {
		return this.id;
	}

	public void setId(TOrgUserPositionPK id) {
		this.id = id;
	}

}