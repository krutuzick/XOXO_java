package com.xoxo.board;


/**
 * Исключение, которое возникает при попытке указать некоррекную размерность доски
 */
public class BoardOutOfBoundException extends Exception {
	/**
	 * Минимальная размерность
	 */
	private int minSize;
	/**
	 * Максимальная размерность
	 */
	private int maxSize;

	/**
	 * Исключение, которое возникает при попытке указать некоррекную размерность доски
	 * @param minSize Минимальная размерность
	 * @param maxSize Максимальная размерность
	 */
	public BoardOutOfBoundException(int minSize, int maxSize) {
		this.minSize = minSize;
		this.maxSize = maxSize;
	}

	@Override
	public String getMessage() {
		return "Некорректная размерность доски. Размерность должна быть не меньше " + minSize + " и не больше " + maxSize;
	}
}
