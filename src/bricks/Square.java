package bricks;

public class Square {
	private int x;
	private int y;
	private State state;
	
	public Square(int x, int y) {
		this.x = x;
		this.y = y;
		this.state = State.EMPTY;
	}
	
	public void setState() {
		this.state = State.FULL;
	}
	
	public State getState() {
		return this.state;
	}
	
	public int getX() {
		return this.x;
	}
	
	public int getY() {
		return this.y;
	}
	
	public String toString() {
		return "{" + x + "," + y + "}";
	}
}
