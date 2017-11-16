package br.com.contaazul.curiosity.services;

import org.springframework.stereotype.Service;

import br.com.contaazul.curiosity.exception.InvalidCommandException;
import br.com.contaazul.curiosity.exception.InvalidPositionException;
import br.com.contaazul.curiosity.exception.InvalidRotationException;
import br.com.contaazul.curiosity.helpers.Sides;
import br.com.contaazul.curiosity.model.BotLocation;

@Service
public class MovimentManager {
	
	public BotLocation moveTo(String command, BotLocation position) throws InvalidRotationException, InvalidPositionException, InvalidCommandException{
		String[] split = command.split("");
		for (String value : split) {
			switch (value) {
			case "M":
				position.move();
				break;
			case "L":
			case "R":
				position.turnTo(Sides.valueOf(value));
				break;
			default:
				throw new InvalidCommandException("Invalid Command");
			}
		}
		return position;
	}
}
