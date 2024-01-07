package com.example.TransactionDataGenerator.service;

import com.example.TransactionDataGenerator.model.Transaction;
import org.springframework.stereotype.Service;
import java.math.*;
//import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Random;

// note : amount should be a BigDecimal but I can not get RoundingMode to work.  this would be the ideal way to handle for accuracy :

//transaction.setAmount(new BigDecimal(Math.random() * 10000).setScale(2, RoundingMode.HALF_UP));


@Service
public class TransactionDataService {

    public Transaction generateTransaction() {
        Transaction transaction = new Transaction();
        transaction.setTransactionType(generateRandomTransactionType());
        double amount = Math.random() * 10000;
        double roundedAmount = Double.parseDouble(String.format("%.2f", amount));
        transaction.setAmount(roundedAmount);
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
