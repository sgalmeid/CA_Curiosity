package br.com.contaazul.curiosity.model;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import br.com.contaazul.curiosity.exception.InvalidPositionException;

@Component
@Scope("prototype")
public class Coord {
	@Value("${map.len.x}")
	private int lenX;
	@Value("${map.len.y}")
	private int lenY;

	int x;
	int y;
	
	public Coord() {
	}
	
	public Coord(int lenX, int lenY) throws InvalidPositionException{
		validateLen(lenX,lenY);
		this.lenX = lenX;
		this.lenY = lenY;
	}
	
	public void setPosition(int x, int y) throws InvalidPositionException{
		validate(x,y);
		this.x = x;
		this.y = y;
	}
	
	public int getX(){
		return x;
	};
	
	public int getY(){
		return y;
	};
	

	private void validate(int x, int y) throws InvalidPositionException {
		if( x < 0 || y < 0 || x >= lenX || y >= lenY){
			throw new InvalidPositionException("("+x+","+y+") is a invalid Position");
		}
		
	}

	private void validateLen(int x, int y) throws InvalidPositionException {
		if( x <= 0 || y <= 0){
			throw new InvalidPositionException("("+x+","+y+") is a lenth coodinate");
		}
		
	}
	
	@Override
	public boolean equals(Object obj) {
		Coord compare = (Coord)obj;
		return this.x == compare.x && this.y == compare.y;
	}
}
