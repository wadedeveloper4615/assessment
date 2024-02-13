package com.assessment;

import java.util.Date;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.*;
import org.springframework.test.context.junit4.SpringRunner;

import com.assessment.model.Transaction;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ApplicationTests {

	@Autowired
	private TestRestTemplate restTemplate;

	@LocalServerPort
	private int port;

	private String getRootUrl() {
		return "http://localhost:" + port;
	}

	@Test
	public void testGetAllTransactions() {
		HttpHeaders headers = new HttpHeaders();
		HttpEntity<String> entity = new HttpEntity<String>(null, headers);

		ResponseEntity<String> response = restTemplate.exchange(getRootUrl() + "/transaction",
				HttpMethod.GET, entity, String.class);

		Assert.assertNotNull(response.getBody());
	}

	@Test
	public void testGetTransactionById() {
		Transaction transaction = restTemplate.getForObject(getRootUrl() + "/transaction/1", Transaction.class);
		Assert.assertNotNull(transaction);
	}

	@Test
	public void testCreateTransaction() {
		Transaction transaction = new Transaction();
		transaction.setName("Customer 1");
		transaction.setAmount(120.00d);
		transaction.setCreatedAt(new Date());

		ResponseEntity<Transaction> postResponse = restTemplate.postForEntity(getRootUrl() + "/transaction", transaction, Transaction.class);
		Assert.assertNotNull(postResponse);
		Assert.assertNotNull(postResponse.getBody());
	}

	@Test
	public void testAddRewardsData() {
		HttpHeaders headers = new HttpHeaders();
		HttpEntity<String> entity = new HttpEntity<String>(null, headers);

		ResponseEntity<String> response = restTemplate.exchange(getRootUrl() + "/addRewardsData",
				HttpMethod.GET, entity, String.class);

		Assert.assertNotNull(response.getBody());
	}

	
	@Test
	public void testGetRewardsData() {
		HttpHeaders headers = new HttpHeaders();
		HttpEntity<String> entity = new HttpEntity<String>(null, headers);

		ResponseEntity<String> response = restTemplate.exchange(getRootUrl() + "/getAllTransactions",
				HttpMethod.GET, entity, String.class);

		Assert.assertNotNull(response.getBody());
	}
}
