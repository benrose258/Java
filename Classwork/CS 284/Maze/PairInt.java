package Maze;

/**
 * Name: Ben Rose
 * CS 284 Section B
 * I pledge my honor that I have abided by the Stevens Honor System. -Ben Rose
 */

public class PairInt {

	private int x;
	private int y;

	public PairInt(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public void setX(int x) {
		this.x = x;
	}

	public void setY(int y) {
		this.y = y;
	}

	public boolean equals(Object obj) {
		PairInt p = (PairInt) obj;
		return x == p.x && y == p.y;
	}

	public String toString() {
		return "("+x+","+y+")";
	}

	public PairInt copy() {
		PairInt copy = new PairInt(x,y);
		return copy;
	}
	
}
