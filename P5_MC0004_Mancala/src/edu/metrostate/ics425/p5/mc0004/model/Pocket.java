package edu.metrostate.ics425.p5.mc0004.model;

public class Pocket {
	
	private int stones;
	private boolean isStore;
	private int player;
	
	public Pocket(int stones, boolean isStore, int player) {
		this.setStones(stones);
		this.isStore = isStore;
		this.player = player;
	}

	/**
	 * @return the stones
	 */
	public int getStones() {
		return stones;
	}

	/**
	 * @param stones the stones to set
	 */
	public void setStones(int stones) {
		this.stones = stones;
	}

	/**
	 * @return the player
	 */
	public int getPlayer() {
		return player;
	}

	/**
	 * @return the isStore
	 */
	public boolean isStore() {
		return isStore;
	}
	
}
