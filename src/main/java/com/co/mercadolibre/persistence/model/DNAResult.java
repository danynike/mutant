/**
 * 
 */
package com.co.mercadolibre.persistence.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.Immutable;

/**
 * @author DANIEL MORENO AREVALO
 *
 */
@Entity
public class DNAResult implements Serializable{

	private static final long serialVersionUID = -6493510730686106632L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@Column(nullable = false, length = 1000)
	private String dna;
	
	@Column(nullable=false)
	private Boolean isMutant;
	
	public DNAResult() {
		super();
		this.isMutant = false;
	}
	
	/**
	 * @return the id
	 */
	public long getId() {
		return id;
	}
	
	/**
	 * @param id the id to set
	 */
	public void setId(long id) {
		this.id = id;
	}

	@ManyToOne
	@Immutable
	public String getDna() {
		return dna;
	}

	public void setDna(String dna) {
		this.dna = dna;
	}

	public boolean isMutant() {
		return isMutant;
	}

	public void setMutant(boolean isMutant) {
		this.isMutant = isMutant;
	}
	
}