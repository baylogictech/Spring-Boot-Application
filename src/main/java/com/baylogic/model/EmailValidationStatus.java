package com.baylogic.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name="email_validation_status")
@Entity
public class EmailValidationStatus implements java.io.Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long emailValidationStatusId;
	private String statusDescription;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long getEmailValidationStatusId() {
		return emailValidationStatusId;
	}
	public void setEmailValidationStatusId(Long emailValidationStatusId) {
		this.emailValidationStatusId = emailValidationStatusId;
	}
	public String getStatusDescription() {
		return statusDescription;
	}
	public void setStatusDescription(String statusDescription) {
		this.statusDescription = statusDescription;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
}
