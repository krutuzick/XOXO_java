package com.xoxo.player;


/**
 * Исключение, которое возникает при ходе игрока
 */
public class PlayerMoveException extends Exception {
	@Override
	public String getMessage() {
		return "При ходе игрока возникла ошибка";
	}
}
