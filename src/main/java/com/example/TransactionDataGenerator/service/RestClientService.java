package com.example.TransactionDataGenerator.service;

import com.example.TransactionDataGenerator.model.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class RestClientService {

    private final RestTemplate restTemplate;

    @Value("${app.transaction-processor.url}")
    private String transactionProcessorUrl;

    @Autowired
    public RestClientService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public void sendTransactionData(Transaction transaction) {
        restTemplate.postForObject(transactionProcessorUrl, transaction, String.class);
    }
}
