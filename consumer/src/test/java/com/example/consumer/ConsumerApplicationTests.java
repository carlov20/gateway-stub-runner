package com.example.consumer;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.cloud.contract.stubrunner.spring.AutoConfigureStubRunner;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.reactive.server.WebTestClient;


@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.MOCK)
@AutoConfigureWebTestClient
@AutoConfigureStubRunner(ids = "com.example:producer")
public class ConsumerApplicationTests {

	@Autowired
	private WebTestClient testClient;
	
	@Test
	public void contextLoads() {
		testClient.get().uri("/person").accept(MediaType.APPLICATION_JSON)
		.exchange()
		.expectStatus().isOk();
	}

}
