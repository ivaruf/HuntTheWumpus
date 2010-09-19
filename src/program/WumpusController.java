package program;

import java.util.Random;

public class WumpusController {

	public int chooseRandomDirection() {
		Random random = new Random();
		return random.nextInt(4)+1;
	}

}
