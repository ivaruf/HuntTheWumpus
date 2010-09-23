package model;

public class Room {
	
	private boolean isEntrance;
	private boolean isPath;
	private boolean isWall;
	
	
	public Room() {
		isEntrance = false;
		isPath = false;
		isWall = false;
		
	}

	public boolean isWall() {
		return isWall;
	}

	public void setWall(boolean isWall) {
		this.isWall = isWall;
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
