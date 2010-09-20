package model;

import program.Generator;

public class Maze {
	
	private Room[][] rooms;
	private int dimention;
	
	public Maze(int dimention) {
		rooms = new Room[dimention][dimention];
		this.dimention = dimention;
		initRooms();		
		setEntrance();
		setOuterWalls();
		//generate initial path from entrance...
		generatePath(dimention*2, true, 1, dimention-2, (dimention-1)/2);
		for(int i = 0; i < dimention; i++) {
			generatePath(dimention/4, false, Generator.chooseRandomDirection(),
						Generator.randomCooridnate(dimention), Generator.randomCooridnate(dimention));
		}
	}

	private void setOuterWalls() {
		for(int row = 0; row < dimention; row++) {
			for(int column = 0; column < dimention; column++) {
				if(row == 0 || row == dimention-1 || column == 0 || column == dimention-1) {
					rooms[row][column].setWall(true);
				}
			}
		}
	}

	private void setEntrance() {
		//entrance is set to the room that is to the far south, and in the middle
		rooms[dimention-1][(dimention-1)/2].setEntrance(true);
		//room directly north of entrance is set to path
		rooms[dimention-2][(dimention-1)/2].setPath(true);
	}

	private void initRooms() {
		for (int row = 0; row < rooms.length; row++) {
			for (int column = 0; column < rooms[row].length; column++) {
				rooms[row][column] = new Room();
			}
		}
	}
	
	private void generatePath(int steps, boolean initial, int directionTendency, int startRow, int startColumn) {
		int currentRow = startRow;
		int currentColumn = startColumn;
		
		boolean hitInitialPath = false;
		boolean tendency = true;
		int direction;
		
		for(int i = 0; i < steps; i++) {
			if(tendency){
				direction = directionTendency;
				tendency = false;
			}
			else {
				tendency = true;				
				direction = Generator.chooseRandomDirection();
			}
			// go north, -1 row
			if(direction == 1){
				currentRow = currentRow -1;
			}
			//go east, +1 column
			else if(direction == 2){
				currentColumn = currentColumn +1;
			}
			//go south, row +1;
			else if(direction == 3){
				currentRow = currentRow+1;
			}
			//go west, -1 column
			else if(direction == 4){
				currentColumn = currentColumn-1;
			}
			
			if(currentColumn < dimention && currentRow < dimention && currentRow > 0 && currentColumn > 0) {
				Room roomToheck = getRoom(currentRow, currentColumn);
				if(!initial && roomToheck.isInitialPath()) {
					hitInitialPath = true;
				}
				if(!roomToheck.isEntrance() && !roomToheck.isWall()) {
					roomToheck.setPath(true);
					if(initial){
						roomToheck.setInitialPath(true);
					}
				}
			}
		}
		if(!hitInitialPath) {
//			boolean eastBreakout = false;
//			
//			while()
//			breakOutEastAndWest(currentRow, currentColumn);
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
				
				if(rooms[row][column].isEntrance()) {
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
		
