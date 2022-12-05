package com.baylogic.model;

import java.sql.Timestamp;
import java.util.Collection;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.security.core.GrantedAuthority;

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
	private String username;
	private String confirmationToken;
	private Timestamp tokenGenerationTime;
	private Long emailValidationStatusId;
	private String passwordRecoveryToken;
	private Timestamp recoveryTokenTime;
	private Long mobileNumber;
	private Long mobileValidationStatusId;
	private String password;
	@Transient
	private Collection<? extends GrantedAuthority> authorities;
	
	@Transient 
	private String role;
	@Transient
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
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
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getConfirmationToken() {
		return confirmationToken;
	}
	public void setConfirmationToken(String confirmationToken) {
		this.confirmationToken = confirmationToken;
	}
	public Timestamp getTokenGenerationTime() {
		return tokenGenerationTime;
	}
	public void setTokenGenerationTime(Timestamp tokenGenerationTime) {
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
	public Timestamp getRecoveryTokenTime() {
		return recoveryTokenTime;
	}
	public void setRecoveryTokenTime(Timestamp recoveryTokenTime) {
		this.recoveryTokenTime = recoveryTokenTime;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
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
	@Override
    public String toString() {
        return "SecurityUser{" +
                "id=" + userId +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", roles='" + role + '\'' +
                '}';
    }
	@Transient
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authorities;
	}
	public void setAuthorities(Collection<? extends GrantedAuthority> authorities) {
		this.authorities = authorities;
	}
}
