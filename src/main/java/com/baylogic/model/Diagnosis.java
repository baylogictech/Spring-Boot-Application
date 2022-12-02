package com.baylogic.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name="diagnosis")
@Entity
public class Diagnosis {
	
	private Integer diagnosisId;
	private String diagnosisDescription;
	private Integer specializationId;
	private String diagnosisImgUrl;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getDiagnosisId() {
		return diagnosisId;
	}
	public void setDiagnosisId(Integer diagnosisId) {
		this.diagnosisId = diagnosisId;
	}
	public String getDiagnosisDescription() {
		return diagnosisDescription;
	}
	public void setDiagnosisDescription(String diagnosisDescription) {
		this.diagnosisDescription = diagnosisDescription;
	}
	public Integer getSpecializationId() {
		return specializationId;
	}
	public void setSpecializationId(Integer specializationId) {
		this.specializationId = specializationId;
	}
	public String getDiagnosisImgUrl() {
		return diagnosisImgUrl;
	}
	public void setDiagnosisImgUrl(String diagnosisImgUrl) {
		this.diagnosisImgUrl = diagnosisImgUrl;
	}
	
}
