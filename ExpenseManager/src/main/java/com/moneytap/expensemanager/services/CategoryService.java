package com.moneytap.expensemanager.services;

import com.moneytap.expensemanager.exceptions.EtBadRequestException;
import com.moneytap.expensemanager.exceptions.EtResourceNotFoundException;
import com.moneytap.expensemanager.model.Category;
import com.moneytap.expensemanager.repositories.CategoryRepository;
import com.moneytap.expensemanager.repositories.TransactionRepository;
import com.moneytap.expensemanager.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class CategoryService {
    @Autowired
    CategoryRepository categoryRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    TransactionRepository transactionRepository;

    public List<Category> fetchAllCategories(Integer userId) {
        return categoryRepository.findAllByL(userId);
    }

    public Category fetchCategoryById(Integer userId, Integer categoryId) throws EtResourceNotFoundException {
        return categoryRepository.findByCategoryId(categoryId);
    }

    public Category addCategory(Integer userId,Category category) throws EtBadRequestException {
        //category.setTotalExpense(transactionRepository.findSum(category.getCategoryId()));
        category.setL(userId);
        category.setUser(userRepository.findByUserId(userId));
        return categoryRepository.save(category);
    }

    public void removeCategoryWithAllTransactions(Integer userId, Integer categoryId) throws EtResourceNotFoundException {
        this.fetchCategoryById(userId, categoryId);
        categoryRepository.deleteByLAndCategoryId(userId, categoryId);
    }
}
