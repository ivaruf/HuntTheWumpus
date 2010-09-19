package program;

public class Maze {
	
	Room[][] room;
	
	public Maze(int dimension) {
		room = new Room[dimension][dimension];
		initRooms();		
		setEntrance(dimension);
		
	}

	private void setEntrance(int dimension) {
		//entrance is set to the room that is to the far south, and in the middle
		room[dimension-1][(dimension-1)/2].setEntrance(true);
		//room directly north of entrance is set to path
		room[dimension-2][(dimension-1)/2].setPath(true);
	}

	private void initRooms() {
		for (int i = 0; i < room.length; i++) {
			for (int j = 0; j < room[i].length; j++) {
				room[i][j] = new Room();
			}
		}
	}

	public int getNumberOfRooms() {
		int numberOfRooms = 0;
		for (int i = 0; i < room.length; i++) {
			for (int j = 0; j < room[i].length; j++) {
				numberOfRooms++;
			}
		}
		return numberOfRooms;
	}

	public Room getRoom(int row, int column) {
		return room[row][column];
	}
}
