package bricks;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Set;

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
		
		Set<Brick> available_moves = my_board.getAllAvailableMoves();
		System.out.println("AVAILABLE MOVES: " + available_moves.size());

		for(Brick b : available_moves) {
			System.out.println(b);
			b.getS1().setState();
			b.getS2().setState();
		}
		
		System.out.println("\n" + my_board.toString()); // board after setting all the squares
		
		/*
		 * TO DO: after making a move we need to update set of the available moves
		 *        because one is already used and some others may not be longer available
		 */
	}
}
