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
	private String symptomsDescription;
	private Integer specializationId;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getSymptomsId() {
		return symptomsId;
	}
	public void setSymptomsId(Integer symptomsId) {
		this.symptomsId = symptomsId;
	}
	public String getSymptomsDescription() {
		return symptomsDescription;
	}
	public void setSymptomsDescription(String symptomsDescription) {
		this.symptomsDescription = symptomsDescription;
	}
	public Integer getSpecializationId() {
		return specializationId;
	}
	public void setSpecializationId(Integer specializationId) {
		this.specializationId = specializationId;
	}
	
	
}
