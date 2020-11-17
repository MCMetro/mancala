package edu.metrostate.ics425.p5.mc0004.model;

import java.io.Serializable;
import java.util.List;

public class Game implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 20201105001L;

	public Game() {

	}

	private static final int NUM_POCKETS = 14;
	private int turn;
	static int startingStones = 4;
	static List<Pocket> gameBoard;
//	private static int[] gameBoard;

	public void createBoard() {
		for (int i = 0; i < NUM_POCKETS; i++) {
			if (i >= 0 && i <= 6) {
				if (i == 0) {
					Pocket s1 = new Pocket(startingStones, true, 1);
					System.out.println(s1);
					gameBoard.add(s1); 
				} else {
					Pocket p1 = new Pocket(startingStones, false, 1);
					gameBoard.add(p1); 
				}
			} else if (i >= 7 && i <= 14) {
				if (i == 7) {
					Pocket s2 = new Pocket(startingStones, true, 2);
					gameBoard.add(s2); 
				} else {
					Pocket p1 = new Pocket(startingStones, false, 2);
					gameBoard.add(p1); 
				}
			}
			
		}
		System.out.println(gameBoard);
//		gameBoard = new int[NUM_POCKETS];
//		for (int i = 0; i < NUM_POCKETS; i++) {
//			if (i >= 0 && i <= 6) {
//				if (i == 0) {
//					gameBoard[i] = 0;
//				} else {
//					gameBoard[i] = startingStones;
//				}
//			} else if (i >= 7 && i <= 14) {
//				if (i == 7) {
//					gameBoard[i] = 0;
//				} else {
//					gameBoard[i] = startingStones;
//				}
//			}
//
//		}

	}

	public static List<Pocket> getGameBoard() {
		return gameBoard;
	}

	public int getTurn() {
		return turn;
	}

	public void setTurn(int turn) {
		this.turn = turn;
	}

}
