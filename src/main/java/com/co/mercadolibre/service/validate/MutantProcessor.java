/**
 * 
 */
package com.co.mercadolibre.service.validate;

import com.co.mercadolibre.util.Properties;

/**
 * @author DANIEL MORENO AREVALO
 *
 */
public abstract class MutantProcessor {

	protected char[][] dna;

	protected Detection detection;

	protected abstract void searchMutanteSequences();

	protected abstract void move(Coordinates coordinate);

	protected abstract boolean has(Coordinates coordinate, int actualSequence);

	protected boolean findMutantSequence(Coordinates coordidate) {
		char currentChar = coordidate.dna[coordidate.row][coordidate.column];
		int sequence = 1;
		while (has(coordidate, sequence)) {
			move(coordidate);

			if (currentChar != coordidate.currentChar) {
				sequence = 1;
				currentChar = coordidate.currentChar;
			} else if (++sequence >= Properties.SEQUENCESIZEMUTANT) {
				this.newSequenceMatch();

				if (hasMatchSequencesMutant()) {
					return Boolean.TRUE;
				}
			}
		}
		return Boolean.FALSE;
	}

	protected void newSequenceMatch() {
		detection.setMatchs(detection.getMatchs() + 1);
	}

	public boolean hasMatchSequencesMutant() {
		return detection.getMatchs() >= Properties.COUNTMATCHMUTANT;
	}

}