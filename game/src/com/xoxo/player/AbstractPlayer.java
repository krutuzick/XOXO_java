package com.xoxo.player;


import com.xoxo.board.Board;


/**
 * Базовый класс игрока
 */
abstract public class AbstractPlayer {
	/**
	 * Имя игрока
	 */
	protected String name;
	/**
	 * Число побед
	 */
	protected int winsCount = 0;
	/**
	 * Число проигрышей
	 */
	protected int losesCount = 0;
	/**
	 * Символ, которым играет
	 */
	protected char symbol;

	/**
	 * Игрок
	 *
	 * @param name   Имя игрока
	 * @param symbol Символ для игры
	 */
	public AbstractPlayer(String name, char symbol) throws PlayerNotSetException {
		if (name.isEmpty() || name.trim().isEmpty() || symbol == Board.EMPTY_SYMBOL) {
			throw new PlayerNotSetException();
		}
		this.name = name;
		this.symbol = symbol;
	}

	/**
	 * Добавить победу
	 */
	public void addWin() {
		winsCount++;
	}

	/**
	 * Добавить проигрыш
	 */
	public void addLost() {
		losesCount++;
	}

	/**
	 * Сделать ход
	 *
	 * @param board Доска (игровое поле)
	 */
	abstract public void makeMove(Board board) throws PlayerMoveException;
}
