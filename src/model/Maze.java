package model;

import java.util.Random;

public class Maze {
	
	Room[][] rooms;
	
	public Maze(int dimension) {
		rooms = new Room[dimension][dimension];
		initRooms();		
		setEntrance(dimension);
		setOuterWalls(dimension);
		
	}

	private void setOuterWalls(int dimension) {
		for(int row = 0; row < dimension; row++) {
			for(int column = 0; column < dimension; column++) {
				if(row == 0 || row == dimension-1 || column == 0 || column == dimension-1) {
					rooms[row][column].setWall(true);
				}
			}
		}
	}

	private void setEntrance(int dimension) {
		//entrance is set to the room that is to the far south, and in the middle
		rooms[dimension-1][(dimension-1)/2].setEntrance(true);
		//room directly north of entrance is set to path
		rooms[dimension-2][(dimension-1)/2].setPath(true);
	}

	private void initRooms() {
		for (int i = 0; i < rooms.length; i++) {
			for (int j = 0; j < rooms[i].length; j++) {
				rooms[i][j] = new Room();
			}
		}
	}

	public int getNumberOfRooms() {
		int numberOfRooms = 0;
		for (int i = 0; i < rooms.length; i++) {
			for (int j = 0; j < rooms[i].length; j++) {
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
	
	
	public int chooseRandomDirection() {
		Random random = new Random();
		return random.nextInt(4)+1;
	}
}
		
