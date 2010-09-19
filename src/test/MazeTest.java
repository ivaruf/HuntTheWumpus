package test;

import static org.junit.Assert.*;


import org.junit.Test;

import program.Maze;
import program.Room;

public class MazeTest {
	
	@Test
	public void mazeIsInitiated() throws Exception {
		Maze maze = new Maze(5);
		assertEquals(25, maze.getNumberOfRooms());
		maze = new Maze(6);
		assertEquals(36, maze.getNumberOfRooms());
	}
	
	@Test
	public void theFarSoutMiddleRoomIsChosenAsEntrance() throws Exception {
		Maze maze = new Maze(5);
		Room entrance = maze.getRoom(4, 2);
		assertTrue(entrance.isEntrance());
		maze = new Maze(6);
		entrance = maze.getRoom(5, 2);
		assertTrue(entrance.isEntrance());
		maze = new Maze(7);
		entrance = maze.getRoom(6, 3);
		assertTrue(entrance.isEntrance());
	}
	
	@Test
	public void roomNorthOfEntranceIsPath() throws Exception {
		Maze maze = new Maze(5);
		Room northOfEntrance = maze.getRoom(3, 2);
		assertTrue(northOfEntrance.isPath());
	}
}
