package com.baylogic.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name="doc_specializations")
@Entity
public class DocSpecializations implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2044153052147533437L;
	private Long id;
	private Integer userId;
	private String specializationType;
	private Integer specializationTypeId;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public String getSpecializationType() {
		return specializationType;
	}
	public void setSpecializationType(String specializationType) {
		this.specializationType = specializationType;
	}
	public Integer getSpecializationTypeId() {
		return specializationTypeId;
	}
	public void setSpecializationTypeId(Integer specializationTypeId) {
		this.specializationTypeId = specializationTypeId;
	}

	
}
