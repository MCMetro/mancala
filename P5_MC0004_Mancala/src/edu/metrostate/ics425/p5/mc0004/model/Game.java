package edu.metrostate.ics425.p5.mc0004.model;

import java.io.Serializable;
import java.util.List;

/**
 * @author Mux
 *
 */
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

	private enum playerSides {
		ONE(new int[] { 1, 2, 3, 4, 5, 6 }), TWO(new int[] { 8, 9, 10, 11, 12 });

		playerSides(int[] is) {
			// TODO Auto-generated constructor stub
		}
	}

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
		// TODO: validate which player's move it is and only allow that player's pockets
		// to be moved.
		if (isValid(player, pNum) == false) {

		} else {
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
				// if the last stone falls in an empty pocket on your side, add the stones in
				// that pocket to the final pocket.
				// Add a check to ensure the last stone was on the proper side.
				if (numStones == 1) {
					int oppositePocket = getOppositePocket(nextPocket);
					if (gameBoard[nextPocket] == 1) {
						gameBoard[nextPocket] = gameBoard[nextPocket] + gameBoard[oppositePocket];
						gameBoard[oppositePocket] = 0;
					}
					System.out.println("Final Pocket Count: " + gameBoard[nextPocket]);
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
		}
		System.out.println("Current Player: " + player);
	}

	private boolean isValid(int player, int pocket) {
		boolean valid = false;
		if (player == 1 && pocket > 0 && pocket < 7) {
			valid = true;
		} else if (player == 2 && pocket > 7 && pocket < 14) {
			valid = true;
		}
		return valid;
	}

	/**
	 * @param finalPocket
	 * @return The pocket exactly opposite the last pocket a stone was placed in
	 */
	private int getOppositePocket(int finalPocket) {
		int oppositePocket = finalPocket;
		for (int i = 7; i > 0; i--) {
			System.out.println("current pocket: " + oppositePocket);
			oppositePocket = nextPocket(oppositePocket);
		}
		return oppositePocket;
	}

	/**
	 * @param nextPocket
	 * @return The next pocket to move a stone to
	 */
	private int nextPocket(int nextPocket) {

		return (nextPocket + 1) % 14;

	}

	public int getPlayer() {
		return player;
	}

}
