package br.com.contaazul.curiosity.helpers;

import br.com.contaazul.curiosity.exception.InvalidRotationException;

public enum Cardinals {
	NORTH, EAST, SOUTH, WEST;
	
	  public Cardinals turn(Sides rotation) throws InvalidRotationException {
		  
		  switch (rotation) {
		case L:
			int position = (ordinal() == 0 ? values().length - 1 : ordinal() - 1) % 4;
			return values()[position];
		case R:
			return values()[(ordinal() + 1) % 4];

		default:
			throw new InvalidRotationException("The '"+rotation +"'is not a valid option" );
		}

		  
	  }
	  
	  @Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.name().substring(0,1);
	}
}
