package test;

import static org.junit.Assert.*;

import model.Maze;

import org.junit.Test;

import program.WumpusController;

public class WumpusControllerTest {
	
	@Test
	public void playerIsCreatedAndLocatedAtEntranceWhenGameBegins() throws Exception {
		WumpusController wumpusController = new WumpusController(30);
		assertEquals(wumpusController.getPlayer().getPosition(), wumpusController.getMaze().getEntrance());
	}
	
	@Test
	public void playerIsAtCorrectPositionAfterOneMoveNorth() throws Exception {		
		WumpusController wumpusController = new WumpusController(10);
		wumpusController.movePlayer("N");
		Maze maze = wumpusController.getMaze();
		assertEquals(wumpusController.getPlayer().getPosition(),
				maze.getRoom(maze.getEntranceRow()-1, maze.getEntranceColumn()));
	}

}
