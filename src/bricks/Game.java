package bricks;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Set;

public class Game {
	public static void getNextMove(BufferedReader reader, Board board) throws IOException {
		String read = reader.readLine();
		if (read.equals("Start") || read.equals("start") || read.equals("START")) {
			return;
		}
		String[] line = read.split("[,;]");
		int x1 = Integer.parseInt(line[0].replace("{", ""));
		int y1 = Integer.parseInt(line[1].replace("}", ""));
		int x2 = Integer.parseInt(line[2].replace("{", ""));
		int y2 = Integer.parseInt(line[3].replace("}", ""));
		board.board[y1][x1].setState();
		board.board[y2][x2].setState();
	}

	public static void generateNextMove(Board board, Set<Brick> moves) {
		for (Brick b : moves) {
			if (b.getS1().getState() == State.FULL || b.getS2().getState() == State.FULL) {
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
		System.out.println("ok");
		
		String wholeLine;
		wholeLine = reader.readLine();
		String[] line = wholeLine.split("[,;]"); // get coordinates of occupied squares
		for (int i = 0; i < line.length; i += 2) {
			int x = Integer.parseInt(line[i].replace("{", ""));
			int y = Integer.parseInt(line[i + 1].replace("}", ""));
			myBoard.board[y][x].setState();
		}
		System.out.println("ok");

		Set<Brick> availableMoves = myBoard.getAllAvailableMoves();

		while (true) {
			Game.getNextMove(reader, myBoard);
			Game.generateNextMove(myBoard, availableMoves);
		}
	}
}
