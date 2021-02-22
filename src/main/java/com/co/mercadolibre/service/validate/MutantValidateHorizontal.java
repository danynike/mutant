/**
 * 
 */
package com.co.mercadolibre.service.validate;

/**
 * @author DANIEL MORENO AREVALO
 *
 */
public class MutantValidateHorizontal extends MutantProcessor {
	
	public MutantValidateHorizontal(char[][] dna, final Detection detection) {
		super();
		this.dna = dna;
		this.detection = detection;
	}

	@Override
	protected void searchMutanteSequences() {
		for (int row = 0; row < dna.length; row++) {
			boolean match = findMutantSequence(Coordinates.at(dna, row, 0));
			if (match) {
				break;
			}
		}
	}

	@Override
	protected void move(Coordinates coordinate) {
		coordinate.column++;
		coordinate.subIndex++;
		coordinate.lastChar = coordinate.currentChar;
		coordinate.currentChar = coordinate.dna[coordinate.row][coordinate.column];
	}

	@Override
	protected boolean has(Coordinates coordinate, int actualSequence) {
		return coordinate.column + 1 <= coordinate.dna.length - 1;
	}

}
