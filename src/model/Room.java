package model;

public class Room {
	
	private boolean isEntrance;
	private boolean isPath;
	private boolean isWall;
	private boolean isInitialPath;
	
	public Room() {
		isEntrance = false;
		isPath = false;
		isWall = false;
		isInitialPath = false;
		
	}
	
	public boolean isInitialPath() {
		return isInitialPath;
	}

	public void setInitialPath(boolean isInitialPath) {
		this.isInitialPath = isInitialPath;
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
