/**
 * 
 */
package com.co.mercadolibre.service.validate;

import com.co.mercadolibre.util.Properties;

/**
 * @author DANIEL MORENO AREVALO
 *
 */
public class DiagonalValidateDownProcessor extends MutantProcessor {

	public DiagonalValidateDownProcessor(char[][] dna, final Detection detection) {
		super();
		this.dna = dna;
		this.detection = detection;
	}

	@Override
	public void searchMutanteSequences() {
		boolean match = findMutantSequence(Coordinates.at(dna, 0, 0));
		if (match) {
			return;
		}
		for (int row = 1; row <= dna.length - Properties.SEQUENCESIZEMUTANT; row++) {
			match = findMutantSequence(Coordinates.at(dna, row, 0, row))
					|| findMutantSequence(Coordinates.at(dna, 0, row, row));
			if (match) {
				break;
			}
		}

	}

	@Override
	protected void move(Coordinates coordinate) {
		coordinate.row++;
		coordinate.column++;
		coordinate.subIndex++;
		coordinate.lastChar = coordinate.currentChar;
		coordinate.currentChar = coordinate.dna[coordinate.row][coordinate.column];
	}

	@Override
	protected boolean has(Coordinates coordinate, int actualSequence) {
		int subIndex = coordinate.subIndex;
		int available = coordinate.size - subIndex;
		return available + actualSequence >= Properties.SEQUENCESIZEMUTANT
				&& Math.max(coordinate.column, coordinate.row) + 1 < coordinate.size;
	}

}