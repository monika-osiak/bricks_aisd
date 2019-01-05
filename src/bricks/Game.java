package bricks;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Set;

public class Game {
	public static void getNextMove(BufferedReader reader, Board board) throws IOException {
		String read = reader.readLine();
		if(read == "start")
			return;
		String[] line = read.split(",");
		int x1 = Integer.parseInt(line[0].replace("{", ""));
		int y1 = Integer.parseInt(line[1].replace("}", ""));
		int x2 = Integer.parseInt(line[2].replace("{", ""));
		int y2 = Integer.parseInt(line[3].replace("}", ""));
		board.board[y1][x1].setState();
		board.board[y2][x2].setState();
	}
	
	public static void generateNextMove(Board board, Set<Brick> moves) {
		for(Brick b : moves) {
			if(b.getS1().getState() == State.FULL || b.getS2().getState() == State.FULL) {
				continue;
			}
			b.getS1().setState();
			b.getS2().setState();
			System.out.println(b);
			break;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(reader.readLine()); // get size of the board
		Board myBoard = new Board(n);
		System.out.println("ok\n");
		// TEST System.out.println(myBoard.toString()); // clean board
		
		String[] line = reader.readLine().split(","); // get coordinates of occupied squares
		for(int i = 0; i < line.length; i += 2) {
			int x = Integer.parseInt(line[i].replace("{", ""));
			int y = Integer.parseInt(line[i+1].replace("}", ""));
			myBoard.board[y][x].setState();
		}
		System.out.println("ok\n");
		
		
		// TEST System.out.println(myBoard.toString()); // board with occupied squares
		
		Set<Brick> availableMoves = myBoard.getAllAvailableMoves();
		// TEST System.out.println("AVAILABLE MOVES: " + availableMoves.size());
		
		while(true) {
			Game.getNextMove(reader, myBoard);
			Game.generateNextMove(myBoard, availableMoves);
		}
		
		/*
		 * TO DO: main loop of the game:
		 * while(true)
		 *     if readline == 'start' -> generate move
		 *     else set opponent's move on the board and generate move 
		 */
		
		// THIS IS TEST!!!
		
		/*
		 * I use a loop here to iterate over all of the available moves and use them if I can.
		 */
		
		/*int movesUsed = 0;
		int movesNotUsed = 0;
		for(Brick b : availableMoves) {
			System.out.print(b);
			if(b.getS1().getState() == State.FULL || b.getS2().getState() == State.FULL) {
				movesNotUsed++;
				System.out.println(" not used");
				continue;
			}
			b.getS1().setState();
			b.getS2().setState();
			System.out.println(" used");
			movesUsed++;
		}
		
		System.out.println("\n" + myBoard.toString()); // board after setting all the squares
		
		System.out.println("\nSUMMARY");
		System.out.println("Moves used in test: " + movesUsed);
		System.out.println("Moves not used in test: " + movesNotUsed);
		System.out.println("All moves processed? " + (movesUsed + movesNotUsed == availableMoves.size()));*/
		
		/*
		 * TO DO: after making a move we need to update set of the available moves
		 *        because one is already used and some others may not be longer available
		 */
	}
}
