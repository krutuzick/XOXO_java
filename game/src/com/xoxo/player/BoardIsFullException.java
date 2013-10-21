package com.xoxo.player;


/**
 * Исключение, которое возникает при ходе игрока: доска заполнена
 */
public class BoardIsFullException extends PlayerMoveException {
	@Override
	public String getMessage() {
		return "Ход игрока невозможен: доска заполнена";
	}
}
