package com.baylogic.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name="hashing_algorithms")
@Entity
public class HashingAlgorithms implements java.io.Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long hashAlgorithmId;
	private String algorithmName;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long getHashAlgorithmId() {
		return hashAlgorithmId;
	}
	public void setHashAlgorithmId(Long hashAlgorithmId) {
		this.hashAlgorithmId = hashAlgorithmId;
	}
	public String getAlgorithmName() {
		return algorithmName;
	}
	public void setAlgorithmName(String algorithmName) {
		this.algorithmName = algorithmName;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	
}
