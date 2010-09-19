package test;

import static org.junit.Assert.*;

import org.junit.Test;

import program.WumpusController;

public class ControllerTest {
	
	@Test
	public void wumpusControllerCanChooseANumberBetween1and4() throws Exception {
		WumpusController controller = new WumpusController();
		int direction = controller.chooseRandomDirection();
		boolean success = false;
		if(direction == 1 || direction == 2 || direction == 3 || direction == 4) {
			success = true;
		}
		assertTrue(success);
		
	}

}
