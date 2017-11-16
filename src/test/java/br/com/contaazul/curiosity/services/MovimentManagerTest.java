package br.com.contaazul.curiosity.services;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.contaazul.curiosity.CuriosityApplication;
import br.com.contaazul.curiosity.exception.InvalidCommandException;
import br.com.contaazul.curiosity.exception.InvalidPositionException;
import br.com.contaazul.curiosity.exception.InvalidRotationException;
import br.com.contaazul.curiosity.helpers.Cardinals;
import br.com.contaazul.curiosity.model.BotLocation;
import br.com.contaazul.curiosity.model.Coord;


@RunWith(SpringRunner.class)
@SpringBootTest(classes={CuriosityApplication.class})
public class MovimentManagerTest {

	
	@Test
	public void testMoveToMML() throws InvalidPositionException, InvalidRotationException, InvalidCommandException {
		BotLocation validation = new BotLocation(Cardinals.NORTH, new Coord(5,5));
		validation.setDirection(Cardinals.WEST);
		validation.setPosition(0, 2);
		
		MovimentManager moviment = new MovimentManager();
		BotLocation position = new BotLocation(Cardinals.NORTH, new Coord(5,5));
		BotLocation newLocation = moviment.moveTo("MML", position);
		
		assertEquals(validation, newLocation);
		
	}
	
	@Test
	public void testMoveToMMRMMRMM() throws InvalidPositionException, InvalidRotationException, InvalidCommandException{
		BotLocation validation = new BotLocation(Cardinals.NORTH, new Coord(5,5));
		validation.setDirection(Cardinals.SOUTH);
		validation.setPosition(2, 0);
		
		MovimentManager moviment = new MovimentManager();
		BotLocation position = new BotLocation(Cardinals.NORTH, new Coord(5,5));
		BotLocation newLocation = moviment.moveTo("MMRMMRMM", position);
		assertEquals(validation, newLocation);
	}

	@Test(expected=InvalidCommandException.class)
	public void testMoveToAAA() throws InvalidPositionException, InvalidRotationException, InvalidCommandException{
		
		MovimentManager moviment = new MovimentManager();
		BotLocation position = new BotLocation(Cardinals.NORTH, new Coord(5,5));
		moviment.moveTo("AAA", position);
	}
	
}
