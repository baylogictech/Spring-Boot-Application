package com.baylogic.model;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name="doctors")
@Entity
public class Doctors implements Serializable {
	
	private Integer doctorId;
	private String firstName;
	private String lastName;
	private String professionalStatement;
	private Date practicingFrom;
	private Long userLoginId;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getDoctorId() {
		return doctorId;
	}
	public void setDoctorId(Integer doctorId) {
		this.doctorId = doctorId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getProfessionalStatement() {
		return professionalStatement;
	}
	public void setProfessionalStatement(String professionalStatement) {
		this.professionalStatement = professionalStatement;
	}
	public Date getPracticingFrom() {
		return practicingFrom;
	}
	public void setPracticingFrom(Date practicingFrom) {
		this.practicingFrom = practicingFrom;
	}
	public Long getUserLoginId() {
		return userLoginId;
	}
	public void setUserLoginId(Long userLoginId) {
		this.userLoginId = userLoginId;
	}
	
	
}
