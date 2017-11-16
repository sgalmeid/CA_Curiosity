package br.com.contaazul.curiosity.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import br.com.contaazul.curiosity.exception.InvalidCommandException;
import br.com.contaazul.curiosity.exception.InvalidPositionException;
import br.com.contaazul.curiosity.exception.InvalidRotationException;
import br.com.contaazul.curiosity.services.MovimentManager;

@Component
@Scope("request")
public class CuriosityBot {
	
	@Autowired
	private BotLocation data;

	@Autowired
	MovimentManager moviment;
	
	public String moveTo(String move) throws InvalidRotationException, InvalidPositionException, InvalidCommandException{
		moviment.moveTo(move, data);
		return data.toString();
	}
}
