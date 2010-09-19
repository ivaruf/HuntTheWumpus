package test;

import static org.junit.Assert.*;

import org.junit.Test;

import program.Generator;

public class GeneratorTest {

	@Test
	public void chooseRandomDirectionTest() throws Exception {
		int direction = Generator.chooseRandomDirection();
		boolean success = false;
		if(direction == 1 || direction == 2 || direction == 3 || direction == 4) {
			success = true;
		}
		assertTrue(success);
		
	}
}
