package com.baylogic.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name="specialization")
@Entity
public class Specialization implements Serializable{

	private Integer specializationId;
	private String specializationName;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getSpecializationId() {
		return specializationId;
	}
	public void setSpecializationId(Integer specializationId) {
		this.specializationId = specializationId;
	}
	public String getSpecializationName() {
		return specializationName;
	}
	public void setSpecializationName(String specializationName) {
		this.specializationName = specializationName;
	}
	
}
