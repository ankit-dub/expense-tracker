package com.moneytap.splittest.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.moneytap.splittest.Repository.CategoryRepository;
import com.moneytap.splittest.exception.RecordNotFoundException;
import com.moneytap.splittest.model.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryService {

    @Autowired
    public CategoryRepository categoryRepository;

    public Category getCategoryById(int id) throws RecordNotFoundException
    {
        Optional<Category> category = categoryRepository.findById(id);

        if(category.isPresent()) {
            return category.get();
        } else {
            throw new RecordNotFoundException("No category record exist for given id");
        }
    }
    public List<Category> getAllCategory()
    {
        List<Category> result = (List<Category>) categoryRepository.findAll();

        if(result.size() > 0) {
            return result;
        } else {
            return new ArrayList<Category>();
        }
    }

    public Category createOrUpdateEmployee(Category entity)
    {
            Optional<Category> category = categoryRepository.findById(entity.getCategoryId());

            if(category.isPresent())
            {
                Category newEntity = category.get();
                newEntity.setCategory(entity.getCategory());
                newEntity.setMessage(entity.getMessage());
                newEntity = categoryRepository.save(newEntity);

                return newEntity;
            } else {
                entity.setCategory(entity.getCategory());
                entity.setMessage(entity.getMessage());
                entity = categoryRepository.save(entity);

                return entity;
            }

    }



}

