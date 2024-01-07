package com.example.TransactionDataGenerator.scheduler;

import com.example.TransactionDataGenerator.model.Transaction;
import com.example.TransactionDataGenerator.service.RestClientService;
import com.example.TransactionDataGenerator.service.TransactionDataService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class TransactionDataScheduler {
    private static final Logger logger = LoggerFactory.getLogger(TransactionDataScheduler.class);

    private final TransactionDataService transactionDataService;
    private final RestClientService restClientService;

    public TransactionDataScheduler(TransactionDataService transactionDataService, RestClientService restClientService) {
        this.transactionDataService = transactionDataService;
        this.restClientService = restClientService;
    }

    @Scheduled(fixedRate = 10000) // 10 seconds
    public void generateAndSendTransaction() {
        logger.info("Triggering generateAndSendTransaction method");

        Transaction transaction = transactionDataService.generateTransaction();
        logger.info(String.valueOf("Mock Data : " + transaction));

       // restClientService.sendTransactionData(transaction);
    }
}
