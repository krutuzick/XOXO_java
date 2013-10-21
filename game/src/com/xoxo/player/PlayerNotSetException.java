package com.xoxo.player;


import com.xoxo.board.Board;


/**
 * сключение, которое возникает при попытке создать объект игрока без параметров
 */
public class PlayerNotSetException extends Exception {
	@Override
	public String getMessage() {
		return "Имя игрока не должно быть пустым, символ должен отличаться от '" + Board.EMPTY_SYMBOL + "'";
	}
}
