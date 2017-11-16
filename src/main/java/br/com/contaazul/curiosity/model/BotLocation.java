package br.com.contaazul.curiosity.model;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import br.com.contaazul.curiosity.exception.InvalidPositionException;
import br.com.contaazul.curiosity.exception.InvalidRotationException;
import br.com.contaazul.curiosity.helpers.Cardinals;
import br.com.contaazul.curiosity.helpers.Sides;

@Component
@Scope("request")
public class BotLocation  {
	private Coord position;
	private Cardinals direction;

	public BotLocation(Cardinals cardinal,Coord position) {
		direction = cardinal;
		this.position =  position;
	}
	
	public void setPosition(int x, int y) throws InvalidPositionException {
		this.position.setPosition(x, y);
	}
	
	public void setDirection(Cardinals direction) {
		this.direction = direction;
	}
	
	public Coord getPosition() {
		return position;
	}
	
	public Cardinals getDirection() {
		return direction;
	}
	
	public void turnTo(Sides side) throws InvalidRotationException{
		direction = direction.turn(side);
	}
	
	@Override
	public boolean equals(Object obj) {
		BotLocation compare = (BotLocation)obj;
		
		return this.direction.equals(compare.direction) && position.equals(compare.position);
	}
	
	@Override
	public String toString() {
		
		return "("+position.getX()+","+position.getY()+","+direction.toString()+")";
	}

	public void move() throws InvalidPositionException {
		switch (direction){
		case EAST:
			position.setPosition(position.getX()+1,position.getY());
			break;
		case NORTH:
			position.setPosition(position.getX(),position.getY()+1);
			break;
		case SOUTH:
			position.setPosition(position.getX(),position.getY()-1);
			break;
		case WEST:
			position.setPosition(position.getX()-1,position.getY());
			break;
		default:
			break;
		
		}
		
	}
	
}