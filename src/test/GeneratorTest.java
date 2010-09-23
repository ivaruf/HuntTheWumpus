package test;

import static org.junit.Assert.*;

import org.junit.Test;

import program.Generator;

public class GeneratorTest {

	@Test
	public void chooseRandomDirectionTest() throws Exception {
		String direction = Generator.chooseRandomDirection();
		boolean success = false;
		if(direction.equals("N")|| direction.equals("E") || direction.equals("S") || direction.equals("W")) {
			success = true;
		}
		assertTrue(success);
	}
	
	
}
