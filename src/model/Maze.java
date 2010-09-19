package model;

import program.Generator;

public class Maze {
	
	private Room[][] rooms;
	private int dimension;
	
	public Maze(int dimension) {
		rooms = new Room[dimension][dimension];
		this.dimension = dimension;
		initRooms();		
		setEntrance();
		setOuterWalls();
		generateInitialPath(100);
		
	}

	private void setOuterWalls() {
		for(int row = 0; row < dimension; row++) {
			for(int column = 0; column < dimension; column++) {
				if(row == 0 || row == dimension-1 || column == 0 || column == dimension-1) {
					rooms[row][column].setWall(true);
				}
			}
		}
	}

	private void setEntrance() {
		//entrance is set to the room that is to the far south, and in the middle
		rooms[dimension-1][(dimension-1)/2].setEntrance(true);
		//room directly north of entrance is set to path
		rooms[dimension-2][(dimension-1)/2].setPath(true);
	}

	private void initRooms() {
		for (int row = 0; row < rooms.length; row++) {
			for (int column = 0; column < rooms[row].length; column++) {
				rooms[row][column] = new Room();
			}
		}
	}
	
	private void generateInitialPath(int steps) {
		//start at room north of entrance
		int currentRow = dimension-2;
		int currentColumn = (dimension-1)/2;
		
		int nextRow = currentRow;
		int nextColumn = currentColumn;
		Room roomToheck;
		
		for(int i = 0; i < steps; i++) {
			int direction = Generator.chooseRandomDirection();
			// go north, -1 row
			if(direction == 1){
				nextRow = currentRow -1;
				nextColumn = currentColumn;
			}
			//go east, +1 column
			else if(direction == 2){
				nextRow = currentRow;
				nextColumn = currentColumn +1;
				
			}
			//go south, row +1;
			else if(direction == 3){
				nextRow = currentRow+1;
				nextColumn = currentColumn;
			}
			//go west, -1 column
			else if(direction == 4){
				nextRow = currentRow;
				nextColumn = currentColumn-1;
			}
			
			if(nextColumn <= dimension || nextRow <= dimension) {
				roomToheck = getRoom(nextRow, nextColumn);
				if(!roomToheck.isEntrance && !roomToheck.isWall) {
					roomToheck.setPath(true);
					currentRow = nextRow;
					currentColumn = nextColumn;
				}
			}
		}
	}

	public int getNumberOfRooms() {
		int numberOfRooms = 0;
		for (int row = 0; row < rooms.length; row++) {
			for (int column = 0; column < rooms[row].length; column++) {
				numberOfRooms++;
			}
		}
		return numberOfRooms;
	}

	public Room getRoom(int row, int column) {
		return rooms[row][column];
	}

	public void printMaze() {
		int dimension = rooms.length;
		
		for(int row = 0; row < dimension; row++) {
			for(int column = 0; column < dimension; column++) {
				
				if(rooms[row][column].isEntrance) {
					System.out.print("  ");
				}
				else if(rooms[row][column].isWall()) {
					System.out.print("# ");
				}
				else if(rooms[row][column].isPath()) {
					System.out.print("  ");
				}
				else {
					System.out.print("x ");
				}
			}
			System.out.print('\n');
		}
	}
}
		
