package com.moneytap.expensemanager.controller;

import com.moneytap.expensemanager.model.Transaction;
import com.moneytap.expensemanager.repositories.CategoryRepository;
import com.moneytap.expensemanager.repositories.TransactionRepository;
import com.moneytap.expensemanager.services.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.time.Instant;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/api/categories/{categoryId}/transactions")
public class TransactionController {

    @Autowired
    TransactionService transactionService;

    @Autowired
    TransactionRepository transactionRepository;

    @Autowired
    CategoryRepository categoryRepository;

    @GetMapping("")
    public ResponseEntity<List<Transaction>> getAllTransactions(HttpServletRequest request,
                                                                @PathVariable("categoryId") int categoryId) {
        int userId = (int) request.getAttribute("userId");
        List<Transaction> transactions = transactionService.fetchAllTransactions(userId, categoryId);
        return new ResponseEntity<>(transactions, HttpStatus.OK);
    }
    @GetMapping("/date")
    public ResponseEntity<List<Transaction>> getTransactionsByDate(HttpServletRequest request,
                                                                @PathVariable("categoryId") int categoryId,
                                                        @RequestBody Map<String, Object> dates) {
        int userId = (int) request.getAttribute("userId");
        String result =(String) dates.get("start");
        final DateTimeFormatter formatter = DateTimeFormatter
                .ofPattern("yyyy-MM-dd HH:mm:ss")
                .withZone(ZoneId.systemDefault());
        Instant start = Instant.from(formatter.parse(result));

        String resultend =(String) dates.get("end");
        final DateTimeFormatter formattr = DateTimeFormatter
                .ofPattern("yyyy-MM-dd HH:mm:ss")
                .withZone(ZoneId.systemDefault());
        Instant end = Instant.from(formattr.parse(resultend));
        List<Transaction> transactions = transactionRepository.findByTransactionDateBetween(start,end);
        return new ResponseEntity<>(transactions, HttpStatus.OK);
    }

    @GetMapping("/{transactionId}")
    public ResponseEntity<Transaction> getTransactionById(HttpServletRequest request,
                                                          @PathVariable("categoryId") int categoryId,
                                                          @PathVariable("transactionId") int transactionId) {
        int userId = (int) request.getAttribute("userId");
        Transaction transaction = transactionRepository.findByTransactionId(transactionId);
        return new ResponseEntity<>(transaction, HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<Transaction> addTransaction(HttpServletRequest request,
                                                      @PathVariable("categoryId") int categoryId,
                                                      @Valid @RequestBody Transaction transaction) {
        int userId = (int) request.getAttribute("userId");
        transaction.setCategory(categoryRepository.findByCategoryId(categoryId));
        transaction.setC(categoryId);
        transaction.setL(userId);
        Transaction transctn=transactionRepository.save(transaction);

        return new ResponseEntity<>(transctn, HttpStatus.CREATED);
    }
    @DeleteMapping("{transactionId}")
    public ResponseEntity<Map<String, Boolean>> deleteTransaction(@PathVariable("transactionId") int transactionId){
        transactionRepository.deleteById(transactionId);
        Map<String, Boolean> map = new HashMap<>();
        map.put("success", true);
        return new ResponseEntity<>(map, HttpStatus.OK);
    }

}