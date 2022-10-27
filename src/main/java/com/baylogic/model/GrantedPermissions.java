package com.baylogic.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name="granted_permissions")
@Entity
public class GrantedPermissions implements java.io.Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 
	 */
	private Long grantedPermissionId;
	private Long roleId;
	private Long permissionId;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long getGrantedPermissionId() {
		return grantedPermissionId;
	}
	public void setGrantedPermissionId(Long grantedPermissionId) {
		this.grantedPermissionId = grantedPermissionId;
	}
	public Long getPermissionId() {
		return permissionId;
	}
	public void setPermissionId(Long permissionId) {
		this.permissionId = permissionId;
	} 
	public Long getRoleId() {
		return roleId;
	}
	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}
	
	
}
