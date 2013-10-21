package com.xoxo.board;


/**
 * Исключение, которое возникает при попытке походить в уже занятой ячейке
 */
public class FieldNotEmptyException extends Exception {
	/**
	 * Индекс строки
	 */
	private int row;
	/**
	 * Индекс столбца
	 */
	private int column;
	/**
	 * Символ, который уже находится в поле
	 */
	private int symbol;

	/**
	 * Исключение, которое возникает при попытке походить в уже занятой ячейке
	 * @param row Индекс строки
	 * @param column Индекс столбца
	 * @param symbol имвол, который уже находится в поле
	 */
	public FieldNotEmptyException(int row, int column, char symbol) {
		this.row = row;
		this.column = column;
		this.symbol = symbol;
	}

	@Override
	public String getMessage() {
		return "Ячейка [" + (row + 1) + "][" + (column + 1) + "] уже занята символом " + symbol;
	}
}
