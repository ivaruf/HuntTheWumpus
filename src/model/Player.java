package model;

public class Player {

	Maze maze;
	Room position;
	public Player(Maze maze) {
		this.maze = maze;
		position = maze.getEntrance();
	}

	public Room getPosition() {
		return position;
	}

	public void move(String direction) {
		int[] coordinates = maze.getRowAndColumn(position);
		int row = coordinates[0];
		int column = coordinates[1];
		if(direction == "N"){
			position = maze.getRoom(row-1, column);
		}
		
	}

}
