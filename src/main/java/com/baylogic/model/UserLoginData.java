package com.baylogic.model;

import java.sql.Time;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Table(name="user_login_data")
@Entity
public class UserLoginData implements java.io.Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long userId;
	private String fullName;
	private String passwordHash;
	private String passwordSalt;
	private Long hashAlgorithmId;
	private String emailAddress;
	private String confirmationToken;
	private Time tokenGenerationTime;
	private Long emailValidationStatusId;
	private String passwordRecoveryToken;
	private Time recoveryTokenTime;
	private Long mobileNumber;
	private Long mobileValidationStatusId;
	
	@Transient 
	private String role;
	@Transient
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	@Transient
	private String password;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public String getPasswordHash() {
		return passwordHash;
	}
	public void setPasswordHash(String passwordHash) {
		this.passwordHash = passwordHash;
	}
	public String getPasswordSalt() {
		return passwordSalt;
	}
	public void setPasswordSalt(String passwordSalt) {
		this.passwordSalt = passwordSalt;
	}
	public Long getHashAlgorithmId() {
		return hashAlgorithmId;
	}
	public void setHashAlgorithmId(Long hashAlgorithmId) {
		this.hashAlgorithmId = hashAlgorithmId;
	}
	public String getEmailAddress() {
		return emailAddress;
	}
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
	public String getConfirmationToken() {
		return confirmationToken;
	}
	public void setConfirmationToken(String confirmationToken) {
		this.confirmationToken = confirmationToken;
	}
	public Time getTokenGenerationTime() {
		return tokenGenerationTime;
	}
	public void setTokenGenerationTime(Time tokenGenerationTime) {
		this.tokenGenerationTime = tokenGenerationTime;
	}
	public Long getEmailValidationStatusId() {
		return emailValidationStatusId;
	}
	public void setEmailValidationStatusId(Long emailValidationStatusId) {
		this.emailValidationStatusId = emailValidationStatusId;
	}
	public String getPasswordRecoveryToken() {
		return passwordRecoveryToken;
	}
	public void setPasswordRecoveryToken(String passwordRecoveryToken) {
		this.passwordRecoveryToken = passwordRecoveryToken;
	}
	public Time getRecoveryTokenTime() {
		return recoveryTokenTime;
	}
	public void setRecoveryTokenTime(Time recoveryTokenTime) {
		this.recoveryTokenTime = recoveryTokenTime;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Transient
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Long getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(Long mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	public Long getMobileValidationStatusId() {
		return mobileValidationStatusId;
	}
	public void setMobileValidationStatusId(Long mobileValidationStatusId) {
		this.mobileValidationStatusId = mobileValidationStatusId;
	}

}
