package com.xoxo.player;


import com.xoxo.board.Board;
import com.xoxo.board.FieldNotEmptyException;
import java.util.Scanner;


/**
 * Игрок-человек
 */
public class HumanPlayer extends AbstractPlayer {

	/**
	 * @see AbstractPlayer
	 */
	public HumanPlayer(String name, char symbol) throws PlayerNotSetException {
		super(name, symbol);
	}

	@Override
	public void makeMove(Board board) throws BoardIsFullException {
		if (board.isFull()) {
			throw new BoardIsFullException();
		}
		boolean moved = false;
		do {
			try {
				int row = requestIndex("Строка: ", board);
				int column = requestIndex("Столбец: ", board);
				board.setFieldValue(row, column, symbol);
				moved = true;
			} catch (FieldNotEmptyException fieldException) {
				System.out.println(fieldException.getMessage());
			} catch (PlayerMoveException moveException) {
				System.out.println(moveException.getMessage());
			} catch (Exception unknownException) {
				System.out.println("Ошибка. " + unknownException.getMessage());
				unknownException.printStackTrace();
			}
		} while (!moved);
	}

	/**
	 * Запросить пользователя ввести индекс для ячеки
	 * @param fieldMessage Подсказка для ввода
	 * @param board Доска (игровое поле)
	 * @return Введённый пользователем индекс
	 * @throws PlayerMoveException
	 */
	private int requestIndex(String fieldMessage, Board board) throws PlayerMoveException {
		System.out.println(fieldMessage);
		Scanner sc = new Scanner(System.in);
		int index = sc.nextInt();
		index--;
		if (index < 0 || index >= board.getSize()) {
			throw new MoveIndexOutOfBoundException();
		}
		return index;
	}
}
