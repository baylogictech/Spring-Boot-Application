package com.baylogic.enums;

public enum Roles {
	PATIENT(1), DOCTOR(2);
	private long roleId;

	private Roles(long roleId) {
		this.roleId = roleId;
	}

	public long getRoleId() {
		return roleId;
	}
	
}
