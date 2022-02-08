package splittest.src.main.java.com.splittest.Repository;

import java.util.Date;
import java.util.List;

import splittest.src.main.java.com.splittest.model.Expense;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface ExpenseRepository extends CrudRepository<Expense, Integer> {

   /* @Query("SELECT e.expense_name, e.amount, e.created_date FROM expense e WHERE created_date BETWEEN :fromDate AND :tillDate")
    public List<Object[]> getExpenseByDate(@Param("fromDate") Date fromDate, @Param("tillDate") Date tillDate);

*/

}

