package com.xoxo.board;


/**
 * Доска (игровое поле)
 */
public class Board {
	/**
	 * Символ незанятой ячейки
	 */
	public static final char EMPTY_SYMBOL = ' ';
	/**
	 * Верхняя граница допустимой размерности поля
	 */
	private static final int MAX_SIZE = 9;
	/**
	 * Нижняя граница допустимой размерности поля
	 */
	private static final int MIN_SIZE = 3;

	/**
	 * Размерность поля
	 */
	private int size;
	/**
	 * Поле
	 */
	private char[][] field;
	/**
	 * Заполнена ли доска
	 */
	private boolean isFull = false;

	/**
	 * Доска (игровое поле)
	 *
	 * @param size Размерность доски
	 * @throws BoardOutOfBoundException
	 */
	public Board(int size) throws BoardOutOfBoundException {
		if (size < MIN_SIZE || size > MAX_SIZE) {
			throw new BoardOutOfBoundException(MIN_SIZE, MAX_SIZE);
		}
		this.size = size;
		field = new char[size][size];
		cleanBoard();
	}

	/**
	 * Очистить игровое поле - записать во все ячейки пустые символы
	 */
	private void cleanBoard() {
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				field[i][j] = EMPTY_SYMBOL;
			}
		}
		isFull = false;
	}

	/**
	 * Отобразить текущее состояние доски
	 */
	public void showBoard() {
		System.out.print("   ");
		for (int column_number = 1; column_number <= size; column_number++) {
			System.out.print(' ' + column_number + ' ');
		}
		System.out.println();
		for (int i = 0; i < size; i++) {
			System.out.print(' ' + (i + 1) + ' ');
			for (int j = 0; j < size; j++) {
				System.out.print('[' + field[i][j] + ']');
			}
			System.out.println();
		}
	}

	/**
	 * Записать ячейку в игровом поле
	 *
	 * @param row    Строка
	 * @param column Столбец
	 * @param symbol Символ
	 * @throws FieldNotEmptyException
	 */
	public void setFieldValue(int row, int column, char symbol) throws FieldNotEmptyException {
		if (field[row][column] != EMPTY_SYMBOL) {
			throw new FieldNotEmptyException(row, column, field[row][column]);
		}
		field[row][column] = symbol;
		reviewIsFull();
	}

	/**
	 * Перепроверка на доступность свободных ячеек
	 */
	private void reviewIsFull() {
		isFull = true;
		for (char[] checkRow : field) {
			for (char checkValue : checkRow) {
				if (checkValue == EMPTY_SYMBOL) {
					isFull = false;
					return;
				}
			}
		}
	}


	/**
	 * Получить значение ячейки игрового поля
	 *
	 * @param row    Строка
	 * @param column Столбец
	 * @return Значение ячейки
	 */
	public char getFieldValue(int row, int column) {
		return field[row][column];
	}

	/**
	 * Получить размерность игрового поля
	 *
	 * @return Размерность игрового поля
	 */
	public int getSize() {
		return size;
	}

	/**
	 * Заполнена ли доска
	 * @return Заполнена ли доска
	 */
	public boolean isFull() {
		return isFull;
	}
}
