package splittest.src.main.java.com.splittest.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import splittest.src.main.java.com.splittest.Repository.ExpenseRepository;
import splittest.src.main.java.com.splittest.exception.RecordNotFoundException;
import splittest.src.main.java.com.splittest.model.Expense;
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

    public Expense updateAmount(Double amount,Expense obj) {
        {
            //Optional<Expense> expense = expenseRepository.findById(obj.getExpenseId());
                //Expense newEntity = expense.get();
                obj.setAmount(obj.getAmount()-amount);
                obj = expenseRepository.save(obj);

                return obj;
        }
    }
}


