package bricks;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Game {
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(reader.readLine()); // get size of the board
		Board my_board = new Board(n);
		System.out.println("ok\n");
		System.out.println(my_board.toString()); // clean board
		
		String[] line = reader.readLine().split(","); // get coordinates of occupied squares
		for(int i = 0; i < line.length; i += 2) {
			int x = Integer.parseInt(line[i].replace("{", ""));
			int y = Integer.parseInt(line[i+1].replace("}", ""));
			my_board.board[y][x].setState();
		}
		System.out.println("ok\n");
		System.out.println(my_board.toString()); // board with occupied squares
	}
}
