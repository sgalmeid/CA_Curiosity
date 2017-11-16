package br.com.contaazul.curiosity.controller;

import static org.junit.Assert.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import java.io.UnsupportedEncodingException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import br.com.contaazul.curiosity.CuriosityApplication;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = { CuriosityApplication.class })
@AutoConfigureMockMvc
public class BotControllerTest {
	private static final String BAD_REQUEST = "400 Bad Request";

	@Autowired
	private MockMvc mvc;

	final String BASE_PATH = "/rest/mars";

	private String getRequest(String urlRequest) throws UnsupportedEncodingException, Exception {
		String resultRequest = mvc.perform(get(urlRequest).contentType(MediaType.TEXT_PLAIN)).andReturn().getResponse()
				.getContentAsString();
		return resultRequest;
	}

	@Test
	public void testSendCommand_MMRMMRMM() throws Exception {

		String urlRequest = BASE_PATH + "/MMRMMRMM";
		String resultRequest = getRequest(urlRequest);
		assertEquals("(2,0,S)", resultRequest);
	}

	@Test
	public void testSendCommand_MML_MML() throws UnsupportedEncodingException, Exception {
		String urlRequest = BASE_PATH + "/MML";
		String resultRequest = getRequest(urlRequest);
		assertEquals("(0,2,W)", resultRequest);
		resultRequest = getRequest(urlRequest);
		assertEquals("(0,2,W)", resultRequest);
	}

	@Test
	public void testSendCommand_AAA() throws UnsupportedEncodingException, Exception {
		String urlRequest = BASE_PATH + "/AAA";
		String resultRequest = getRequest(urlRequest);
		assertEquals(BAD_REQUEST, resultRequest);
	}

	@Test
	public void testSendCommand_MMMMMMMMMMMMMMMMMMMMMMMM() throws UnsupportedEncodingException, Exception {
		String urlRequest = BASE_PATH + "/MMMMMMMMMMMMMMMMMMMMMMMM";
		String resultRequest = getRequest(urlRequest);
		assertEquals(BAD_REQUEST, resultRequest);
	}

	@Test
	public void testSendCommand_MMMM() throws UnsupportedEncodingException, Exception {
		String urlRequest = BASE_PATH + "/MMMM";
		String resultRequest = getRequest(urlRequest);
		assertEquals("(0,4,N)", resultRequest);
	}

	@Test
	public void testSendCommand_MMMMRMMMMRMMMMRMMMMR() throws UnsupportedEncodingException, Exception {
		String urlRequest = BASE_PATH + "/MMMMRMMMMRMMMMRMMMMR";
		String resultRequest = getRequest(urlRequest);
		assertEquals("(0,0,N)", resultRequest);
	}
}
