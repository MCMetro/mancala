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
	private static int[] gameBoard;
	private int player = 1;
	private int winner = 0;
	

	public int getWinner() {
		return winner;
	}

	public void setWinner(int winner) {
		this.winner = winner;
	}

	public void createGameBoard() {
		
		// This is an attempt I made at making the game board just a simple int array.
		// Initialization of this on line 21

		gameBoard = new int[NUM_POCKETS];
		for (int i = 0; i < gameBoard.length; i++) {
			if (i == 0 || i == 7) {
				gameBoard[i] = 0;
			} else {
				gameBoard[i] = startingStones;
			}

		}
		player = 1;
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
		System.out.println(gameWon());
		System.out.println("value of w: " + winner);
		if (gameWon() == true) {
			System.out.println("Begin gameWon If Statement...");
			if (gameBoard[0] > gameBoard[7]) {
				setWinner(2);
			} else {
				setWinner(1);
			}
		} else {
			if (isValid(player, pNum) == false) {

			} else {
				var numStones = gameBoard[pNum];
				var nextPocket = nextPocket(pNum);
				while (numStones > 0) {
					System.out.println("stones left: " + gameBoard[pNum]);
					System.out.println("next pocket: " + nextPocket);
					if (nextPocket == 7) {
						if (player == 1) {
							gameBoard[nextPocket]++;
						} else {
							nextPocket = nextPocket(nextPocket);
							gameBoard[nextPocket]++;
						}
					} else if (nextPocket == 0) {
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
							if ((player == 1 && nextPocket > 0 && nextPocket < 7)
									|| (player == 2 && nextPocket > 7 && nextPocket < 14)) {
								gameBoard[nextPocket] = gameBoard[nextPocket] + gameBoard[oppositePocket];
								gameBoard[oppositePocket] = 0;
							}
						}
//						System.out.println("Final Pocket Count: " + gameBoard[nextPocket]);
						System.out.println("Final Pocket: " + nextPocket);
//						System.out.println("Opposite Pocket: " + oppositePocket);
					}
					gameBoard[pNum]--;
					nextPocket = nextPocket(nextPocket);
					numStones--;
				}
				System.out.println("setMove...");
//				if (player == 1) {
//					player = 2;
//				} else {
//					player = 1;
//				}
				player = nextPlayer(player, nextPocket);
			}
		}
		System.out.println("Current Player: " + player);
	}

	/**
	 * @param player
	 * @param pocket
	 * @return boolean if the move is valid or not.
	 */
	private boolean isValid(int player, int pocket) {
		boolean valid = false;
		if (gameBoard[pocket] != 0) {
			if (player == 1 && pocket > 0 && pocket < 7) {
				valid = true;
			} else if (player == 2 && pocket > 7 && pocket < 14) {
				valid = true;
			}
		}
		return valid;
	}

	/**
	 * @param player
	 * @param nextPocket
	 * @return The next player
	 */
	private int nextPlayer(int player, int nextPocket) {
		// TODO: Fix! - If the last stone in a player's move lands in their own Kallah, the player gets to move again. 
		if ((player == 1 && nextPocket == 7) || (player == 2 && nextPocket == 0)) {
			return player;
		} else {
			return player == 1 ? 2 : 1;
		}
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

	/**
	 * @return Current player.
	 */
	public int getPlayer() {
		return player;
	}

	/**
	 * @return Whether the game is in a won state or not.
	 */
	public boolean gameWon() {
		int p1stones = 0;
		int p2stones = 0;
		for (int i = 1; i < 7; i++) {
			p1stones += gameBoard[i];
		}
		for (int i = 8; i < 14; i++) {
			p2stones += gameBoard[i];
		}
		if (p1stones == 0) {
			for (int i = 8; i < 13; i++) {
				gameBoard[0] += gameBoard[i];
				gameBoard[i] = 0;
			}
			return true;
		} else if (p2stones == 0) {
			for (int i = 1; i < 7; i++) {
				gameBoard[7] += gameBoard[i];
				gameBoard[i] = 0;
			}
			return true;
		}
		return false;
	}

}
