package br.com.contaazul.curiosity.controller;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import br.com.contaazul.curiosity.CuriosityApplication;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = { CuriosityApplication.class })
public class BotControllerTest {

	final String BASE_PATH = "http://localhost:8080/rest/mars";

	RestTemplate restTemplate;

	@Test
	public void testSendCommand_MMRMMRMM() {
		restTemplate = new RestTemplate();
		String resultRequest = restTemplate.getForObject(BASE_PATH + "/MMRMMRMM", String.class);
		assertEquals("(2,0,S)", resultRequest);
	}

	@Test
	public void testSendCommand_MML_MML() {
		restTemplate = new RestTemplate();
		String resultRequest = restTemplate.getForObject(BASE_PATH + "/MML", String.class);
		assertEquals("(0,2,W)", resultRequest);
		resultRequest = restTemplate.getForObject(BASE_PATH + "/MML", String.class);
		assertEquals("(0,2,W)", resultRequest);
	}

	@Test
	public void testSendCommand_AAA() {
		restTemplate = new RestTemplate();
		try {
			restTemplate.getForObject(BASE_PATH + "/AAA", String.class);
		} catch (HttpClientErrorException e) {
			assertEquals("400 Bad Request", e.getResponseBodyAsString());
		}
	}

	@Test
	public void testSendCommand_MMMMMMMMMMMMMMMMMMMMMMMM() {
		restTemplate = new RestTemplate();
		try {
			restTemplate.getForObject(BASE_PATH + "/MMMMMMMMMMMMMMMMMMMMMMMM", String.class);
		} catch (HttpClientErrorException e) {
			assertEquals("400 Bad Request", e.getResponseBodyAsString());
		}

	}

	@Test
	public void testSendCommand_MMMM() {
		restTemplate = new RestTemplate();
		String resultRequest = restTemplate.getForObject(BASE_PATH + "/MMMM", String.class);
		assertEquals("(0,4,N)", resultRequest);
	}

}
