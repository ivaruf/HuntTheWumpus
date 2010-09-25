package model;

import program.Generator;

public class Maze {

	private Room[][] rooms;
	private int dimension;
	private int entranceRow;
	private int entranceColumn;

	public Maze(int dimension) {
		rooms = new Room[dimension][dimension];
		this.dimension = dimension;
		entranceRow = dimension -1;
		entranceColumn = (dimension - 1) / 2;
		initRooms();
		setEntrance();
		setOuterWalls();
		// generate initial path from entrance...
		generatePath(dimension * 3, "N", entranceRow, entranceColumn);
		for (int numberOfForks = 0; numberOfForks < dimension / 2; numberOfForks++) {
			generateFork();
		}
	}

	private void generateFork() {
		boolean newPath = false;
		while (!newPath) {
			int row = Generator.randomCooridnate(dimension);
			int column = Generator.randomCooridnate(dimension);
			if (getRoom(row, column).isPath()) {
				String direction = Generator.chooseRandomDirection();
				generatePath(dimension, direction, row, column);
				newPath = true;
			}
		}
	}

	private void setOuterWalls() {
		for (int row = 0; row < dimension; row++) {
			for (int column = 0; column < dimension; column++) {
				if (row == 0 || row == dimension - 1 || column == 0
						|| column == dimension - 1) {
					rooms[row][column].setWall(true);
				}
			}
		}
	}

	private void setEntrance() {
		// entrance is set to the room that is to the far south, and in the
		// middle
		Room entrance = getRoom(entranceRow, entranceColumn);
		entrance.setEntrance(true);
		entrance.setPath(true);
	}

	private void initRooms() {
		for (int row = 0; row < dimension; row++) {
			for (int column = 0; column < dimension; column++) {
				rooms[row][column] = new Room();
			}
		}
	}

	private void generatePath(int steps, String directionTendency, int startRow,
			int startColumn) {
		int currentRow = startRow;
		int currentColumn = startColumn;

		boolean tendency = true;
		String direction;

		for (int i = 0; i < steps; i++) {
			if (tendency) {
				direction = directionTendency;
				tendency = false;
			} else {
				tendency = true;
				direction = Generator.chooseRandomDirection();
			}
			// go north, -1 row
			if (direction.equals("N")) {
				currentRow = currentRow - 1;
			}
			// go east, +1 column
			else if (direction.equals("E")) {
				currentColumn = currentColumn + 1;
			}
			// go south, row +1;
			else if (direction.equals("S")) {
				currentRow = currentRow + 1;
			}
			// go west, -1 column
			else if (direction.equals("W")) {
				currentColumn = currentColumn - 1;
			}

			Room roomToheck = getRoom(currentRow, currentColumn);
			if (roomToheck.isWall()) {
				break;
			} else {
				roomToheck.setPath(true);
			}
		}
	}

	public Room getRoom(int row, int column) {
		return rooms[row][column];
	}

	public void printMaze(Room playerPosition) {
		int dimension = rooms.length;

		for (int row = 0; row < dimension; row++) {
			for (int column = 0; column < dimension; column++) {
				if(rooms[row][column] == playerPosition) {
					System.out.print("@ ");
				}
				else if (rooms[row][column].isEntrance()) {
					System.out.print("  ");
				} 
				else if (rooms[row][column].isWall()) {
					System.out.print("# ");
				}
				else if (rooms[row][column].isPath()) {
					System.out.print("  ");
				}
				else {
					System.out.print("x ");
				}
			}
			System.out.print('\n');
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

	public Room getEntrance() {
		return getRoom(entranceRow, entranceColumn);
	}

	public int getEntranceRow() {
		return entranceRow;
	}

	public int getEntranceColumn() {
		return entranceColumn;
	}

	public int[] getRowAndColumn(Room position) {
		int[] coordinates = new int[2];
		for(int row = 0 ; row < dimension; row ++) {
			for(int column = 0; column < dimension; column++) {
				if(position == getRoom(row, column)) {
					coordinates[0] = row;
					coordinates[1] = column;
				}
			}
		}
		return coordinates;
	}
}
