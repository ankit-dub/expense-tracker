package com.moneytap.expensemanager.services;

import com.moneytap.expensemanager.exceptions.EtResourceNotFoundException;
import com.moneytap.expensemanager.model.Transaction;
import com.moneytap.expensemanager.repositories.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionService {
    @Autowired
    TransactionRepository transactionRepository;

    public List<Transaction> fetchAllTransactions(int userId, int categoryId) {
        return transactionRepository.findAllByC(categoryId);
    }
}
