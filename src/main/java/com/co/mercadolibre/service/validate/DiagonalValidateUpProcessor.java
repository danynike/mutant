/**
 * 
 */
package com.co.mercadolibre.service.validate;

import com.co.mercadolibre.util.Properties;

/**
 * @author DANIEL MORENO AREVALO
 *
 */
public class DiagonalValidateUpProcessor extends MutantProcessor {

	public DiagonalValidateUpProcessor(char[][] dna, final Detection detection) {
		super();
		this.dna = dna;
		this.detection = detection;
	}

	@Override
	public void searchMutanteSequences() {

		int fistIndexRow = dna.length - 1;
		int fistIndexColumn = 0;
		boolean match = findMutantSequence(Coordinates.at(dna, fistIndexRow, fistIndexColumn));
		if (match) {
			return;
		}
		for (int row = 1; row <= dna.length - Properties.SEQUENCESIZEMUTANT; row++) {
			match = findMutantSequence(Coordinates.at(dna, fistIndexRow - row, 0, row))
					|| findMutantSequence(Coordinates.at(dna, fistIndexRow, row, row));
			if (match) {
				break;
			}
		}

	}

	@Override
	protected void move(Coordinates coordinate) {
		coordinate.row--;
		coordinate.column++;
		coordinate.subIndex++;
		coordinate.lastChar = coordinate.currentChar;
		coordinate.currentChar = coordinate.dna[coordinate.row][coordinate.column];
	}

	@Override
	protected boolean has(Coordinates coordinate, int actualSequence) {
		int index = coordinate.subIndex;
		int available = coordinate.size - index;
		return available + actualSequence >= Properties.SEQUENCESIZEMUTANT && coordinate.row - 1 >= 0;
	}

}
