package br.com.contaazul.curiosity;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;

import br.com.contaazul.curiosity.helpers.Cardinals;
import br.com.contaazul.curiosity.model.BotLocation;
import br.com.contaazul.curiosity.model.Coord;
import br.com.contaazul.curiosity.model.CuriosityBot;

@SpringBootApplication
public class CuriosityApplication {

	public static void main(String[] args) {
		SpringApplication.run(CuriosityApplication.class, args);
	}
	
	
	@Bean
	@Scope("request")
	public CuriosityBot curiosityBot(){
		return new CuriosityBot();
	}
	
	@Bean
	@Scope("request")
	public BotLocation botLocation(Coord coord){
		return new BotLocation(Cardinals.NORTH, coord);
	}
}
