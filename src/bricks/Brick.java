package bricks;

public class Brick {
	private Square s1;
	private Square s2;
	
	public Brick(Square s1, Square s2) {
		this.s1 = s1;
		this.s2 = s2;
	}
	
	public Square getS1() {
		return this.s1;
	}
	
	public Square getS2() {
		return this.s2;
	}
	
	public String toString() {
		return s1.toString() + "," + s2.toString();
	}
}
