package com.moneytap.splittest.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import com.moneytap.splittest.Repository.ExpenseRepository;
import com.moneytap.splittest.exception.RecordNotFoundException;
import com.moneytap.splittest.model.Expense;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ExpenseService {

    @Autowired
    private ExpenseRepository expenseRepository;

    public void addexpense(Expense expense){
        expenseRepository.save(expense);
    }

    public Expense getExpenseById(int id) throws RecordNotFoundException
    {
        Optional<Expense> expense = expenseRepository.findById(id);

        if(expense.isPresent()) {
            return expense.get();
        } else {
            throw new RecordNotFoundException("No expense exist for given id");
        }
    }
    /*public List<Object[]> getbydate(Date fromDate, Date tillDate) {
        return expenseRepository.getExpenseByDate(fromDate, tillDate);}*/

    public Expense createnewExpense(Expense obj) {
        {
            Optional<Expense> expense = expenseRepository.findById(obj.getExpenseId());

            if(expense.isPresent())
            {
                Expense newEntity = expense.get();
                newEntity.setExpenseName(obj.getExpenseName());
                newEntity.setAmount(newEntity.getAmount());
                newEntity = expenseRepository.save(newEntity);

                return newEntity;
            } else {
                obj.setExpenseName(obj.getExpenseName());
                obj.setAmount(obj.getAmount());
                obj = expenseRepository.save(obj);

                return obj;
            }

        }
    }
}


