package com.baylogic.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name="roles")
@Entity
public class Roles implements java.io.Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long roleId;
	private String roleDescription;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long getRoleId() {
		return roleId;
	}
	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}
	public String getRoleDescription() {
		return roleDescription;
	}
	public void setRoleDescription(String roleDescription) {
		this.roleDescription = roleDescription;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	
	
}
