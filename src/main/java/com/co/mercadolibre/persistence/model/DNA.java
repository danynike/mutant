/**
 * 
 */
package com.co.mercadolibre.persistence.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @author DANIEL MORENO AREVALO
 *
 */
@Entity
public class DNA implements Serializable {

	private static final long serialVersionUID = -1397869689345841536L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private Long mutantCount = 0L;
	private Long humanCount = 0L;
	private Double ratio;
	private Long total = 0L;

	public DNA() {

	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Long getMutantCount() {
		return mutantCount;
	}

	public void setMutantCount(Long mutantCount) {
		this.mutantCount = mutantCount;
	}

	public Long getHumanCount() {
		return humanCount;
	}

	public void setHumanCount(Long humanCount) {
		this.humanCount = humanCount;
	}

	public Double getRatio() {
		return ratio;
	}

	public void setRatio(Double ratio) {
		this.ratio = ratio;
	}

	public Long getTotal() {
		return total;
	}

	public void setTotal(Long total) {
		this.total = total;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "DNAStatus [mutantCount=" + mutantCount + ", humanCount=" + humanCount + ", ratio=" + ratio + ", total="
				+ total + "]";
	}
}
