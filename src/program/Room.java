package program;

public class Room {
	
	boolean isEntrance;
	boolean isPath;
	boolean isWall;
	
	public boolean isWall() {
		return isWall;
	}

	public void setWall(boolean isWall) {
		this.isWall = isWall;
	}

	public Room() {
		isEntrance = false;
		isPath = false;
		isWall = false;
		
	}

	public boolean isEntrance() {
		return isEntrance;
	}

	public void setEntrance(boolean isEntrance) {
		this.isEntrance = isEntrance;
	}

	public boolean isPath() {
		return isPath;
	}

	public void setPath(boolean isPath) {
		this.isPath = isPath;
	}
	
}
