package com.example.TransactionDataGenerator.model;

import lombok.Data;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;

@Data
public class Transaction {
    private String transactionType;
    private BigDecimal amount;
    private LocalDate date;
    private LocalTime time;
    private String accountNumber;
    private String clientName;
}

