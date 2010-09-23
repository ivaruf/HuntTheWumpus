package test;

import static org.junit.Assert.*;

import org.junit.Test;

import program.Generator;

public class GeneratorTest {

	@Test
	public void chooseRandomDirectionTest() throws Exception {
		String direction = Generator.chooseRandomDirection();
		for(int i = 0; i < 1000; i++) {
			boolean success = false;
			if(direction.equals("N")|| direction.equals("E") || direction.equals("S") || direction.equals("W")) {
				success = true;
			}
			assertTrue(success);
		}
	}
	
	@Test
	public void randomCoordinateIsWithinDimention() throws Exception {
		for(int i = 0; i < 1000; i++) {
			int test = Generator.randomCooridnate(10);
			assertTrue(test < 10);
			assertTrue(test > 0);
		}
	}
}
