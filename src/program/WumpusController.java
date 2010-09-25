package program;

import model.Maze;
import model.Player;

public class WumpusController {
	
	private Player player;
	private Maze maze;
	

	public static void main(String[] args) {
		WumpusController wumpusController = new WumpusController(40);
	}
	
	public WumpusController(int size) {
		maze = new Maze(size);
		player = new Player();
		player.setPosition(maze.getEntrance());
		
		//maze.printMaze();
	}
	
	public void movePlayer(String direction) {
		int[] coordinates = maze.getRowAndColumn(player.getPosition());
		int row = coordinates[0];
		int column = coordinates[1];
		if(direction == "N"){
			player.setPosition(maze.getRoom(row-1, column));
		}
		
	}

	/*
	 * Getters and setters, used in tests.
	 */
	public Player getPlayer() {
		return player;
	}
	
	public void setPlayer(Player player) {
		this.player = player;
	}
	
	public Maze getMaze() {
		return maze;
	}
	
	public void setMaze(Maze maze) {
		this.maze = maze;
	}
}
