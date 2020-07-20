package com.moneytap.expensemanager.repositories;

import com.moneytap.expensemanager.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface CategoryRepository extends JpaRepository<Category,Integer> {
    List<Category> findAllByL(Integer userId);

    Category findByCategoryId(Integer categoryId);

    Category findByLAndCategoryId(Integer userId,Integer categoryId);

    void deleteByLAndCategoryId(Integer userId,Integer categoryId);
}
