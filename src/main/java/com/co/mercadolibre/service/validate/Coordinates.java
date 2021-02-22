/**
 * 
 */
package com.co.mercadolibre.service.validate;

/**
 * @author DANIEL MORENO AREVALO
 *
 */
public class Coordinates {

	public char dna[][];
	public int subIndex;
	public int row;
	public int column;
	public char lastChar;
	public char currentChar;
	public int size;

	public Coordinates(char[][] dna, int subIndex, int row, int column) {
		super();
		this.dna = dna;
		this.size = dna.length;
		this.subIndex = subIndex;
		this.row = row;
		this.column = column;
		this.lastChar = dna[row][column];
	}

	public static Coordinates at(char[][] dna, int row, int column) {
		return new Coordinates(dna, 0, row, column);
	}

	public static Coordinates at(char[][] dna, int row, int column, int index) {
		return new Coordinates(dna, index, row, column);
	}

}
