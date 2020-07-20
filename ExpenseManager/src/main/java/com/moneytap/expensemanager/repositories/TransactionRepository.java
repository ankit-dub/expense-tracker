package com.moneytap.expensemanager.repositories;

import com.moneytap.expensemanager.exceptions.EtResourceNotFoundException;
import com.moneytap.expensemanager.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.Instant;
import java.util.List;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction,Integer> {
    public List<Transaction> findAllByC(int categoryId);

    Transaction findByTransactionId(int transactionId) throws EtResourceNotFoundException;

    List<Transaction> findByTransactionDateBetween(Instant start,Instant end) throws EtResourceNotFoundException;

    /*@Query("SELECT SUM(t.amount) as expense FROM transactions t where c=categoryId")
    Double findSum(@Param("categoryId") int categoryId);*/
}
