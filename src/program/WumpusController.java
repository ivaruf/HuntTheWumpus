package program;

import model.Maze;

public class WumpusController {
	
	public static void main(String[] args) {
		Maze maze = new Maze(25);
		maze.printMaze();
	}
}
