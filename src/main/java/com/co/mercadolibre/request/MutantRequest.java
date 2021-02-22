/**
 * 
 */
package com.co.mercadolibre.request;

/**
 * @author DANIEL MORENO AREVALO
 *
 */

public class MutantRequest {
	private String[] dna;

	public MutantRequest() {
	}

	public MutantRequest(String[] dna) {
		this.dna = dna;
	}

	public String[] getDna() {
		return this.dna;
	}

	public void setDna(String[] dna) {
		this.dna = dna;
	}
}
