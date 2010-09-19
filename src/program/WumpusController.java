package program;

import java.util.Random;

import model.Maze;

public class WumpusController {
	
	public static void main(String[] args) {
		Maze maze = new Maze(25);
		maze.printMaze();
	}

	public int chooseRandomDirection() {
		Random random = new Random();
		return random.nextInt(4)+1;
	}

}
