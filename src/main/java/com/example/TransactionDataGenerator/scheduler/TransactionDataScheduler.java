package com.example.TransactionDataGenerator.scheduler;

import com.example.TransactionDataGenerator.model.Transaction;
import com.example.TransactionDataGenerator.service.RestClientService;
import com.example.TransactionDataGenerator.service.TransactionDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class TransactionDataScheduler {
    private final TransactionDataService transactionDataService;
    private final RestClientService restClientService;

    public TransactionDataScheduler(TransactionDataService transactionDataService, RestClientService restClientService) {
        this.transactionDataService = transactionDataService;
        this.restClientService = restClientService;
    }

    @Scheduled(fixedRate = 10000) // 10 seconds
    public void generateAndSendTransaction() {
        Transaction transaction = transactionDataService.generateTransaction();
        System.out.println("***** transaction ***** : " + transaction);
        restClientService.sendTransactionData(transaction);
    }
}

