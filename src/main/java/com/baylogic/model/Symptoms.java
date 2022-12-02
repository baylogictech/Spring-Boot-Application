package com.baylogic.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name="symptoms")
@Entity
public class Symptoms implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer symptomsId;
	private String symptomDescription;
	private Integer specializationId;
	private String symptomImgUrl;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getSymptomsId() {
		return symptomsId;
	}
	public void setSymptomsId(Integer symptomsId) {
		this.symptomsId = symptomsId;
	}
	public String getSymptomDescription() {
		return symptomDescription;
	}
	public void setSymptomDescription(String symptomDescription) {
		this.symptomDescription = symptomDescription;
	}
	public Integer getSpecializationId() {
		return specializationId;
	}
	public void setSpecializationId(Integer specializationId) {
		this.specializationId = specializationId;
	}
	public String getSymptomImgUrl() {
		return symptomImgUrl;
	}
	public void setSymptomImgUrl(String symptomImgUrl) {
		this.symptomImgUrl = symptomImgUrl;
	}
}
