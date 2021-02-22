/**
 * 
 */
package com.co.mercadolibre.service.validate;

import java.util.LinkedList;
import java.util.List;

import com.co.mercadolibre.util.Properties;

/**
 * @author DANIEL MORENO AREVALO
 *
 */
public class Detection {

	private List<MutantProcessor> processors = new LinkedList<>();
	private Integer matchs = 0;
	
	public Detection(char[][] dna) {
		loadProcessors(dna);
	}
	
	/**
	 * @param matchs the matchs to set
	 */
	public void setMatchs(Integer matchs) {
		this.matchs = matchs;
	}
	
	/**
	 * @return the matchs
	 */
	public Integer getMatchs() {
		return matchs;
	}
	
	private void registerProcessor(MutantProcessor processor) {
		processors.add(processor);
	}

	void loadProcessors(char[][] dna) {
		MutantProcessor horizontal = new MutantValidateHorizontal(dna, this);
		registerProcessor(horizontal);
		MutantProcessor vertical = new VerticalValidateProcessor(dna, this);
		registerProcessor(vertical);
		MutantProcessor diagnonal = new DiagonalValidateDownProcessor(dna, this);
		registerProcessor(diagnonal);
		MutantProcessor diagnonalUP = new DiagonalValidateUpProcessor(dna, this);
		registerProcessor(diagnonalUP);
	}

	/**
	 * @return true if find the count DNA sequences needed to consider a Mutant
	 */
	public boolean isMutante() {
		for (MutantProcessor processor : processors) {
			processor.searchMutanteSequences();
			if (processor.hasMatchSequencesMutant()) 
				break;
		}

		return matchs >= Properties.COUNTMATCHMUTANT;
	}
}
