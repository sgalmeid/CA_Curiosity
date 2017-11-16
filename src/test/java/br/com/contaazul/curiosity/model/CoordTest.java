package br.com.contaazul.curiosity.model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.contaazul.curiosity.CuriosityApplication;
import br.com.contaazul.curiosity.exception.InvalidPositionException;


@RunWith(SpringRunner.class)
@SpringBootTest(classes={CuriosityApplication.class})
public class CoordTest {

	private static final int Y_MAX = 5;
	private static final int X_MAX = 5;
	
	@Value("${map.len.x}")
	private int lenX;
	@Value("${map.len.y}")
	private int lenY;
	
	private Coord position;
	@Autowired
	private Coord positionByProperties;

	@Before
	public void init() throws InvalidPositionException{
	 position = new Coord(X_MAX,Y_MAX);

	}
	
	@Test(expected=InvalidPositionException.class)
	public void testPosition0_0() throws InvalidPositionException {
		new Coord(0,0);
	}
	
	@Test(expected=InvalidPositionException.class)
	public void testPosition1_0() throws InvalidPositionException {
		new Coord(1,0);
	}
	
	@Test(expected=InvalidPositionException.class)
	public void testPosition0_1() throws InvalidPositionException {
		new Coord(1,0);
	}
	
	@Test
	public void testPosition() throws InvalidPositionException {
		Coord position = new Coord(1,1);
		assertNotNull(position);
	}
	
	@Test(expected=InvalidPositionException.class)
	public void testSetPositionXLowerZero() throws InvalidPositionException {
		position.setPosition(-1,0);
	}
	
	@Test(expected=InvalidPositionException.class)
	public void testSetPositionYLowerZero() throws InvalidPositionException {
		position.setPosition(0,-1);
	}
	
	@Test(expected=InvalidPositionException.class)
	public void testSetPositionXGraterMax() throws InvalidPositionException {
		position.setPosition(X_MAX,Y_MAX-1);
	}
	
	@Test(expected=InvalidPositionException.class)
	public void testSetPositionYGraterMax() throws InvalidPositionException {
		position.setPosition(X_MAX-1,Y_MAX);
	}
	
	@Test(expected=InvalidPositionException.class)
	public void testSetPositionMax() throws InvalidPositionException {
		position.setPosition(X_MAX,Y_MAX);
	}
	
	@Test
	public void testSetPosition0_0() throws InvalidPositionException {
		position.setPosition(0,0);
	}

	@Test
	public void testSetPositionOk() throws InvalidPositionException {
		position.setPosition(X_MAX-1,Y_MAX-1);
	}
	
	
	
	@Test(expected=InvalidPositionException.class)
	public void testSetPositionByPropXGraterMax() throws InvalidPositionException {
		positionByProperties.setPosition(lenX,lenY-1);
	}
	
	@Test(expected=InvalidPositionException.class)
	public void testSetPositionByPropYGraterMax() throws InvalidPositionException {
		positionByProperties.setPosition(lenX-1,lenY);
	}
	
	@Test(expected=InvalidPositionException.class)
	public void testSetPositionByPropMax() throws InvalidPositionException {
		positionByProperties.setPosition(lenX,lenY);
	}
	

	@Test
	public void testSetPositionByPropOk() throws InvalidPositionException {
		positionByProperties.setPosition(lenX-1,lenY-1);
	}
	
}
