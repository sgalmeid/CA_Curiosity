package br.com.contaazul.curiosity.helpers;

import static org.junit.Assert.*;

import org.junit.Test;

import br.com.contaazul.curiosity.exception.InvalidRotationException;

public class CardinalsTest {

	@Test
	public void testNorthToR() throws InvalidRotationException {
		assertEquals(Cardinals.EAST, Cardinals.NORTH.turn(Sides.R)); 
	}
	
	@Test
	public void testNorthToL() throws InvalidRotationException {
		assertEquals(Cardinals.WEST, Cardinals.NORTH.turn(Sides.L)); 
	}
	
	@Test
	public void testNorthToL_L() throws InvalidRotationException {
		assertEquals(Cardinals.SOUTH, Cardinals.NORTH.turn(Sides.L).turn(Sides.L)); 
	}
	
	@Test
	public void testNorthToR_R() throws InvalidRotationException {
		assertEquals(Cardinals.SOUTH, Cardinals.NORTH.turn(Sides.R).turn(Sides.R)); 
	}
	
	@Test
	public void testNorthToR_R_R() throws InvalidRotationException {
		assertEquals(Cardinals.WEST, Cardinals.NORTH.turn(Sides.R).turn(Sides.R).turn(Sides.R)); 
	}
	
	@Test
	public void testNorthToL_L_L() throws InvalidRotationException {
		assertEquals(Cardinals.EAST, Cardinals.NORTH.turn(Sides.L).turn(Sides.L).turn(Sides.L)); 
	}
	
	@Test
	public void testNorthToR_R_R_R() throws InvalidRotationException {
		assertEquals(Cardinals.NORTH, Cardinals.NORTH.turn(Sides.R).turn(Sides.R).turn(Sides.R).turn(Sides.R)); 
	}
	
	@Test
	public void testNorthToL_L_L_L() throws InvalidRotationException {
		assertEquals(Cardinals.NORTH, Cardinals.NORTH.turn(Sides.L).turn(Sides.L).turn(Sides.L).turn(Sides.L)); 
	}
	
	@Test
	public void testNorthToL_L_L_L_R_R_R_R() throws InvalidRotationException {
		assertEquals(Cardinals.NORTH, Cardinals.NORTH.turn(Sides.L).turn(Sides.L).turn(Sides.L).turn(Sides.L).turn(Sides.R).turn(Sides.R).turn(Sides.R).turn(Sides.R)); 
	}

}
