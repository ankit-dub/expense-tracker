package com.moneytap.splittest.Repository;

//import java.util.Date;
//import java.util.List;

import com.moneytap.splittest.model.Category;
//import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
//import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface CategoryRepository extends CrudRepository<Category, Integer> {

    //public Category findByCategory(String category);

	/*select c.category, SUM(e.amount)
	from CATEGORY c, Expense e
	where c.CATEGORY_ID = e.CATEGORY_ID
	group by c.CATEGORY;

    @Query("SELECT c.category, SUM(e.amount) FROM Category c, Expense e WHERE c.categoryId = e.categoryId AND e.createdDate BETWEEN :fDate AND :tDate GROUP BY c.category")
    public List<Object[]> getPieDataByDate(@Param("fDate")Date fDate, @Param("tDate")Date tDate);
*/
}

