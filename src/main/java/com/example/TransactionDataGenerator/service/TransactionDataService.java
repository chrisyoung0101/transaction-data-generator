package com.example.TransactionDataGenerator.service;

import com.example.TransactionDataGenerator.model.Transaction;
import org.springframework.stereotype.Service;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Random;

@Service
public class TransactionDataService {

    public Transaction generateTransaction() {
        Transaction transaction = new Transaction();
        transaction.setTransactionType(generateRandomTransactionType());
        transaction.setAmount(new BigDecimal(Math.random() * 10000));  // Random amount
        transaction.setDate(LocalDate.now());
        transaction.setTime(LocalTime.now());
        transaction.setAccountNumber("ACC" + new Random().nextInt(9999));
        transaction.setClientName("Client_" + new Random().nextInt(9999));
        return transaction;
    }

    private String generateRandomTransactionType() {
        String[] types = {"Walk-in Deposit", "ATM Deposit","ACH Deposit", "Wire Deposit", "Check Deposit"};
        return types[new Random().nextInt(types.length)];
    }
}
