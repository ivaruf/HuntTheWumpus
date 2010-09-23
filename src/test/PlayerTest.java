package test;

import static org.junit.Assert.*;

import model.Maze;
import model.Player;

import org.junit.Test;

public class PlayerTest {
	
	@Test
	public void playerIsCreatedAndLocatedAtEntranceWhenGameBegins() throws Exception {
		
		Maze maze = new Maze(6);
		Player player = new Player(maze);
		assertEquals(player.getPosition(), maze.getEntrance());
	}
	
	@Test
	public void playerIsAtCorrectPositionAfterOneMoveNorth() throws Exception {		
		Maze maze = new Maze(6);
		Player player = new Player(maze);
		player.move("N");
		assertEquals(player.getPosition(), maze.getRoom(maze.getEntranceRow()-1, maze.getEntranceColumn()));
	}

}
