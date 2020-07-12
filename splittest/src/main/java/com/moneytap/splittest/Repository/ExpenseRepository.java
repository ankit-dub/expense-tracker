package com.moneytap.splittest.Repository;

import java.util.Date;
import java.util.List;

import com.moneytap.splittest.model.Expense;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface ExpenseRepository extends CrudRepository<Expense, Integer> {

    /*@Query("SELECT e.expense_name, e.amount, e.created_date FROM expense e WHERE BETWEEN :fromDate AND :tillDate")
    public List<Object[]> getExpenseByDate(@Param("fromDate") Date fromDate, @Param("tillDate") Date tillDate);

    @Query("select c.category from Category c")
    public List<String> getOnlyExpensename();*/

    //@Query("SELECT e.expenseName, e.amount, e.createdDate, e.comments, e.expenseId, c.category FROM Expense e, Category c WHERE c.categoryId = e.categoryId AND e.categoryId = :categoryId")
    //public List<Object[]> getExpenseByCategory(@Param("categoryId") int categoryId);

    //@Query("SELECT e.expenseName, e.amount, e.createdDate, e.comments, e.expenseId, c.category FROM Expense e, Category c WHERE c.categoryId = e.categoryId AND e.categoryId = :categoryId AND e.createdDate BETWEEN :fromDate AND :tillDate")
    //public List<Object[]> getExpenseByCategoryAndDate(@Param("fromDate") Date fromDate, @Param("tillDate") Date tillDate, @Param("categoryId") int categoryId);



}

