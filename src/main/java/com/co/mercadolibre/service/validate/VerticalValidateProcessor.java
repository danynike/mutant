/**
 * 
 */
package com.co.mercadolibre.service.validate;

/**
 * @author DANIEL MORENO AREVALO
 *
 */
public class VerticalValidateProcessor extends MutantProcessor{

	public VerticalValidateProcessor(char[][] dna, final Detection detection) {
		super();
		this.dna = dna;
		this.detection = detection;
	}
	
	@Override
	protected void searchMutanteSequences() {
		for (int column = 0; column < dna.length; column++) {
			boolean match = findMutantSequence(Coordinates.at(dna, 0, column));
			if (match) {
				break;
			}
		}
	}

	@Override
	protected void move(Coordinates coordinate) {
		coordinate.row++;
		coordinate.subIndex++;
		coordinate.lastChar = coordinate.currentChar;
		coordinate.currentChar = coordinate.dna[coordinate.row][coordinate.column];
	}

	@Override
	protected boolean has(Coordinates coordinate, int actualSequence) {
		return coordinate.row + 1 <= coordinate.dna.length - 1;
	}
	
}
