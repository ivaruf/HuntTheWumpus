package program;

import java.util.Random;

public class Generator {
	
	static public String chooseRandomDirection() {
		Random random = new Random();
		int direction = random.nextInt(4)+1;
		if(direction == 1) 
			return "N";
		if(direction == 2) 
			return "E";
		if(direction == 3) 
			return "S";
		if(direction == 4) 
			return "W";		
		else return "error";
	}

	static public int randomCooridnate(int dimension) {
		Random random = new Random();
		return random.nextInt(dimension-2)+1;
	}

}
