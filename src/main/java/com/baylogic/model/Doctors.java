package com.baylogic.model;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedStoredProcedureQueries;
import javax.persistence.NamedStoredProcedureQuery;
import javax.persistence.Table;
import javax.persistence.Transient;


@Table(name="doctors")
@Entity
@NamedStoredProcedureQueries({
    @NamedStoredProcedureQuery(name = "getDoctors2",
	    procedureName = "doc_list_by_search2", 
	    resultClasses = Doctors.class),
    @NamedStoredProcedureQuery(name = "getDoctors4",
	    procedureName = "doc_list_by_search4", 
	    resultClasses = Doctors.class),
    @NamedStoredProcedureQuery(name = "getDoctors3",
	    procedureName = "doc_list_by_search3", 
	    resultClasses = Doctors.class),
    @NamedStoredProcedureQuery(name = "getDoctors",
    procedureName = "doc_list_by_search", 
    resultClasses = Doctors.class)
})
public class Doctors implements Serializable {
	
	private Integer doctorId;
	private String firstName;
	private String lastName;
	private String professionalStatement;
	private Date practicingFrom;
	private Long userLoginId;
	private Integer age;
	private String gender;
	private String state;
	private String city;
	private String qualification;
	private String languages;
	private Integer consultationFee;

	@Transient
	private String specializationType;
	
	public String getLanguages() {
		return languages;
	}
	public void setLanguages(String languages) {
		this.languages = languages;
	}
	
	public Integer getConsultationFee() {
		return consultationFee;
	}
	public void setConsultationFee(Integer consultationFee) {
		this.consultationFee = consultationFee;
	}
	public String getQualification() {
		return qualification;
	}
	public void setQualification(String qualification) {
		this.qualification = qualification;
	}
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
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	@Transient
	public String getSpecializationType() {
		return specializationType;
	}
	public void setSpecializationType(String specializationType) {
		this.specializationType = specializationType;
	}

	
}
