package com.baylogic.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name="external_providers")
@Entity
public class ExternalProviders implements java.io.Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long externalProviderId;
	private String providerName;
	private String wsEndPoint;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long getExternalProviderId() {
		return externalProviderId;
	}
	public void setExternalProviderId(Long externalProviderId) {
		this.externalProviderId = externalProviderId;
	}
	public String getProviderName() {
		return providerName;
	}
	public void setProviderName(String providerName) {
		this.providerName = providerName;
	}
	public String getWsEndPoint() {
		return wsEndPoint;
	}
	public void setWsEndPoint(String wsEndPoint) {
		this.wsEndPoint = wsEndPoint;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
}
