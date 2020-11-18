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
//	static List<Pocket> gameBoard;
	private static int[] gameBoard;
	private int player = 1;

	public void createGameBoard() {
//		for (int i = 0; i < NUM_POCKETS; i++) {
//			if (i >= 0 && i <= 6) {
//				if (i == 0) {
//					Pocket s1 = new Pocket(startingStones, true, 1);
//					System.out.println(s1);
//					gameBoard.add(s1); 
//				} else {
//					Pocket p1 = new Pocket(startingStones, false, 1);
//					gameBoard.add(p1); 
//				}
//			} else if (i >= 7 && i <= 14) {
//				if (i == 7) {
//					Pocket s2 = new Pocket(startingStones, true, 2);
//					gameBoard.add(s2); 
//				} else {
//					Pocket p1 = new Pocket(startingStones, false, 2);
//					gameBoard.add(p1); 
//				}
//			}
//			
//		}
//		//test printing the gameBoard
//		System.out.println(gameBoard);

		// This is an attempt I made at making the game board just a simple int array.
		// Initialization of this on line 21

		gameBoard = new int[NUM_POCKETS];
		for (int i = 0; i < NUM_POCKETS; i++) {
			if (i >= 0 && i <= 6) {
				if (i == 0) {
					gameBoard[i] = 0;
				} else {
					gameBoard[i] = startingStones;
				}
			} else if (i >= 7 && i <= 14) {
				if (i == 7) {
					gameBoard[i] = 0;
				} else {
					gameBoard[i] = startingStones;
				}
			}

		}
		player = 1;
		System.out.println("player: " + player);

	}

	public int[] getGameBoard() {
		return gameBoard;
	}

	public int getTurn() {
		return turn;
	}

	public void setTurn(int turn) {
		this.turn = turn;
	}

	public void setMove(int pNum) {
		var numStones = gameBoard[pNum];
		var nextPocket = nextPocket(pNum);
		while (numStones > 0) {
			System.out.println("stones left: " + gameBoard[pNum]);
			System.out.println("next pocket: " + nextPocket);
			if (nextPocket == 0) {
				if (player == 1) {
					gameBoard[nextPocket]++;
				} else {
					nextPocket = nextPocket(nextPocket);
					gameBoard[nextPocket]++;
				}
			} else if (nextPocket == 7) {
				if (player == 2) {
					gameBoard[nextPocket]++;
				} else {
					nextPocket = nextPocket(nextPocket);
					gameBoard[nextPocket]++;
				}
			} else {
				gameBoard[nextPocket]++;
			}
			if (numStones == 1) {
				//TODO if the last stone falls in an empty pocket on your side, add the stones in that pocket to the final pocket.
				int oppositePocket = getOppositePocket(nextPocket);
				System.out.println("Final Pocket: " + nextPocket);
				System.out.println("Opposite Pocket: " + oppositePocket);
			}
			gameBoard[pNum] = gameBoard[pNum] - 1;
			nextPocket = nextPocket(nextPocket);
			numStones--;
		}
		System.out.println("setMove...");
		if (player == 1) {
			player = 2;
		} else {
			player = 1;
		}
		System.out.println("Current Player: " + player);
	}
	
	//Discover the pocket opposite a given pocket.
	private int getOppositePocket(int finalPocket) {
		int oppositePocket = finalPocket;
		for (int i = 7; i > 0; i--) {
			System.out.println("current pocket: " + oppositePocket);
			oppositePocket = nextPocket(oppositePocket);
		}
		return oppositePocket;
	}

	private int nextPocket(int nextPocket) {
		if (nextPocket == 13) {
			nextPocket = 0;
		} else {
			nextPocket++;
		}
		return nextPocket;
	}

	public int getPlayer() {
		return player;
	}

}
