package br.com.contaazul.curiosity.controller;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.contaazul.curiosity.exception.InvalidCommandException;
import br.com.contaazul.curiosity.exception.InvalidPositionException;
import br.com.contaazul.curiosity.exception.InvalidRotationException;
import br.com.contaazul.curiosity.model.CuriosityBot;

@Controller
@RequestMapping("/rest/mars")
public class BotController {

	@Autowired
	ApplicationContext context;

	@RequestMapping("/{command}")
	@ResponseBody
	public String sendCommand(@PathVariable("command") String command, HttpServletResponse response) {
		try {
			CuriosityBot curiosityBot = context.getBean(CuriosityBot.class);
			return curiosityBot.moveTo(command);
		} catch (InvalidRotationException | InvalidPositionException | InvalidCommandException e) {
			response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
			return "400 Bad Request";
		}
	}
}
