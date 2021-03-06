package bricks;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class Board {
	private int n; // size of the board, <13, 51>, odd numbers
	public Square[][] board; // actual board as a matrix
	
	public Board(int n) {
		this.n = n;
		this.board = new Square[n][n];
		for(int i = 0; i < n; i++) { // cols - like x
			for(int j = 0; j < n; j++) { // rows - like y
				this.board[i][j] = new Square(j, i);
			}
		}
	}
	
	public void addRandomBricks(int number) {
		Random randomGenerator = new Random();
		for(int i = 0; i < number; i++) {
			int x = randomGenerator.nextInt(this.n);
			int y = randomGenerator.nextInt(this.n);
			this.board[y][x].setState();
		}
	}
	
	public Set<Brick> getAvailableMoves(int x, int y) {
		Set<Brick> result = new HashSet<>();
		if(board[y][x].getState() == State.EMPTY) {
			if(getLower(x, y).getState() == State.EMPTY) {
				result.add(new Brick(board[y][x], getLower(x, y)));
			}
			if(getUpper(x, y).getState() == State.EMPTY) {
				result.add(new Brick(board[y][x], getUpper(x, y)));
			}
			if(getRight(x, y).getState() == State.EMPTY) {
				result.add(new Brick(board[y][x], getRight(x, y)));
			}
			if(getLeft(x, y).getState() == State.EMPTY) {
				result.add(new Brick(board[y][x], getLeft(x, y)));
			}
		}
		return result;
	}
	
	public Set<Brick> getAllAvailableMoves() {
		Set<Brick> result = new HashSet<>();
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				result.addAll(getAvailableMoves(j, i));
			}
		}
		return result;
	}
	
	public String toString() {
		StringBuilder result = new StringBuilder();
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				if(this.board[i][j].getState() == State.EMPTY) {
					result.append("0").append(" ");
				} else {
					result.append("1").append(" ");
				}
			}
			result.append("\n");
		}
		return result.toString();
	}
	
	private Square getUpper(int x, int y) { // y-1
		y -= 1;
		if(y < 0) {
			y = n - 1;
		}
		return board[y][x];
	}
	
	private Square getLower(int x, int y) { // y+1
		y += 1;
		if(y >= n) {
			y = 0;
		}
		return board[y][x];
	}
	
	private Square getLeft(int x, int y) { // x-1
		x -= 1;
		if(x < 0) {
			x = n - 1;
		}
		return board[y][x];
	}
	
	private Square getRight(int x, int y) { // x+1
		x += 1;
		if(x >= n) {
			x = 0;
		}
		return board[y][x];
	}
}
