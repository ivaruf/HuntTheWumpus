package program;

import java.util.Random;

public class Generator {
	
	static public int chooseRandomDirection() {
		Random random = new Random();
		return random.nextInt(4)+1;
	}

	static public int randomCooridnate(int dimention) {
		Random random = new Random();
		return random.nextInt(dimention)+1;
	}

}
