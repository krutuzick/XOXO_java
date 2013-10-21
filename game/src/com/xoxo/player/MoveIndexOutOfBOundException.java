package com.xoxo.player;


/**
 * Исключение, которое возникает при ходе игрока: указан индекс, выходящий за пределы поля
 */
public class MoveIndexOutOfBoundException extends PlayerMoveException {
	@Override
	public String getMessage() {
		return "Указан недопустымй индекс";
	}
}
