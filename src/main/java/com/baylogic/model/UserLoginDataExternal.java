package com.baylogic.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name="user_login_data_external")
@Entity
public class UserLoginDataExternal implements java.io.Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long userId;
	private Long externalProviderId;
	private String externalProviderToken;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public Long getExternalProviderId() {
		return externalProviderId;
	}
	public void setExternalProviderId(Long externalProviderId) {
		this.externalProviderId = externalProviderId;
	}
	public String getExternalProviderToken() {
		return externalProviderToken;
	}
	public void setExternalProviderToken(String externalProviderToken) {
		this.externalProviderToken = externalProviderToken;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	
}
